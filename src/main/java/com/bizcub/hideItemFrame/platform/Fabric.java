//? fabric {
package com.bizcub.hideItemFrame.platform;

import com.bizcub.hideItemFrame.Main;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//~ if >=26.1 'keybinding' -> 'keymapping'
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

public class Fabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Main.init();

        KeyMappingHelper.registerKeyMapping(Main.TOGGLE_VISIBILITY);

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> {
            while (Main.TOGGLE_VISIBILITY.consumeClick()) {
                Main.toggleVisibility();
            }
        });
    }
}//?}
