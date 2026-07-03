package com.kyfstore.masonrymenu.services.tween;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TweenService {

    public static final TweenService INSTANCE = new TweenService();

    private final List<Tween> tweens = new ArrayList<>();

    private TweenService() {}

    public Tween create(TweenProperty property) {
        return new Tween(property);
    }

    void add(Tween tween) {
        tweens.add(tween);
    }

    public void update(float delta) {
        Iterator<Tween> it = tweens.iterator();

        while (it.hasNext()) {
            Tween t = it.next();

            if (t.update(delta)) {
                it.remove();
            }
        }
    }

    public void cancelAll() {
        tweens.clear();
    }
}