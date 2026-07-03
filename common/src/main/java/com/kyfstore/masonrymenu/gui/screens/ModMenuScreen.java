package com.kyfstore.masonrymenu.gui.screens;

import com.kyfstore.masonrymenu.services.tween.Easing;
import com.kyfstore.masonrymenu.services.tween.TweenProperty;
import com.kyfstore.masonrymenu.services.tween.TweenService;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.network.chat.Component;

public class ModMenuScreen extends Screen {

    private Button button;
    private boolean closing;

    public ModMenuScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
        initWidgets();
    }

    private void initWidgets() {
        button = Button.builder(
                Component.literal("Example Button"),
                b -> {
                    System.out.println("Example button pressed!");
                }
        ).bounds(
                0,
                200,
                100,
                20
        ).build();

        addRenderableWidget(button);

        TweenService.INSTANCE
                .create(new TweenProperty(
                        () -> (float) button.getY(),
                        v -> {
                            float f = v;
                            button.setY((int) f);
                        }
                ))
                .from(button.getY())
                .to(0)
                .duration(15f)
                .ease(Easing.OUT_BACK)
                .play();
    }

    private void closeAnimated() {
        if (closing) return;
        closing = true;

        TweenService.INSTANCE
                .create(new TweenProperty(
                        () -> (float) button.getY(),
                        v -> {
                            float f = v;
                            button.setY((int) f);
                        }
                ))
                .from(button.getY())
                .to(-100)
                .duration(15f)
                .ease(Easing.IN_BACK)
                .onComplete(() -> Minecraft.getInstance().setScreenAndShow(new TitleScreen()))
                .play();
    }

    @Override
    public void onClose() {
        closeAnimated();
    }

    @Override
    public boolean keyReleased(KeyEvent event) {
        if (event.key() == 256 && !closing) {
            closeAnimated();
            return true;
        }

        return super.keyReleased(event);
    }
}