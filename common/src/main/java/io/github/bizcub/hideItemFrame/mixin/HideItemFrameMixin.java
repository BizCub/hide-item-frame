package io.github.bizcub.hideItemFrame.mixin;

import io.github.bizcub.hideItemFrame.config.Config;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemFrameRenderer.class)
public class HideItemFrameMixin {

    @ModifyVariable(method = "submit*", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private ItemFrameRenderState hideItemFrame(ItemFrameRenderState state) {
        if (Config.get().isInvisible() && !state.item.isEmpty()) {
            state.frameModel.clear();
        }
        return state;
    }

    @Redirect(method = "submit*", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/state/ItemFrameRenderState;isInvisible:Z", opcode = Opcodes.GETFIELD))
    private boolean isInvisible(ItemFrameRenderState state) {
        return (state.isInvisible || Config.get().isInvisible() && !state.item.isEmpty()) && Config.get().isItemOffset();
    }
}
