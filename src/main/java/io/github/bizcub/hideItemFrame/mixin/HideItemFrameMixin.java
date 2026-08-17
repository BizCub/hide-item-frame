package io.github.bizcub.hideItemFrame.mixin;

import io.github.bizcub.hideItemFrame.config.Config;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
/*? >=1.21.2 {*/ import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
/*?} else*/ //import net.minecraft.world.entity.decoration.ItemFrame;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ItemFrameRenderer.class)
public class HideItemFrameMixin {

    //? >=26.1 {
    //~ if >=1.21.9 'render*' -> 'submit*'
    @ModifyVariable(method = "submit*", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private ItemFrameRenderState hideItemFrame(ItemFrameRenderState state) {
        if (Config.get().isInvisible() && !state.item.isEmpty()) {
            state.frameModel.clear();
        }
        return state;
    }//?}

    //? >=1.21.2 {
    //~ if >=1.21.9 'render*' -> 'submit*'
    @Redirect(method = "submit*", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/entity/state/ItemFrameRenderState;isInvisible:Z", opcode = Opcodes.GETFIELD))
    private boolean isInvisible(ItemFrameRenderState state) {
        return Config.get().isInvisible() /*? >=26.1*/ && Config.get().isItemOffset()
                //~ if >=1.21.4 'itemStack' -> 'item'
                ? !state.item.isEmpty()
                : state.isInvisible;
    }

    //?} else {
    /*@Redirect(method = "render*", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/ItemFrame;isInvisible()Z"))
    private boolean isInvisible(ItemFrame itemFrame) {
        return Config.get().isInvisible()
                ? itemFrame.isInvisible()
                : itemFrame.isInvisible() || !itemFrame.getItem().isEmpty();
    }*///?}

    //? <26.1 {
    /*//~ if >=1.21.9 'render*' -> 'submit*'
    @ModifyArg(method = "submit*", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", ordinal = 1), index = 2)
    private float raiseItemDepth(float z) {
        return !Config.get().isItemOffset() ? 0.4375F : z;
    }*///?}
}
