//? forge {
/*package com.bizcub.hideItemFrame.platform;

import com.bizcub.hideItemFrame.Main;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
/^? >=1.19^/ import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//$ client_regestry
//ClientRegistry;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class Forge {

    //? >=1.19 {
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(Main.TOGGLE_VISIBILITY);
    }//?}

    @SubscribeEvent //~ if >=1.18 'registerInputEvents' -> 'onKeyInput'
    public static void onKeyInput(/^? >=1.19 {^/ InputEvent.Key /^?} else {^/ /^InputEvent.KeyInputEvent^//^?}^/ event) {
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
            /^? <=1.18.2^/ //ClientRegistry.registerKeyMapping(Main.TOGGLE_VISIBILITY);
        }
    }
}*///?}
