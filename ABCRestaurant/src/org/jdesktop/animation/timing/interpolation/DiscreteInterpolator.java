// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

public final class DiscreteInterpolator implements Interpolator
{
    private static DiscreteInterpolator instance;
    
    private DiscreteInterpolator() {
    }
    
    public static DiscreteInterpolator getInstance() {
        if (DiscreteInterpolator.instance == null) {
            DiscreteInterpolator.instance = new DiscreteInterpolator();
        }
        return DiscreteInterpolator.instance;
    }
    
    public float interpolate(final float fraction) {
        if (fraction < 1.0f) {
            return 0.0f;
        }
        return 1.0f;
    }
    
    static {
        DiscreteInterpolator.instance = null;
    }
}
