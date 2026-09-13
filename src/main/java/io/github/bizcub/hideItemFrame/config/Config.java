package io.github.bizcub.hideItemFrame.config;

import io.github.bizcub.simpleConfigLib.autoconfig.ConfigProvider;

public interface Config {
    static Config get() {
        return ConfigProvider.get(Config.class);
    }
    static void set(Config instance) {
        ConfigProvider.set(Config.class, instance);
    }

    default boolean isInvisible() {
        return false;
    }

    default boolean isItemOffset() {
        return true;
    }

    default void setIsInvisible(boolean value) { }

    default void save() { }
}
