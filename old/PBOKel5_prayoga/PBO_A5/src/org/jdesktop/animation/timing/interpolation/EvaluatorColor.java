// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.Color;

class EvaluatorColor extends Evaluator<Color>
{
    public EvaluatorColor() {
    }
    
    @Override
    public Color evaluate(final Color v0, final Color v1, final float fraction) {
        final int r = v0.getRed() + (int)((v1.getRed() - v0.getRed()) * fraction + 0.5f);
        final int g = v0.getGreen() + (int)((v1.getGreen() - v0.getGreen()) * fraction + 0.5f);
        final int b = v0.getBlue() + (int)((v1.getBlue() - v0.getBlue()) * fraction + 0.5f);
        final int a = v0.getAlpha() + (int)((v1.getAlpha() - v0.getAlpha()) * fraction + 0.5f);
        final Color value = new Color(r, g, b, a);
        return value;
    }
}
