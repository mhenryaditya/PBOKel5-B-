// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.RoundRectangle2D;

class EvaluatorRoundRectangle2D extends Evaluator<RoundRectangle2D>
{
    public EvaluatorRoundRectangle2D() {
    }
    
    @Override
    public RoundRectangle2D evaluate(final RoundRectangle2D v0, final RoundRectangle2D v1, final float fraction) {
        final double x = v0.getX() + (v1.getX() - v0.getX()) * fraction;
        final double y = v0.getY() + (v1.getY() - v0.getY()) * fraction;
        final double w = v0.getWidth() + (v1.getWidth() - v0.getWidth()) * fraction;
        final double h = v0.getHeight() + (v1.getHeight() - v0.getHeight()) * fraction;
        final double arcw = v0.getArcWidth() + (v1.getArcWidth() - v0.getArcWidth()) * fraction;
        final double arch = v0.getArcHeight() + (v1.getArcHeight() - v0.getArcHeight()) * fraction;
        final RoundRectangle2D value = (RoundRectangle2D)v0.clone();
        value.setRoundRect(x, y, w, h, arcw, arch);
        return value;
    }
}
