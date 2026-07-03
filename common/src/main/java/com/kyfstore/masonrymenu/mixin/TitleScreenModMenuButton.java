package com.kyfstore.masonrymenu.mixin;

import com.kyfstore.masonrymenu.Constants;
import com.kyfstore.masonrymenu.gui.screens.ModMenuScreen;
import dev.architectury.platform.Platform;
import net.minecraft.client.gui.components.FriendsButton;
import net.minecraft.client.gui.components.SpriteIconButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenModMenuButton extends Screen {

    protected TitleScreenModMenuButton(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void addModMenuButton(CallbackInfo ci) {
        SpriteIconButton button = SpriteIconButton.builder(
                Component.literal(""),
                _ -> minecraft.setScreenAndShow(new ModMenuScreen(Component.literal("Masonry Menu"))),
                true
        )
        .sprite(Constants.MODMENU_ICON, 18, 18)
        .size(20, 20)
        .tooltip(Component.literal("Masonry Menu"))
        .build();

        FriendsButton friends = this.children().stream()
                .filter(FriendsButton.class::isInstance)
                .map(FriendsButton.class::cast)
                .findFirst()
                .orElse(null);

        if (friends != null) {
            int offset = Platform.isNeoForge()
                    ? button.getWidth() * 2 + 8
                    : button.getWidth() + 4;

            button.setPosition(
                    friends.getX() - offset,
                    friends.getY()
            );
        }

        this.addRenderableWidget(button);
    }
}