// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Dimension2D;

class EvaluatorDimension2D extends Evaluator<Dimension2D>
{
    public EvaluatorDimension2D() {
    }
    
    @Override
    public Dimension2D evaluate(final Dimension2D v0, final Dimension2D v1, final float fraction) {
        final double w = v0.getWidth() + (v1.getWidth() - v0.getWidth()) * fraction;
        final double h = v0.getHeight() + (v1.getHeight() - v0.getHeight()) * fraction;
        final Dimension2D value = (Dimension2D)v0.clone();
        value.setSize(w, h);
        return value;
    }
}
