package com.kyfstore.masonrymenu.mixin;

import com.kyfstore.masonrymenu.services.tween.TweenService;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererClientEvent {
    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V",
                    shift = At.Shift.BEFORE
            )
    )
    private void onRenderPost(DeltaTracker deltaTracker, boolean advanceGameTime, CallbackInfo ci) {
        TweenService.INSTANCE.update(deltaTracker.getRealtimeDeltaTicks());
    }
}