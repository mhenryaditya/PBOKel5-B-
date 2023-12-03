// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.triggers;

import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import org.jdesktop.animation.timing.Animator;
import java.awt.event.ActionListener;

public class ActionTrigger extends Trigger implements ActionListener
{
    public static ActionTrigger addTrigger(final Object object, final Animator animator) {
        final ActionTrigger trigger = new ActionTrigger(animator);
        try {
            final Method addListenerMethod = object.getClass().getMethod("addActionListener", ActionListener.class);
            addListenerMethod.invoke(object, trigger);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Problem adding listener to object: " + e);
        }
        return trigger;
    }
    
    public ActionTrigger(final Animator animator) {
        super(animator);
    }
    
    public void actionPerformed(final ActionEvent ae) {
        this.fire();
    }
}
