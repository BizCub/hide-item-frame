package io.github.bizcub.hideItemFrame.config;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.simpleConfigLib.autoconfig.gui.ConfigScreens;
import net.minecraft.client.gui.screens.Screen;

public class ConfigHelper {
    public static final String SIMPLE_CONFIG_MOD_ID = "simple_config_lib";

    public static Screen getScreen(Screen parent) {
        return Config.isLoaded() ? ConfigScreens.open(Main.MOD_ID, parent) : parent;
    }
}
