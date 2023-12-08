// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.beans.PropertyDescriptor;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.Animator;
import java.lang.reflect.Method;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class PropertySetter extends TimingTargetAdapter
{
    private Object object;
    private String propertyName;
    private KeyFrames keyFrames;
    private Method propertySetter;
    private Method propertyGetter;
    
    public static Animator createAnimator(final int duration, final Object object, final String propertyName, final KeyFrames keyFrames) {
        final PropertySetter ps = new PropertySetter(object, propertyName, keyFrames);
        final Animator animator = new Animator(duration, ps);
        return animator;
    }
    
    public static <T> Animator createAnimator(final int duration, final Object object, final String propertyName, final T... params) {
        final PropertySetter ps = new PropertySetter(object, propertyName, (T[])params);
        final Animator animator = new Animator(duration, ps);
        return animator;
    }
    
    public static <T> Animator createAnimator(final int duration, final Object object, final String propertyName, final Evaluator evaluator, final T... params) {
        final PropertySetter ps = new PropertySetter(object, propertyName, evaluator, (T[])params);
        final Animator animator = new Animator(duration, ps);
        return animator;
    }
    
    public PropertySetter(final Object object, final String propertyName, final KeyFrames keyFrames) {
        this.object = object;
        this.propertyName = propertyName;
        this.keyFrames = keyFrames;
        try {
            this.setupMethodInfo();
        }
        catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Bad property name (" + propertyName + "): could not find " + "an appropriate setter or getter method for that property");
        }
    }
    
    public <T> PropertySetter(final Object object, final String propertyName, final T... params) {
        this(object, propertyName, new KeyFrames(KeyValues.create(params)));
    }
    
    public <T> PropertySetter(final Object object, final String propertyName, final Evaluator evaluator, final T... params) {
        this(object, propertyName, new KeyFrames(KeyValues.create(evaluator, params)));
    }
    
    private void setupMethodInfo() throws NoSuchMethodException {
        try {
            final String firstChar = this.propertyName.substring(0, 1);
            final String remainder = this.propertyName.substring(1);
            final Class propertyType = this.getType();
            final String propertySetterName = "set" + firstChar.toUpperCase() + remainder;
            PropertyDescriptor prop = new PropertyDescriptor(this.propertyName, this.object.getClass(), null, propertySetterName);
            this.propertySetter = prop.getWriteMethod();
            if (this.isToAnimation()) {
                final String propertyGetterName = "get" + firstChar.toUpperCase() + remainder;
                prop = new PropertyDescriptor(this.propertyName, this.object.getClass(), propertyGetterName, null);
                this.propertyGetter = prop.getReadMethod();
            }
        }
        catch (Exception e) {
            throw new NoSuchMethodException("Cannot find property methods: " + e);
        }
    }
    
    @Override
    public void begin() {
        if (this.isToAnimation()) {
            try {
                this.setStartValue(this.propertyGetter.invoke(this.object, new Object[0]));
            }
            catch (Exception e) {
                System.out.println("Problem with propertySetter in ObjectModifier");
            }
        }
    }
    
    @Override
    public void timingEvent(final float fraction) {
        try {
            this.setValue(this.object, this.propertySetter, fraction);
        }
        catch (Exception e) {
            System.out.println("Problem in ObjectModifier.timingEvent: " + e);
        }
    }
    
    private String getPropertyName() {
        return this.propertyName;
    }
    
    private void setStartValue(final Object object) {
        this.keyFrames.getKeyValues().setStartValue(object);
    }
    
    private void setValue(final Object object, final Method method, final float fraction) {
        try {
            method.invoke(object, this.keyFrames.getValue(fraction));
        }
        catch (Exception e) {
            System.out.println("Problem invoking method " + this.propertySetter + " in object " + object + " in setValue" + e);
        }
    }
    
    private Class getType() {
        return this.keyFrames.getType();
    }
    
    private boolean isToAnimation() {
        return this.keyFrames.getKeyValues().isToAnimation();
    }
}
