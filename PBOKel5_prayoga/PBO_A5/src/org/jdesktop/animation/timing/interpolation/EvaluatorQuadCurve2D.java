// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.QuadCurve2D;

class EvaluatorQuadCurve2D extends Evaluator<QuadCurve2D>
{
    public EvaluatorQuadCurve2D() {
    }
    
    @Override
    public QuadCurve2D evaluate(final QuadCurve2D v0, final QuadCurve2D v1, final float fraction) {
        final double x1 = v0.getX1() + (v1.getX1() - v0.getX1()) * fraction;
        final double y1 = v0.getY1() + (v1.getY1() - v0.getY1()) * fraction;
        final double x2 = v0.getX2() + (v1.getX2() - v0.getX2()) * fraction;
        final double y2 = v0.getY2() + (v1.getY2() - v0.getY2()) * fraction;
        final double ctrlx = v0.getCtrlX() + (v1.getCtrlX() - v0.getCtrlX()) * fraction;
        final double ctrly = v0.getCtrlY() + (v1.getCtrlY() - v0.getCtrlY()) * fraction;
        final QuadCurve2D value = (QuadCurve2D)v0.clone();
        value.setCurve(x1, y1, ctrlx, ctrly, x2, y2);
        return value;
    }
}
