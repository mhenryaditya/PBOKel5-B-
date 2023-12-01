// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Ellipse2D;

class EvaluatorEllipse2D extends Evaluator<Ellipse2D>
{
    public EvaluatorEllipse2D() {
    }
    
    @Override
    public Ellipse2D evaluate(final Ellipse2D v0, final Ellipse2D v1, final float fraction) {
        final double x = v0.getX() + (v1.getX() - v0.getX()) * fraction;
        final double y = v0.getY() + (v1.getY() - v0.getY()) * fraction;
        final double w = v0.getWidth() + (v1.getWidth() - v0.getWidth()) * fraction;
        final double h = v0.getHeight() + (v1.getHeight() - v0.getHeight()) * fraction;
        final Ellipse2D value = (Ellipse2D)v0.clone();
        value.setFrame(x, y, w, h);
        return value;
    }
}
