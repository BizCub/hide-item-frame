package com.bizcub.hideItemFrame.mixin;

import com.bizcub.hideItemFrame.Main;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
/*? >=1.21.2*/ import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
/*? <=1.21.1*/ //import net.minecraft.world.entity.decoration.ItemFrame;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFrameRenderer.class)
public class HideItemFrameMixin {

    //~ if >=1.21.9 'render*' -> 'submit*'
    @ModifyVariable(method = "submit*", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    //~ if >=1.21.2 'ItemFrame' -> 'ItemFrameRenderState'
    private ItemFrameRenderState hideItemFrameRenderState(ItemFrameRenderState state) {
        if (Main.visibility) {
            //? >=26.1 {
            if (!state.item.isEmpty())
                state.frameModel.clear();

            //?} >=1.21.2 {
            /*if (!state.isInvisible)
                //~ if >=1.21.4 'itemStack' -> 'item'
                state.isInvisible = !state.item.isEmpty();

            *///?} else {
            /*state.setInvisible(!state.getItem().isEmpty());*///?}
        } //? <=1.21.1 {
        /*else state.setInvisible(false);*///?}
        return state;
    }

    //? >=26.1 {
    @Redirect(method = "submit*", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/state/ItemFrameRenderState;isInvisible:Z", opcode = Opcodes.GETFIELD))
    private boolean isInvisible(ItemFrameRenderState state) {
        return Main.visibility
                ? !state.item.isEmpty()
                : state.isInvisible;
    }//?}
}
