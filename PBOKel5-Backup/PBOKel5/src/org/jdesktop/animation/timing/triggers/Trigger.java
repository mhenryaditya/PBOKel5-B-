// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

import org.jdesktop.animation.timing.Animator;

public abstract class Trigger
{
    private boolean disarmed;
    private Animator animator;
    private Animator reverseAnimator;
    private TriggerEvent triggerEvent;
    private boolean autoReverse;
    
    protected Trigger(final Animator animator) {
        this(animator, null);
    }
    
    protected Trigger(final Animator animator, final TriggerEvent triggerEvent) {
        this(animator, triggerEvent, false);
    }
    
    protected Trigger(final Animator animator, final TriggerEvent triggerEvent, final boolean autoReverse) {
        this.disarmed = false;
        this.autoReverse = false;
        this.animator = animator;
        this.triggerEvent = triggerEvent;
        this.autoReverse = autoReverse;
    }
    
    public void disarm() {
        this.disarmed = true;
    }
    
    protected void fire(final TriggerEvent currentEvent) {
        if (this.disarmed) {
            return;
        }
        if (currentEvent == this.triggerEvent) {
            if (this.autoReverse) {
                if (this.animator.isRunning()) {
                    final float f = this.animator.getTimingFraction();
                    this.animator.stop();
                    this.animator.setStartFraction(f);
                }
                else {
                    this.animator.setStartFraction(0.0f);
                }
            }
            if (this.animator.isRunning()) {
                this.animator.stop();
            }
            this.animator.setStartDirection(Animator.Direction.FORWARD);
            this.fire();
        }
        else if (this.triggerEvent != null && currentEvent == this.triggerEvent.getOppositeEvent() && this.autoReverse) {
            if (this.animator.isRunning()) {
                final float f = this.animator.getTimingFraction();
                this.animator.stop();
                this.animator.setStartFraction(f);
            }
            else {
                this.animator.setStartFraction(1.0f - this.animator.getStartFraction());
            }
            this.animator.setStartDirection(Animator.Direction.BACKWARD);
            this.fire();
        }
    }
    
    protected void fire() {
        if (this.disarmed) {
            return;
        }
        if (this.animator.isRunning()) {
            this.animator.stop();
        }
        this.animator.start();
    }
}
