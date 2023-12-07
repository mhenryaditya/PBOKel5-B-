// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorDouble extends Evaluator<Double>
{
    public EvaluatorDouble() {
    }
    
    @Override
    public Double evaluate(final Double v0, final Double v1, final float fraction) {
        return v0 + (v1 - v0) * fraction;
    }
}
