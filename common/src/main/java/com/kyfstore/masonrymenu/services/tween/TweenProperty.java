package com.kyfstore.masonrymenu.services.tween;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class TweenProperty {

    private final Supplier<Float> getter;
    private final Consumer<Float> setter;

    public TweenProperty(Supplier<Float> getter, Consumer<Float> setter) {
        this.getter = getter;
        this.setter = setter;
    }

    public float get() {
        return getter.get();
    }

    public void set(float value) {
        setter.accept(value);
    }
}