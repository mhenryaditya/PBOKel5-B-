// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

public final class LinearInterpolator implements Interpolator
{
    private static LinearInterpolator instance;
    
    private LinearInterpolator() {
    }
    
    public static LinearInterpolator getInstance() {
        if (LinearInterpolator.instance == null) {
            LinearInterpolator.instance = new LinearInterpolator();
        }
        return LinearInterpolator.instance;
    }
    
    public float interpolate(final float fraction) {
        return fraction;
    }
    
    static {
        LinearInterpolator.instance = null;
    }
}
