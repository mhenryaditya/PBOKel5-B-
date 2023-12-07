// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public final class SplineInterpolator implements Interpolator
{
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private ArrayList lengths;
    
    public SplineInterpolator(final float x1, final float y1, final float x2, final float y2) {
        this.lengths = new ArrayList();
        if (x1 < 0.0f || x1 > 1.0f || y1 < 0.0f || y1 > 1.0f || x2 < 0.0f || x2 > 1.0f || y2 < 0.0f || y2 > 1.0f) {
            throw new IllegalArgumentException("Control points must be in the range [0, 1]:");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        float prevX = 0.0f;
        float prevY = 0.0f;
        float prevLength = 0.0f;
        for (float t = 0.01f; t <= 1.0f; t += 0.01f) {
            final Point2D.Float xy = this.getXY(t);
            final float length = prevLength + (float)Math.sqrt((xy.x - prevX) * (xy.x - prevX) + (xy.y - prevY) * (xy.y - prevY));
            final LengthItem lengthItem = new LengthItem(length, t);
            this.lengths.add(lengthItem);
            prevLength = length;
            prevX = xy.x;
            prevY = xy.y;
        }
        for (int i = 0; i < this.lengths.size(); ++i) {
            final LengthItem lengthItem2 = (LengthItem) this.lengths.get(i);
            lengthItem2.setFraction(prevLength);
        }
    }
    
    private Point2D.Float getXY(final float t) {
        final float invT = 1.0f - t;
        final float b1 = 3.0f * t * (invT * invT);
        final float b2 = 3.0f * (t * t) * invT;
        final float b3 = t * t * t;
        final Point2D.Float xy = new Point2D.Float(b1 * this.x1 + b2 * this.x2 + b3, b1 * this.y1 + b2 * this.y2 + b3);
        return xy;
    }
    
    private float getY(final float t) {
        final float invT = 1.0f - t;
        final float b1 = 3.0f * t * (invT * invT);
        final float b2 = 3.0f * (t * t) * invT;
        final float b3 = t * t * t;
        return b1 * this.y1 + b2 * this.y2 + b3;
    }
    
    public float interpolate(final float lengthFraction) {
        float interpolatedT = 1.0f;
        float prevT = 0.0f;
        float prevLength = 0.0f;
        for (int i = 0; i < this.lengths.size(); ++i) {
            final LengthItem lengthItem = (LengthItem) this.lengths.get(i);
            final float fraction = lengthItem.getFraction();
            final float t = lengthItem.getT();
            if (lengthFraction <= fraction) {
                final float proportion = (lengthFraction - prevLength) / (fraction - prevLength);
                interpolatedT = prevT + proportion * (t - prevT);
                return this.getY(interpolatedT);
            }
            prevLength = fraction;
            prevT = t;
        }
        return this.getY(interpolatedT);
    }
}
