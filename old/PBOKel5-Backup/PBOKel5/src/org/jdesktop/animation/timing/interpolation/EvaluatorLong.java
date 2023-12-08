// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorLong extends Evaluator<Long>
{
    public EvaluatorLong() {
    }
    
    @Override
    public Long evaluate(final Long v0, final Long v1, final float fraction) {
        return v0 + (long)((v1 - v0) * fraction);
    }
}
