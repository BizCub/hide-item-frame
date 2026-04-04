//? neoforge {
/*package com.bizcub.hideItemFrame.platform;

import com.bizcub.hideItemFrame.Main;
import com.mojang.blaze3d.platform.InputConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class NeoForge {

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(Main.TOGGLE_VISIBILITY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getAction() == InputConstants.PRESS) {
            var inputConstants = InputConstants.getKey(
                    /^? >=1.21.9^/ event.getKeyEvent()
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
