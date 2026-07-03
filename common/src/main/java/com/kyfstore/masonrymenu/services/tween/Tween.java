package com.kyfstore.masonrymenu.services.tween;

public final class Tween {

    private final TweenProperty property;

    private float from;
    private float to;
    private float duration;
    private float elapsed;

    private Easing easing = Easing.LINEAR;

    private Runnable onComplete;

    private boolean started;

    Tween(TweenProperty property) {
        this.property = property;
    }

    public Tween from(float value) {
        this.from = value;
        return this;
    }

    public Tween to(float value) {
        this.to = value;
        return this;
    }

    public Tween duration(float seconds) {
        this.duration = seconds;
        return this;
    }

    public Tween ease(Easing easing) {
        this.easing = easing;
        return this;
    }

    public Tween onComplete(Runnable r) {
        this.onComplete = r;
        return this;
    }

    public TweenHandle play() {
        TweenService.INSTANCE.add(this);
        return new TweenHandle(this);
    }

    boolean update(float delta) {
        if (!started) {
            started = true;
            property.set(from);
        }

        elapsed += delta;

        float t = Math.min(elapsed / duration, 1f);
        float eased = easing.apply(t);

        float value = from + (to - from) * eased;
        property.set(value);

        if (t >= 1f) {
            property.set(to);

            if (onComplete != null) {
                onComplete.run();
            }

            return true;
        }

        return false;
    }

    void cancel() {
        elapsed = duration;
    }
}