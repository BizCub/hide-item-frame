package com.bizcub.hideItemFrame.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? >=1.21.9 {
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;

@Mixin(ItemFrameRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "submit*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameRenderState itemFrameRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState, CallbackInfo ci) {
        if (!itemFrameRenderState.isInvisible)
            itemFrameRenderState.isInvisible = !itemFrameRenderState.item.isEmpty();
    }
}

//?} >=1.21.2 {
/*import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;

@Mixin(ItemFrameRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameRenderState itemFrameRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci){
        if (!itemFrameRenderState.isInvisible) {
            /^? >=1.21.4^/ itemFrameRenderState.isInvisible = !itemFrameRenderState.item.isEmpty();
            /^? <=1.21.3^/ /^itemFrameRenderState.isInvisible = !itemFrameRenderState.itemStack.isEmpty();^/
        }
    }
}

*///?} else {
/*import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.decoration.ItemFrame;

@Mixin(ItemFrameRenderer.class)
public class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrame itemFrame, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci){
        itemFrame.setInvisible(!itemFrame.getItem().isEmpty());
    }
}*///?}
