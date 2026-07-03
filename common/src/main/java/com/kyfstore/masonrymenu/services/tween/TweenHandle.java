package com.kyfstore.masonrymenu.services.tween;

public final class TweenHandle {

    private final Tween tween;

    TweenHandle(Tween tween) {
        this.tween = tween;
    }

    public void cancel() {
        tween.cancel();
    }
}