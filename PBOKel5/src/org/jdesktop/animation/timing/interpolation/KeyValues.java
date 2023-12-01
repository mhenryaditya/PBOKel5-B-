// 
// Decompiled by Procyon v0.5.36
// 
package org.jdesktop.animation.timing.interpolation;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class KeyValues<T> {

    private final List<T> values;
    private final Evaluator<T> evaluator;
    private final Class<?> type;
    private T startValue;

    public static <T> KeyValues<T> create(final T... params) {
        return new KeyValues<T>(params);
    }

    public static <T> KeyValues<T> create(final Evaluator evaluator, final T... params) {
        return new KeyValues<T>(evaluator, params);
    }

    private KeyValues(final T... params) {
        this.values = null;
//        this(Evaluator.create(params.getClass().getComponentType()), (Object[]) params);
        this.evaluator = null;
        this.type = null;
    }

    private KeyValues(final Evaluator evaluator, final T... params) {
        this.values = new ArrayList<T>();
        if (params == null) {
            throw new IllegalArgumentException("params array cannot be null");
        }
        if (params.length == 0) {
            throw new IllegalArgumentException("params array must have at least one element");
        }
        if (params.length == 1) {
            this.values.add(null);
        }
        Collections.addAll(this.values, params);
        this.type = params.getClass().getComponentType();
        this.evaluator = (Evaluator<T>) evaluator;
//        this.evaluator = null;
//        this.type = null;
    }

    int getSize() {
        return this.values.size();
    }

    Class<?> getType() {
        return this.type;
    }

    void setStartValue(final T startValue) {
        if (this.isToAnimation()) {
            this.startValue = startValue;
        }
    }

    boolean isToAnimation() {
        return this.values.get(0) == null;
    }

    T getValue(final int i0, final int i1, final float fraction) {
        T lowerValue = this.values.get(i0);
        if (lowerValue == null) {
            lowerValue = this.startValue;
        }
        T value;
        if (i0 == i1) {
            value = lowerValue;
        } else {
            final T v0 = lowerValue;
            final T v2 = this.values.get(i1);
            value = this.evaluator.evaluate(v0, v2, fraction);
        }
        return value;
    }
}
