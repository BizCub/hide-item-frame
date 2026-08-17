package io.github.bizcub.hideItemFrame.config;

public interface Config {
    static Config get() {
        return Holder.INSTANCE;
    }

    static void set(final Config config) {
        if (config != null) {
            Holder.INSTANCE = config;
        }
    }

    class Holder {
        private static Config INSTANCE = new Config() { };
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
