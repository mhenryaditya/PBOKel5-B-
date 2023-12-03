// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.CubicCurve2D;

class EvaluatorCubicCurve2D extends Evaluator<CubicCurve2D>
{
    public EvaluatorCubicCurve2D() {
    }
    
    @Override
    public CubicCurve2D evaluate(final CubicCurve2D v0, final CubicCurve2D v1, final float fraction) {
        final double x1 = v0.getX1() + (v1.getX1() - v0.getX1()) * fraction;
        final double y1 = v0.getY1() + (v1.getY1() - v0.getY1()) * fraction;
        final double x2 = v0.getX2() + (v1.getX2() - v0.getX2()) * fraction;
        final double y2 = v0.getY2() + (v1.getY2() - v0.getY2()) * fraction;
        final double ctrlx1 = v0.getCtrlX1() + (v1.getCtrlX1() - v0.getCtrlX1()) * fraction;
        final double ctrly1 = v0.getCtrlY1() + (v1.getCtrlY1() - v0.getCtrlY1()) * fraction;
        final double ctrlx2 = v0.getCtrlX2() + (v1.getCtrlX2() - v0.getCtrlX2()) * fraction;
        final double ctrly2 = v0.getCtrlY2() + (v1.getCtrlY2() - v0.getCtrlY2()) * fraction;
        final CubicCurve2D value = (CubicCurve2D)v0.clone();
        value.setCurve(x1, y1, ctrlx1, ctrly1, ctrlx2, ctrly2, x2, y2);
        return value;
    }
}
