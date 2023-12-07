// 
// Decompiled by Procyon v0.5.36
// 

package org.jdesktop.animation.timing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Toolkit;
import org.jdesktop.animation.timing.interpolation.LinearInterpolator;
import org.jdesktop.animation.timing.interpolation.Interpolator;
import java.util.ArrayList;

public final class Animator
{
    private TimingSource timer;
    private TimingSource swingTimer;
    private TimingSourceTarget timingSourceTarget;
    private ArrayList<TimingTarget> targets;
    private long startTime;
    private long currentStartTime;
    private int currentCycle;
    private boolean intRepeatCount;
    private boolean timeToStop;
    private boolean hasBegun;
    private long pauseBeginTime;
    private boolean running;
    private double repeatCount;
    private int startDelay;
    private RepeatBehavior repeatBehavior;
    private EndBehavior endBehavior;
    private int duration;
    private int resolution;
    private float acceleration;
    private float deceleration;
    private float startFraction;
    private Direction direction;
    private Interpolator interpolator;
    public static final int INFINITE = -1;
    
    private void validateRepeatCount(final double repeatCount) {
        if (repeatCount < 1.0 && repeatCount != -1.0) {
            throw new IllegalArgumentException("repeatCount (" + repeatCount + ") cannot be <= 0");
        }
    }
    
    public Animator(final int duration) {
        this(duration, null);
    }
    
    public Animator(final int duration, final TimingTarget target) {
        this.targets = new ArrayList<TimingTarget>();
        this.currentCycle = 0;
        this.intRepeatCount = true;
        this.timeToStop = false;
        this.hasBegun = false;
        this.pauseBeginTime = 0L;
        this.running = false;
        this.repeatCount = 1.0;
        this.repeatBehavior = RepeatBehavior.REVERSE;
        this.endBehavior = EndBehavior.HOLD;
        this.resolution = 20;
        this.acceleration = 0.0f;
        this.deceleration = 0.0f;
        this.startFraction = 0.0f;
        this.direction = Direction.FORWARD;
        this.interpolator = LinearInterpolator.getInstance();
        this.duration = duration;
        this.addTarget(target);
        final Toolkit tk = Toolkit.getDefaultToolkit();
        this.swingTimer = new SwingTimingSource();
        this.timer = this.swingTimer;
    }
    
    public Animator(final int duration, final double repeatCount, final RepeatBehavior repeatBehavior, final TimingTarget target) {
        this(duration, target);
        this.validateRepeatCount(repeatCount);
        this.repeatCount = repeatCount;
        this.repeatBehavior = ((repeatBehavior != null) ? repeatBehavior : RepeatBehavior.REVERSE);
        this.intRepeatCount = (Math.rint(repeatCount) == repeatCount);
    }
    
    public Direction getStartDirection() {
        return this.direction;
    }
    
    public void setStartDirection(final Direction startDirection) {
        this.throwExceptionIfRunning();
        this.direction = startDirection;
    }
    
    public Interpolator getInterpolator() {
        return this.interpolator;
    }
    
    public void setInterpolator(final Interpolator interpolator) {
        this.throwExceptionIfRunning();
        this.interpolator = interpolator;
    }
    
    public void setAcceleration(final float acceleration) {
        this.throwExceptionIfRunning();
        if (acceleration < 0.0f || acceleration > 1.0f) {
            throw new IllegalArgumentException("Acceleration value cannot lie outside [0,1] range");
        }
        if (acceleration > 1.0f - this.deceleration) {
            throw new IllegalArgumentException("Acceleration value cannot be greater than (1 - deceleration)");
        }
        this.acceleration = acceleration;
    }
    
    public void setDeceleration(final float deceleration) {
        this.throwExceptionIfRunning();
        if (deceleration < 0.0f || deceleration > 1.0f) {
            throw new IllegalArgumentException("Deceleration value cannot lie outside [0,1] range");
        }
        if (deceleration > 1.0f - this.acceleration) {
            throw new IllegalArgumentException("Deceleration value cannot be greater than (1 - acceleration)");
        }
        this.deceleration = deceleration;
    }
    
    public float getAcceleration() {
        return this.acceleration;
    }
    
    public float getDeceleration() {
        return this.deceleration;
    }
    
    public void addTarget(final TimingTarget target) {
        if (target != null) {
            synchronized (this.targets) {
                if (!this.targets.contains(target)) {
                    this.targets.add(target);
                }
            }
        }
    }
    
    public void removeTarget(final TimingTarget target) {
        synchronized (this.targets) {
            this.targets.remove(target);
        }
    }
    
    private void throwExceptionIfRunning() {
        if (this.isRunning()) {
            throw new IllegalStateException("Cannot perform this operation while Animator is running");
        }
    }
    
    public int getResolution() {
        return this.resolution;
    }
    
