package io.github.bizcub.hideItemFrame.platform;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.hideItemFrame.config.ConfigHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Main.MOD_ID)
public class Forge {

    public Forge(FMLJavaModLoadingContext context) {
        if (FMLEnvironment.dist != Dist.CLIENT) return;

        Main.init(ModList.isLoaded(ConfigHelper.SIMPLE_CONFIG_MOD_ID));

        context.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) -> ConfigHelper.getScreen(screen)));

        RegisterKeyMappingsEvent.BUS.addListener(event -> event.register(Main.TOGGLE_VISIBILITY));
        TickEvent.ClientTickEvent.Post.BUS.addListener(event -> Main.onClientTick());
    }
}
