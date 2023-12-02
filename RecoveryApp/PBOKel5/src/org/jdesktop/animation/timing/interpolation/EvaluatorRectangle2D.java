// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Rectangle2D;

class EvaluatorRectangle2D extends Evaluator<Rectangle2D>
{
    public EvaluatorRectangle2D() {
    }
    
    @Override
    public Rectangle2D evaluate(final Rectangle2D v0, final Rectangle2D v1, final float fraction) {
        final double x = v0.getX() + (v1.getX() - v0.getX()) * fraction;
        final double y = v0.getY() + (v1.getY() - v0.getY()) * fraction;
        final double w = v0.getWidth() + (v1.getWidth() - v0.getWidth()) * fraction;
        final double h = v0.getHeight() + (v1.getHeight() - v0.getHeight()) * fraction;
        final Rectangle2D value = (Rectangle2D)v0.clone();
        value.setRect(x, y, w, h);
        return value;
    }
}
