// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing;

import java.util.Iterator;
import java.util.ArrayList;

public abstract class TimingSource
{
    private ArrayList<TimingEventListener> listeners;
    
    public TimingSource() {
        this.listeners = new ArrayList<TimingEventListener>();
    }
    
    public abstract void start();
    
    public abstract void stop();
    
    public abstract void setResolution(final int p0);
    
    public abstract void setStartDelay(final int p0);
    
    public final void addEventListener(final TimingEventListener listener) {
        synchronized (this.listeners) {
            if (!this.listeners.contains(listener)) {
                this.listeners.add(listener);
            }
        }
    }
    
    public final void removeEventListener(final TimingEventListener listener) {
        synchronized (this.listeners) {
            this.listeners.remove(listener);
        }
    }
    
    protected final void timingEvent() {
        synchronized (this.listeners) {
            for (final TimingEventListener listener : this.listeners) {
                listener.timingSourceEvent(this);
            }
        }
    }
}
