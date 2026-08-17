//? fabric {
package io.github.bizcub.hideItemFrame.platform;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.bizcub.hideItemFrame.Main;
import io.github.bizcub.hideItemFrame.config.ConfigHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
//~ if >=26.1 'keybinding' -> 'keymapping'
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

public class Fabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Main.init();

        KeyMappingHelper.registerKeyMapping(Main.TOGGLE_VISIBILITY);

        ClientTickEvents.END_CLIENT_TICK.register(minecraft -> Main.onClientTick());
    }

    public static class ModMenu implements ModMenuApi {

        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return ConfigHelper::getScreen;
        }
    }
}//?}
