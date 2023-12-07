// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorInteger extends Evaluator<Integer>
{
    public EvaluatorInteger() {
    }
    
    @Override
    public Integer evaluate(final Integer v0, final Integer v1, final float fraction) {
        return v0 + (int)((v1 - v0) * fraction);
    }
}
