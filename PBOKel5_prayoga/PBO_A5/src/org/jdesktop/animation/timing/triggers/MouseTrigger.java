// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

import java.awt.event.MouseEvent;
import org.jdesktop.animation.timing.Animator;
import javax.swing.JComponent;
import java.awt.event.MouseListener;

public class MouseTrigger extends Trigger implements MouseListener
{
    public static MouseTrigger addTrigger(final JComponent component, final Animator animator, final MouseTriggerEvent event) {
        return addTrigger(component, animator, event, false);
    }
    
    public static MouseTrigger addTrigger(final JComponent component, final Animator animator, final MouseTriggerEvent event, final boolean autoReverse) {
        final MouseTrigger trigger = new MouseTrigger(animator, event, autoReverse);
        component.addMouseListener(trigger);
        return trigger;
    }
    
    public MouseTrigger(final Animator animator, final MouseTriggerEvent event) {
        this(animator, event, false);
    }
    
    public MouseTrigger(final Animator animator, final MouseTriggerEvent event, final boolean autoReverse) {
        super(animator, event, autoReverse);
    }
    
    public void mouseEntered(final MouseEvent e) {
        this.fire(MouseTriggerEvent.ENTER);
    }
    
    public void mouseExited(final MouseEvent e) {
        this.fire(MouseTriggerEvent.EXIT);
    }
    
    public void mousePressed(final MouseEvent e) {
        this.fire(MouseTriggerEvent.PRESS);
    }
    
    public void mouseReleased(final MouseEvent e) {
        this.fire(MouseTriggerEvent.RELEASE);
    }
    
    public void mouseClicked(final MouseEvent e) {
        this.fire(MouseTriggerEvent.CLICK);
    }
}
