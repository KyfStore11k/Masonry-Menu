package com.kyfstore.masonrymenu.fabric;

import com.kyfstore.masonrymenu.MasonryMenu;
import net.fabricmc.api.ModInitializer;

public final class MasonryMenuFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MasonryMenu.init();
    }
}
