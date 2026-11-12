package io.github.bizcub.hideItemFrame.platform;

import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.hideItemFrame.config.ConfigHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Main.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class NeoForge {

    public NeoForge(ModContainer modContainer) {
        Main.init(ModList.get().isLoaded(ConfigHelper.SIMPLE_CONFIG_MOD_ID));

        modContainer.registerExtensionPoint(IConfigScreenFactory.class,
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
}
