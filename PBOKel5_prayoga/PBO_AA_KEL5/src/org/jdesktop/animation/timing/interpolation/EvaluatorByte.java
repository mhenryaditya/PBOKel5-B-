// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

class EvaluatorByte extends Evaluator<Byte>
{
    public EvaluatorByte() {
    }
    
    @Override
    public Byte evaluate(final Byte v0, final Byte v1, final float fraction) {
        return (byte)((byte)v0 + (byte)(((byte)v1 - (byte)v0) * fraction));
    }
}
