// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

import java.awt.event.FocusEvent;
import org.jdesktop.animation.timing.Animator;
import javax.swing.JComponent;
import java.awt.event.FocusListener;

public class FocusTrigger extends Trigger implements FocusListener
{
    public static FocusTrigger addTrigger(final JComponent component, final Animator animator, final FocusTriggerEvent event) {
        return addTrigger(component, animator, event, false);
    }
    
    public static FocusTrigger addTrigger(final JComponent component, final Animator animator, final FocusTriggerEvent event, final boolean autoReverse) {
        final FocusTrigger trigger = new FocusTrigger(animator, event, autoReverse);
        component.addFocusListener(trigger);
        return trigger;
    }
    
    public FocusTrigger(final Animator animator, final FocusTriggerEvent event) {
        this(animator, event, false);
    }
    
    public FocusTrigger(final Animator animator, final FocusTriggerEvent event, final boolean autoReverse) {
        super(animator, event, autoReverse);
    }
    
    public void focusGained(final FocusEvent e) {
        this.fire(FocusTriggerEvent.IN);
    }
    
    public void focusLost(final FocusEvent e) {
        this.fire(FocusTriggerEvent.OUT);
    }
}
