// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Line2D;

class EvaluatorLine2D extends Evaluator<Line2D>
{
    public EvaluatorLine2D() {
    }
    
    @Override
    public Line2D evaluate(final Line2D v0, final Line2D v1, final float fraction) {
        final double x1 = v0.getX1() + (v1.getX1() - v0.getX1()) * fraction;
        final double y1 = v0.getY1() + (v1.getY1() - v0.getY1()) * fraction;
        final double x2 = v0.getX2() + (v1.getX2() - v0.getX2()) * fraction;
        final double y2 = v0.getY2() + (v1.getY2() - v0.getY2()) * fraction;
        final Line2D value = (Line2D)v0.clone();
        value.setLine(x1, y1, x2, y2);
        return value;
    }
}
