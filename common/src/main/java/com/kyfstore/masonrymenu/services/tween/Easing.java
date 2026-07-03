package com.kyfstore.masonrymenu.services.tween;

@FunctionalInterface
public interface Easing {

    float apply(float t);

    Easing LINEAR = t -> t;

    Easing IN_SINE = t ->
            1.0f - (float) Math.cos((t * Math.PI) / 2.0);

    Easing OUT_SINE = t ->
            (float) Math.sin((t * Math.PI) / 2.0);

    Easing IN_OUT_SINE = t ->
            -(float) Math.cos(Math.PI * t) / 2.0f + 0.5f;

    Easing IN_QUAD = t -> t * t;

    Easing OUT_QUAD = t -> 1.0f - (1.0f - t) * (1.0f - t);

    Easing IN_OUT_QUAD = t ->
            t < 0.5f
                    ? 2.0f * t * t
                    : 1.0f - (float) Math.pow(-2.0f * t + 2.0f, 2.0) / 2.0f;

    Easing IN_CUBIC = t -> t * t * t;

    Easing OUT_CUBIC = t ->
            1.0f - (float) Math.pow(1.0f - t, 3.0);

    Easing IN_OUT_CUBIC = t ->
            t < 0.5f
                    ? 4.0f * t * t * t
                    : 1.0f - (float) Math.pow(-2.0f * t + 2.0f, 3.0) / 2.0f;

    Easing IN_QUART = t -> t * t * t * t;

    Easing OUT_QUART = t ->
            1.0f - (float) Math.pow(1.0f - t, 4.0);

    Easing IN_OUT_QUART = t ->
            t < 0.5f
                    ? 8.0f * t * t * t * t
                    : 1.0f - (float) Math.pow(-2.0f * t + 2.0f, 4.0) / 2.0f;

    Easing IN_QUINT = t -> t * t * t * t * t;

    Easing OUT_QUINT = t ->
            1.0f - (float) Math.pow(1.0f - t, 5.0);

    Easing IN_OUT_QUINT = t ->
            t < 0.5f
                    ? 16.0f * t * t * t * t * t
                    : 1.0f - (float) Math.pow(-2.0f * t + 2.0f, 5.0) / 2.0f;

    Easing IN_EXPO = t ->
            t == 0.0f ? 0.0f : (float) Math.pow(2.0, 10.0 * t - 10.0);

    Easing OUT_EXPO = t ->
            t == 1.0f ? 1.0f : 1.0f - (float) Math.pow(2.0, -10.0 * t);

    Easing IN_OUT_EXPO = t -> {
        if (t == 0.0f) return 0.0f;
        if (t == 1.0f) return 1.0f;

        return t < 0.5f
                ? (float) Math.pow(2.0, 20.0 * t - 10.0) / 2.0f
                : (2.0f - (float) Math.pow(2.0, -20.0 * t + 10.0)) / 2.0f;
    };

    Easing IN_BACK = t -> {
        final float c1 = 1.70158f;
        final float c3 = c1 + 1.0f;

        return c3 * t * t * t - c1 * t * t;
    };

    Easing OUT_BACK = t -> {
        final float c1 = 1.70158f;
        final float c3 = c1 + 1.0f;

        float x = t - 1.0f;

        return 1.0f + c3 * x * x * x + c1 * x * x;
    };

    Easing IN_OUT_BACK = t -> {
        final float c1 = 1.70158f;
        final float c2 = c1 * 1.525f;

        return t < 0.5f
                ? ((float) Math.pow(2.0 * t, 2.0) * ((c2 + 1.0f) * 2.0f * t - c2)) / 2.0f
                : ((float) Math.pow(2.0 * t - 2.0, 2.0)
                   * ((c2 + 1.0f) * (t * 2.0f - 2.0f) + c2) + 2.0f) / 2.0f;
    };

    Easing OUT_BOUNCE = t -> {
        final float n1 = 7.5625f;
        final float d1 = 2.75f;

        if (t < 1.0f / d1) {
            return n1 * t * t;
        } else if (t < 2.0f / d1) {
            t -= 1.5f / d1;
            return n1 * t * t + 0.75f;
        } else if (t < 2.5f / d1) {
            t -= 2.25f / d1;
            return n1 * t * t + 0.9375f;
        } else {
            t -= 2.625f / d1;
            return n1 * t * t + 0.984375f;
        }
    };
}