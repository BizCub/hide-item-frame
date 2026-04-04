package com.bizcub.hideItemFrame;

import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
/*? <=1.18.2*/ //import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
/*? !(>=1.18 && <=1.18.2 && forge)*/ import org.lwjgl.glfw.GLFW;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "hide_item_frame";

    public static final KeyMapping TOGGLE_VISIBILITY = new KeyMapping(
            "key." + MOD_ID + ".toggle_frames_visibility",
            //~ if >=1.18 && <=1.18.2 && forge 'GLFW.GLFW_KEY_H' -> '72'
            GLFW.GLFW_KEY_H,
            //~ if >=1.21.9 '"key.categories.misc"' -> 'KeyMapping.Category.MISC'
            KeyMapping.Category.MISC
    );

    public static boolean visibility = true;

    public static void toggleVisibility() {
        Main.visibility = !Main.visibility;
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            String translate = "text.hide_item_frame.visibility_is_" + ((Main.visibility) ? "on" : "off");
            ChatFormatting style = (Main.visibility) ? ChatFormatting.GREEN : ChatFormatting.RED;

            /*? >=1.19*/ Component component = Component.translatable(translate).withStyle(style);
            /*? <=1.18.2 {*/ /*TranslatableComponent component = new TranslatableComponent(translate);
            component.withStyle(style);*///?}

            //~ if >=26.1 'displayClientMessage' -> 'sendOverlayMessage'
            minecraft.player.sendOverlayMessage(component /*? <=1.21.11 {*//*, true *//*?}*/);
        }
    }
}
