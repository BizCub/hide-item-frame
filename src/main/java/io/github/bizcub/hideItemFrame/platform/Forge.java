//? forge {
/*package io.github.bizcub.hideItemFrame.platform;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.hideItemFrame.config.ConfigHelper;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod(Main.MOD_ID)
@EventBusSubscriber(modid = Main.MOD_ID)
public class Forge {

    public Forge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) -> ConfigHelper.getScreen(screen)));
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(Main.TOGGLE_VISIBILITY);
    }

    @SubscribeEvent //~ if <=1.20.2 'ClientTickEvent.Post' -> 'ClientTickEvent'
    public static void onClientTick(TickEvent.ClientTickEvent.Post event) {
        Main.onClientTick();
    }
}*///?}
