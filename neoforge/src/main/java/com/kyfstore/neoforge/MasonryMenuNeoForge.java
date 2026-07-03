package com.kyfstore.neoforge;

import com.kyfstore.masonrymenu.Constants;
import com.kyfstore.masonrymenu.MasonryMenu;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public final class MasonryMenuNeoForge {
    public MasonryMenuNeoForge() {
        MasonryMenu.init();
    }
}