// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorShort extends Evaluator<Short>
{
    public EvaluatorShort() {
    }
    
    @Override
    public Short evaluate(final Short v0, final Short v1, final float fraction) {
        return (short)((short)v0 + (short)(((short)v1 - (short)v0) * fraction));
    }
}
