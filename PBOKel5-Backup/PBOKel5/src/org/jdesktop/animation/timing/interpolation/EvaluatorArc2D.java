// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Arc2D;

class EvaluatorArc2D extends Evaluator<Arc2D>
{
    public EvaluatorArc2D() {
    }
    
    @Override
    public Arc2D evaluate(final Arc2D v0, final Arc2D v1, final float fraction) {
        final double x = v0.getX() + (v1.getX() - v0.getX()) * fraction;
        final double y = v0.getY() + (v1.getY() - v0.getY()) * fraction;
        final double w = v0.getWidth() + (v1.getWidth() - v0.getWidth()) * fraction;
        final double h = v0.getHeight() + (v1.getHeight() - v0.getHeight()) * fraction;
        final double start = v0.getAngleStart() + (v1.getAngleStart() - v0.getAngleStart()) * fraction;
        final double extent = v0.getAngleExtent() + (v1.getAngleExtent() - v0.getAngleExtent()) * fraction;
        final Arc2D value = (Arc2D)v0.clone();
        value.setArc(x, y, w, h, start, extent, v0.getArcType());
        return value;
    }
}
