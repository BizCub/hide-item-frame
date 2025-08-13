package com.bizcub.hideItemFrame.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? if >=1.21.2 {
/*import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (!itemFrameEntityRenderState.invisible) {
            //? if >=1.21.4 {
            /^itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.itemRenderState.isEmpty();
            ^///?} else {
            itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.contents.isEmpty();//?}
        }
    }
}

*///?} elif <=1.21.1 {
import net.minecraft.entity.decoration.ItemFrameEntity;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin<T extends ItemFrameEntity> {

    @Inject(method = "render*",  at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/decoration/ItemFrameEntity;isInvisible()Z", shift = At.Shift.AFTER))
    private boolean hideItemFrame(T itemFrameEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo callbackInfo) {
        boolean invisible = itemFrameEntity.isInvisible();
        if (!invisible) {
            return !itemFrameEntity.getHeldItemStack().isEmpty();
        }
        return invisible;
    }
}//?}
