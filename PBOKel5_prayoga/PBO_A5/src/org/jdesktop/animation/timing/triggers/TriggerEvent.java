// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

public class TriggerEvent
{
    private String name;
    
    protected TriggerEvent(final String name) {
        this.name = name;
    }
    
    public TriggerEvent getOppositeEvent() {
        return this;
    }
}
