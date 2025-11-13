package com.bizcub.hideItemFrame.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? >=1.21.11 {
import net.minecraft.client.renderer.entity.ItemFrameRenderer;

@Mixin(ItemFrameRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "submit*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameRenderState itemFrameRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState, CallbackInfo ci) {
        if (!itemFrameRenderState.isInvisible) {
            itemFrameRenderState.isInvisible = !itemFrameRenderState.item.isEmpty();
        }
    }
}

//?} >=1.21.2 {
/*import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
//? >=1.21.9 {
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;//?}
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    /^? >=1.21.9^/ public void hideItemFrame(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState, CallbackInfo ci) {
    /^? <=1.21.8^/ /^public void hideItemFrame(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {^/
        if (!itemFrameEntityRenderState.invisible) {
            /^? >=1.21.4^/ itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.itemRenderState.isEmpty();
            /^? <=1.21.3^/ /^itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.contents.isEmpty();^/
        }
    }
}

*///?} else {
/*import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ItemFrameEntity;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin<T extends ItemFrameEntity> {

    @Inject(method = "render*",  at = @At(value = "HEAD"))
    private void hideItemFrame(T itemFrameEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo callbackInfo) {
        itemFrameEntity.setInvisible(!itemFrameEntity.getHeldItemStack().isEmpty());
    }
}*///?}
