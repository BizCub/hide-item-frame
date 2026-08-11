//? forge {
/*package io.github.bizcub.hideItemFrame.platform;

import io.github.bizcub.hideItemFrame.Main;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class Forge {

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(Main.TOGGLE_VISIBILITY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (Main.TOGGLE_VISIBILITY.isDown()) {
            InputConstants.Key inputConstants = InputConstants.getKey(
                    /^? >=1.21.9^/ event.getInfo()
                    /^? <=1.21.8^/ //event.getKey(), event.getScanCode()
            );
            if (Main.TOGGLE_VISIBILITY.isActiveAndMatches(inputConstants)) {
                Main.toggleVisibility();
            }
        }
    }

    @Mod(Main.MOD_ID)
    public static class Init {

        public Init() {
            Main.init();
        }
    }
}*///?}
