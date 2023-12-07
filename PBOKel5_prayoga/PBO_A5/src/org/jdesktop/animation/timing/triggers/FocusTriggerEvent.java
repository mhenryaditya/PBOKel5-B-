// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

public class FocusTriggerEvent extends TriggerEvent
{
    public static final FocusTriggerEvent IN;
    public static final FocusTriggerEvent OUT;
    
    private FocusTriggerEvent(final String name) {
        super(name);
    }
    
    @Override
    public TriggerEvent getOppositeEvent() {
        if (this == FocusTriggerEvent.IN) {
            return FocusTriggerEvent.OUT;
        }
        return FocusTriggerEvent.IN;
    }
    
    static {
        IN = new FocusTriggerEvent("FocusIn");
        OUT = new FocusTriggerEvent("FocusOut");
    }
}
