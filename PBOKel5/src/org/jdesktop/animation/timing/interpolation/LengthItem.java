// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class LengthItem
{
    float length;
    float t;
    float fraction;
    
    LengthItem(final float length, final float t, final float fraction) {
        this.length = length;
        this.t = t;
        this.fraction = fraction;
    }
    
    LengthItem(final float length, final float t) {
        this.length = length;
        this.t = t;
    }
    
    public float getLength() {
        return this.length;
    }
    
    public float getT() {
        return this.t;
    }
    
    public float getFraction() {
        return this.fraction;
    }
    
    void setFraction(final float totalLength) {
        this.fraction = this.length / totalLength;
    }
}
