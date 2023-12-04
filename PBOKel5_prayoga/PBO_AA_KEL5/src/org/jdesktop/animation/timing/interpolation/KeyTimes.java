// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing.interpolation;

import java.util.ArrayList;

public class KeyTimes
{
    private ArrayList<Float> times;
    
    public KeyTimes(final float... times) {
        this.times = new ArrayList<Float>();
        if (times[0] != 0.0f) {
            throw new IllegalArgumentException("First time value must be zero");
        }
        if (times[times.length - 1] != 1.0f) {
            throw new IllegalArgumentException("Last time value must be one");
        }
        float prevTime = 0.0f;
        for (final float time : times) {
            if (time < prevTime) {
                throw new IllegalArgumentException("Time values must be in increasing order");
            }
            this.times.add(time);
            prevTime = time;
        }
    }
    
    ArrayList getTimes() {
        return this.times;
    }
    
    int getSize() {
        return this.times.size();
    }
    
    int getInterval(final float fraction) {
        int prevIndex = 0;
        for (int i = 1; i < this.times.size(); ++i) {
            final float time = this.times.get(i);
            if (time >= fraction) {
                return prevIndex;
            }
            prevIndex = i;
        }
        return prevIndex;
    }
    
    float getTime(final int index) {
        return this.times.get(index);
    }
}
