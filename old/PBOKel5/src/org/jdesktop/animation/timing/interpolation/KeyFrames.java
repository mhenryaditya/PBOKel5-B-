// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

public class KeyFrames
{
    private KeyValues keyValues;
    private KeyTimes keyTimes;
    private KeyInterpolators interpolators;
    
    public KeyFrames(final KeyValues keyValues) {
        this.init(keyValues, null, null);
    }
    
    public KeyFrames(final KeyValues keyValues, final KeyTimes keyTimes) {
        this.init(keyValues, keyTimes, null);
    }
    
    public KeyFrames(final KeyValues keyValues, final KeyTimes keyTimes, final Interpolator... interpolators) {
        this.init(keyValues, keyTimes, interpolators);
    }
    
    public KeyFrames(final KeyValues keyValues, final Interpolator... interpolators) {
        this.init(keyValues, null, interpolators);
    }
    
    private void init(final KeyValues keyValues, final KeyTimes keyTimes, final Interpolator... interpolators) {
        final int numFrames = keyValues.getSize();
        if (keyTimes == null) {
            final float[] keyTimesArray = new float[numFrames];
            float timeVal = 0.0f;
            keyTimesArray[0] = timeVal;
            for (int i = 1; i < numFrames - 1; ++i) {
                timeVal += 1.0f / (numFrames - 1);
                keyTimesArray[i] = timeVal;
            }
            keyTimesArray[numFrames - 1] = 1.0f;
            this.keyTimes = new KeyTimes(keyTimesArray);
        }
        else {
            this.keyTimes = keyTimes;
        }
        this.keyValues = keyValues;
        if (numFrames != this.keyTimes.getSize()) {
            throw new IllegalArgumentException("keyValues and keyTimes must be of equal size");
        }
        if (interpolators != null && interpolators.length != numFrames - 1 && interpolators.length != 1) {
            throw new IllegalArgumentException("interpolators must be either null (implying interpolation for all intervals), a single interpolator (which will be used for all intervals), or a number of interpolators equal to one less than the number of times.");
        }
        this.interpolators = new KeyInterpolators(numFrames - 1, interpolators);
    }
    
    Class getType() {
        return this.keyValues.getType();
    }
    
    KeyValues getKeyValues() {
        return this.keyValues;
    }
    
    KeyTimes getKeyTimes() {
        return this.keyTimes;
    }
    
    public int getInterval(final float fraction) {
        return this.keyTimes.getInterval(fraction);
    }
    
    Object getValue(final float fraction) {
        final int interval = this.getInterval(fraction);
        final float t0 = this.keyTimes.getTime(interval);
        final float t2 = this.keyTimes.getTime(interval + 1);
        final float t3 = (fraction - t0) / (t2 - t0);
        float interpolatedT = this.interpolators.interpolate(interval, t3);
        if (interpolatedT < 0.0f) {
            interpolatedT = 0.0f;
        }
        else if (interpolatedT > 1.0f) {
            interpolatedT = 1.0f;
        }
        return this.keyValues.getValue(interval, interval + 1, interpolatedT);
    }
}
