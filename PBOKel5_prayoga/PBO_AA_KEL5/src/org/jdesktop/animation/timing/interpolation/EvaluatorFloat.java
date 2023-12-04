// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorFloat extends Evaluator<Float>
{
    public EvaluatorFloat() {
    }
    
    @Override
    public Float evaluate(final Float v0, final Float v1, final float fraction) {
        return v0 + (v1 - v0) * fraction;
    }
}
