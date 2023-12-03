// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Point2D;

class EvaluatorPoint2D extends Evaluator<Point2D>
{
    private Point2D value;
    
    public EvaluatorPoint2D() {
    }
    
    @Override
    public Point2D evaluate(final Point2D v0, final Point2D v1, final float fraction) {
        if (this.value == null) {
            this.value = (Point2D)v0.clone();
        }
        final double x = v0.getX() + (v1.getX() - v0.getX()) * fraction;
        final double y = v0.getY() + (v1.getY() - v0.getY()) * fraction;
        this.value.setLocation(x, y);
        return this.value;
    }
}
