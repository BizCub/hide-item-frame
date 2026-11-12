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

    static boolean isLoaded() {
        return Holder.INSTANCE != Holder.DEFAULT;
    }

    class Holder {
        private static final Config DEFAULT = new Config() { };
        private static Config INSTANCE = DEFAULT;
        private static boolean invisible = true;
    }

    default boolean isInvisible() {
        return Holder.invisible;
    }

    default boolean isItemOffset() {
        return true;
    }

    default void setIsInvisible(boolean value) {
        Holder.invisible = value;
    }

    default void save() { }
}
