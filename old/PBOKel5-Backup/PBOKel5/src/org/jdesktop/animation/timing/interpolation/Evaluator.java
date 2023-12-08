// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.util.HashMap;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;

public abstract class Evaluator<T>
{
    private static final Map<Class<?>, Class<? extends Evaluator>> impls;
    
    private static void register(final Class<?> type, final Class<? extends Evaluator> impl) {
        Evaluator.impls.put(type, impl);
    }
    
    private static void deregister(final Class<?> type) {
        Evaluator.impls.remove(type);
    }
    
    static <T> Evaluator<T> create(final Class<?> type) {
        Class<? extends Evaluator> interpClass = null;
        for (final Class<?> klass : Evaluator.impls.keySet()) {
            if (klass.isAssignableFrom(type)) {
                interpClass = Evaluator.impls.get(klass);
                break;
            }
        }
        if (interpClass == null) {
            throw new IllegalArgumentException("No Evaluator can be found for type " + type + "; consider using" + " different types for your values or supplying a custom" + " Evaluator");
        }
        try {
            final Constructor<? extends Evaluator> ctor = interpClass.getConstructor((Class<?>[])new Class[0]);
            return (Evaluator<T>)ctor.newInstance(new Object[0]);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Problem constructing appropriate Evaluator for type " + type + ":", e);
        }
    }
    
    public abstract T evaluate(final T p0, final T p1, final float p2);
    
    static {
        (impls = new HashMap<Class<?>, Class<? extends Evaluator>>()).put(Byte.class, EvaluatorByte.class);
        Evaluator.impls.put(Short.class, EvaluatorShort.class);
        Evaluator.impls.put(Integer.class, EvaluatorInteger.class);
        Evaluator.impls.put(Long.class, EvaluatorLong.class);
        Evaluator.impls.put(Float.class, EvaluatorFloat.class);
        Evaluator.impls.put(Double.class, EvaluatorDouble.class);
        Evaluator.impls.put(Color.class, EvaluatorColor.class);
        Evaluator.impls.put(Point2D.class, EvaluatorPoint2D.class);
        Evaluator.impls.put(Line2D.class, EvaluatorLine2D.class);
        Evaluator.impls.put(Dimension2D.class, EvaluatorDimension2D.class);
        Evaluator.impls.put(Rectangle2D.class, EvaluatorRectangle2D.class);
        Evaluator.impls.put(RoundRectangle2D.class, EvaluatorRoundRectangle2D.class);
        Evaluator.impls.put(Ellipse2D.class, EvaluatorEllipse2D.class);
        Evaluator.impls.put(Arc2D.class, EvaluatorArc2D.class);
        Evaluator.impls.put(QuadCurve2D.class, EvaluatorQuadCurve2D.class);
        Evaluator.impls.put(CubicCurve2D.class, EvaluatorCubicCurve2D.class);
    }
}
