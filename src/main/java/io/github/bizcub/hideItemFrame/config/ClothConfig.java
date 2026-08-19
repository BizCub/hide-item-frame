package io.github.bizcub.hideItemFrame.config;

import io.github.bizcub.hideItemFrame.Main;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@me.shedaniel.autoconfig.annotation.Config(name = Main.MOD_ID)
public class ClothConfig implements Config, ConfigData {

    public static ClothConfig getInstance() {
        return AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
    }

    public static void init() {
        AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new);
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
        AutoConfig.getConfigHolder(ClothConfig.class).save();
    }
}
