// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;

public class TimingTrigger extends Trigger implements TimingTarget
{
    private Animator source;
    private TimingTriggerEvent event;
    
    public static TimingTrigger addTrigger(final Animator source, final Animator target, final TimingTriggerEvent event) {
        return addTrigger(source, target, event, false);
    }
    
    public static TimingTrigger addTrigger(final Animator source, final Animator target, final TimingTriggerEvent event, final boolean autoReverse) {
        final TimingTrigger trigger = new TimingTrigger(target, event, autoReverse);
        source.addTarget(trigger);
        return trigger;
    }
    
    public TimingTrigger(final Animator animator, final TimingTriggerEvent event) {
        this(animator, event, false);
    }
    
    public TimingTrigger(final Animator animator, final TimingTriggerEvent event, final boolean autoReverse) {
        super(animator, event, autoReverse);
    }
    
    public void timingEvent(final float fraction) {
    }
    
    public void begin() {
        this.fire(TimingTriggerEvent.START);
    }
    
    public void end() {
        this.fire(TimingTriggerEvent.STOP);
    }
    
    public void repeat() {
        this.fire(TimingTriggerEvent.REPEAT);
    }
}
