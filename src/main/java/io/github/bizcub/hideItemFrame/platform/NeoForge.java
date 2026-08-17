//? neoforge {
/*package io.github.bizcub.hideItemFrame.platform;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.hideItemFrame.config.ConfigHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Main.MOD_ID)
@EventBusSubscriber(modid = Main.MOD_ID)
public class NeoForge {

    public NeoForge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (container, parent) -> ConfigHelper.getScreen(parent));
    }

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(Main.TOGGLE_VISIBILITY);
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Main.onClientTick();
    }
}*///?}
