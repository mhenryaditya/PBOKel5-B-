// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing;

public interface TimingTarget
{
    void timingEvent(final float p0);
    
    void begin();
    
    void end();
    
    void repeat();
}