    public void setResolution(final int resolution) {
        if (resolution < 0) {
            throw new IllegalArgumentException("resolution must be >= 0");
        }
        this.throwExceptionIfRunning();
        this.resolution = resolution;
        this.timer.setResolution(resolution);
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public void setDuration(final int duration) {
        this.throwExceptionIfRunning();
        this.duration = duration;
    }
    
    public double getRepeatCount() {
        return this.repeatCount;
    }
    
    public void setRepeatCount(final double repeatCount) {
        this.validateRepeatCount(repeatCount);
        this.throwExceptionIfRunning();
        this.repeatCount = repeatCount;
    }
    
    public int getStartDelay() {
        return this.startDelay;
    }
    
    public void setStartDelay(final int startDelay) {
        if (startDelay < 0) {
            throw new IllegalArgumentException("startDelay (" + startDelay + ") cannot be < 0");
        }
        this.throwExceptionIfRunning();
        this.startDelay = startDelay;
        this.timer.setStartDelay(startDelay);
    }
    
    public RepeatBehavior getRepeatBehavior() {
        return this.repeatBehavior;
    }
    
    public void setRepeatBehavior(final RepeatBehavior repeatBehavior) {
        this.throwExceptionIfRunning();
        this.repeatBehavior = ((repeatBehavior != null) ? repeatBehavior : RepeatBehavior.REVERSE);
    }
    
    public EndBehavior getEndBehavior() {
        return this.endBehavior;
    }
    
    public void setEndBehavior(final EndBehavior endBehavior) {
        this.throwExceptionIfRunning();
        this.endBehavior = endBehavior;
    }
    
    public float getStartFraction() {
        return this.startFraction;
    }
    
    public void setStartFraction(final float startFraction) {
        if (startFraction < 0.0f || startFraction > 1.0f) {
            throw new IllegalArgumentException("initialFraction must be between 0 and 1");
        }
        this.throwExceptionIfRunning();
        this.startFraction = startFraction;
    }
    
    public void start() {
        this.throwExceptionIfRunning();
        this.hasBegun = false;
        this.running = true;
        this.startTime = System.nanoTime() / 1000000L + this.getStartDelay();
        if (this.duration != -1 && ((this.direction == Direction.FORWARD && this.startFraction > 0.0f) || (this.direction == Direction.BACKWARD && this.startFraction < 1.0f))) {
            final float offsetFraction = (this.direction == Direction.FORWARD) ? this.startFraction : (1.0f - this.startFraction);
            final long startDelta = (long)(this.duration * offsetFraction);
            this.startTime -= startDelta;
        }
        this.currentStartTime = this.startTime;
        this.timer.start();
    }
    
    public boolean isRunning() {
        return this.running;
    }
    
    public void stop() {
        this.timer.stop();
        this.end();
        this.timeToStop = false;
        this.running = false;
        this.pauseBeginTime = 0L;
    }
    
    public void cancel() {
        this.timer.stop();
        this.timeToStop = false;
        this.running = false;
        this.pauseBeginTime = 0L;
    }
    
    public void pause() {
        if (this.isRunning()) {
            this.pauseBeginTime = System.nanoTime();
            this.running = false;
            this.timer.stop();
        }
    }
    
    public void resume() {
        if (this.pauseBeginTime > 0L) {
            final long pauseDelta = (System.nanoTime() - this.pauseBeginTime) / 1000000L;
            this.startTime += pauseDelta;
            this.currentStartTime += pauseDelta;
            this.timer.start();
            this.pauseBeginTime = 0L;
            this.running = true;
        }
    }
    
    private void timingEvent(final float fraction) {
        synchronized (this.targets) {
            for (int i = 0; i < this.targets.size(); ++i) {
                final TimingTarget target = this.targets.get(i);
                target.timingEvent(fraction);
            }
        }
        if (this.timeToStop) {
            this.stop();
        }
    }
    
    private void begin() {
        synchronized (this.targets) {
            for (int i = 0; i < this.targets.size(); ++i) {
                final TimingTarget target = this.targets.get(i);
                target.begin();
            }
        }
    }
    
    private void end() {
        synchronized (this.targets) {
            for (int i = 0; i < this.targets.size(); ++i) {
                final TimingTarget target = this.targets.get(i);
                target.end();
            }
        }
    }
    
    private void repeat() {
        synchronized (this.targets) {
            for (int i = 0; i < this.targets.size(); ++i) {
                final TimingTarget target = this.targets.get(i);
                target.repeat();
            }
        }
    }
    
    private float timingEventPreprocessor(float fraction) {
        if (this.acceleration != 0.0f || this.deceleration != 0.0f) {
            final float oldFraction = fraction;
            final float runRate = 1.0f / (1.0f - this.acceleration / 2.0f - this.deceleration / 2.0f);
            if (fraction < this.acceleration) {
                final float averageRunRate = runRate * (fraction / this.acceleration) / 2.0f;
                fraction *= averageRunRate;
            }
            else if (fraction > 1.0f - this.deceleration) {
                final float tdec = fraction - (1.0f - this.deceleration);
                final float pdec = tdec / this.deceleration;
                fraction = runRate * (1.0f - this.acceleration / 2.0f - this.deceleration + tdec * (2.0f - pdec) / 2.0f);
            }
            else {
                fraction = runRate * (fraction - this.acceleration / 2.0f);
            }
            if (fraction < 0.0f) {
                fraction = 0.0f;
            }
            else if (fraction > 1.0f) {
                fraction = 1.0f;
            }
        }
        return this.interpolator.interpolate(fraction);
    }
    
    public long getTotalElapsedTime(final long currentTime) {
        return currentTime - this.startTime;
    }
    
    public long getTotalElapsedTime() {
        final long currentTime = System.nanoTime() / 1000000L;
        return this.getTotalElapsedTime(currentTime);
    }
    
    public long getCycleElapsedTime(final long currentTime) {
        return currentTime - this.currentStartTime;
    }
    
    public long getCycleElapsedTime() {
        final long currentTime = System.nanoTime() / 1000000L;
        return this.getCycleElapsedTime(currentTime);
    }
    
    public float getTimingFraction() {
        final long currentTime = System.nanoTime() / 1000000L;
        final long cycleElapsedTime = this.getCycleElapsedTime(currentTime);
        final long totalElapsedTime = this.getTotalElapsedTime(currentTime);
        final double currentCycle = totalElapsedTime / (double)this.duration;
        if (!this.hasBegun) {
            this.begin();
            this.hasBegun = true;
        }
        float fraction = 0.0f;
        if (this.duration != -1 && this.repeatCount != -1.0 && currentCycle >= this.repeatCount) {
            switch (this.endBehavior) {
                case HOLD: {
                    if (!this.intRepeatCount) {
                        fraction = Math.min(1.0f, cycleElapsedTime / (float)this.duration);
                        break;
                    }
                    if (this.direction == Direction.BACKWARD) {
                        fraction = 0.0f;
                        break;
                    }
                    fraction = 1.0f;
                    break;
                }
                case RESET: {
                    fraction = 0.0f;
                    break;
                }
                default: {
                    fraction = 0.0f;
                    break;
                }
            }
            this.timeToStop = true;
        }
        else if (this.duration != -1 && cycleElapsedTime > this.duration) {
            final long actualCycleTime = cycleElapsedTime % this.duration;
            fraction = actualCycleTime / (float)this.duration;
            this.currentStartTime = currentTime - actualCycleTime;
            if (this.repeatBehavior == RepeatBehavior.REVERSE) {
                final boolean oddCycles = (int)(cycleElapsedTime / this.duration) % 2 > 0;
                if (oddCycles) {
                    this.direction = ((this.direction == Direction.FORWARD) ? Direction.BACKWARD : Direction.FORWARD);
                }
                if (this.direction == Direction.BACKWARD) {
                    fraction = 1.0f - fraction;
                }
            }
            this.repeat();
        }
        else {
            fraction = 0.0f;
            if (this.duration != -1) {
                fraction = cycleElapsedTime / (float)this.duration;
                if (this.direction == Direction.BACKWARD) {
                    fraction = 1.0f - fraction;
                }
                fraction = Math.min(fraction, 1.0f);
                fraction = Math.max(fraction, 0.0f);
            }
        }
        return this.timingEventPreprocessor(fraction);
    }
    
    public synchronized void setTimer(final TimingSource timer) {
        this.throwExceptionIfRunning();
        if (this.timer != this.swingTimer) {
            this.timer.removeEventListener(this.timingSourceTarget);
        }
        if (timer == null) {
            this.timer = this.swingTimer;
        }
        else {
            this.timer = timer;
            if (this.timingSourceTarget == null) {
                this.timingSourceTarget = new TimingSourceTarget();
            }
            timer.addEventListener(this.timingSourceTarget);
        }
        this.timer.setResolution(this.resolution);
        this.timer.setStartDelay(this.startDelay);
    }
    
    public enum EndBehavior
    {
        HOLD, 
        RESET;
    }
    
    public enum Direction
    {
        FORWARD, 
        BACKWARD;
    }
    
    public enum RepeatBehavior
    {
        LOOP, 
        REVERSE;
    }
    
    class TimingSourceTarget implements TimingEventListener
    {
        public void timingSourceEvent(final TimingSource timingSource) {
            if (Animator.this.timer == timingSource && Animator.this.running) {
                Animator.this.timingEvent(Animator.this.getTimingFraction());
            }
        }
    }
    
    private class SwingTimingSource extends TimingSource
    {
        Timer timer;
        
        public SwingTimingSource() {
            this.timer = new Timer(Animator.this.resolution, new TimerTarget());
        }
        
        @Override
        public void start() {
            this.timer.start();
        }
        
        @Override
        public void stop() {
            this.timer.stop();
        }
        
        @Override
        public void setResolution(final int resolution) {
            this.timer.setDelay(resolution);
        }
        
        @Override
        public void setStartDelay(final int delay) {
            this.timer.setInitialDelay(delay);
        }
    }
    
    private class TimerTarget implements ActionListener
    {
        public void actionPerformed(final ActionEvent e) {
            Animator.this.timingEvent(Animator.this.getTimingFraction());
        }
    }
}
