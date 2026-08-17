package io.github.bizcub.hideItemFrame.config;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;

@AutoConfig(name = Main.MOD_ID, translate = true)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    public boolean isInvisible = Config.super.isInvisible();

    public boolean isItemOffset = Config.super.isItemOffset();

    @Override
    public boolean isInvisible() {
        return this.isInvisible;
    }

    @Override
    public void setIsInvisible(boolean value) {
        this.isInvisible = value;
    }

    @Override
    public boolean isItemOffset() {
        return this.isItemOffset;
    }

    @Override
    public void save() {
        SimpleConfig.getInstance().save();
    }
}
