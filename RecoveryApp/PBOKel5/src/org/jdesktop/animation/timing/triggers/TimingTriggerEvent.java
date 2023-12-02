// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

public class TimingTriggerEvent extends TriggerEvent
{
    public static final TimingTriggerEvent START;
    public static final TimingTriggerEvent STOP;
    public static final TimingTriggerEvent REPEAT;
    
    private TimingTriggerEvent(final String name) {
        super(name);
    }
    
    @Override
    public TriggerEvent getOppositeEvent() {
        if (this.equals(TimingTriggerEvent.START)) {
            return TimingTriggerEvent.STOP;
        }
        if (this.equals(TimingTriggerEvent.STOP)) {
            return TimingTriggerEvent.START;
        }
        return this;
    }
    
    static {
        START = new TimingTriggerEvent("Start");
        STOP = new TimingTriggerEvent("Stop");
        REPEAT = new TimingTriggerEvent("Repeat");
    }
}
