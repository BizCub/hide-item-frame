package io.github.bizcub.hideItemFrame;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.bizcub.hideItemFrame.config.*;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "hide_item_frame";

    public static final KeyMapping TOGGLE_VISIBILITY = new KeyMapping(
            "key." + MOD_ID + ".toggle_frames_visibility",
            InputConstants.KEY_H,
            //~ if >=1.21.9 '"key.categories.misc"' -> 'KeyMapping.Category.MISC'
            KeyMapping.Category.MISC
    );

    public static void init() {
        if (ConfigHelper.isSimpleConfigLoaded()) {
            Config.set(SimpleConfig.getInstance().get());
        } else if (ConfigHelper.isClothConfigLoaded()) {
            ClothConfig.init();
            Config.set(ClothConfig.getInstance());
        }
    }

    public static void onClientTick() {
        while (TOGGLE_VISIBILITY.consumeClick()) {
            Config cfg = Config.get();
            cfg.setIsInvisible(!cfg.isInvisible());
            cfg.save();

            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player != null) {
                String translate = "text.hide_item_frame.visibility_is_" + ((Config.get().isInvisible()) ? "on" : "off");
                ChatFormatting style = Config.get().isInvisible() ? ChatFormatting.GREEN : ChatFormatting.RED;
                Component component = Component.translatable(translate).withStyle(style);

                //~ if >=26.1 'displayClientMessage' -> 'sendOverlayMessage'
                minecraft.player.sendOverlayMessage(component /*? <=1.21.11 >> ')'*//*, true*/);
            }
        }
    }
}
