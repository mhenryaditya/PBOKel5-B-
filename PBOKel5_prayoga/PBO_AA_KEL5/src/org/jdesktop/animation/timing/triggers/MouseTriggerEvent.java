// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

public class MouseTriggerEvent extends TriggerEvent
{
    public static final MouseTriggerEvent ENTER;
    public static final MouseTriggerEvent EXIT;
    public static final MouseTriggerEvent PRESS;
    public static final MouseTriggerEvent RELEASE;
    public static final MouseTriggerEvent CLICK;
    
    private MouseTriggerEvent(final String name) {
        super(name);
    }
    
    @Override
    public TriggerEvent getOppositeEvent() {
        if (this == MouseTriggerEvent.ENTER) {
            return MouseTriggerEvent.EXIT;
        }
        if (this == MouseTriggerEvent.EXIT) {
            return MouseTriggerEvent.ENTER;
        }
        if (this == MouseTriggerEvent.PRESS) {
            return MouseTriggerEvent.RELEASE;
        }
        if (this == MouseTriggerEvent.RELEASE) {
            return MouseTriggerEvent.PRESS;
        }
        return this;
    }
    
    static {
        ENTER = new MouseTriggerEvent("Entered");
        EXIT = new MouseTriggerEvent("Exit");
        PRESS = new MouseTriggerEvent("Press");
        RELEASE = new MouseTriggerEvent("Release");
        CLICK = new MouseTriggerEvent("Click");
    }
}
