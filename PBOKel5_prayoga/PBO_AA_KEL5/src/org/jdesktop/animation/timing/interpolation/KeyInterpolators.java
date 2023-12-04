// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.util.ArrayList;

class KeyInterpolators
{
    private ArrayList<Interpolator> interpolators;
    
    KeyInterpolators(final int numIntervals, final Interpolator... interpolators) {
        this.interpolators = new ArrayList<Interpolator>();
        if (interpolators == null || interpolators[0] == null) {
            for (int i = 0; i < numIntervals; ++i) {
                this.interpolators.add(LinearInterpolator.getInstance());
            }
        }
        else if (interpolators.length < numIntervals) {
            for (int i = 0; i < numIntervals; ++i) {
                this.interpolators.add(interpolators[0]);
            }
        }
        else {
            for (int i = 0; i < numIntervals; ++i) {
                this.interpolators.add(interpolators[i]);
            }
        }
    }
    
    float interpolate(final int interval, final float fraction) {
        return this.interpolators.get(interval).interpolate(fraction);
    }
}
