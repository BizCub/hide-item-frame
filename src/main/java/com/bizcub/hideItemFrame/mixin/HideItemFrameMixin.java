package com.bizcub.hideItemFrame.mixin;

//? if >=1.21.4 {
/*import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (!itemFrameEntityRenderState.invisible) {
            itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.itemRenderState.isEmpty();
        }
    }
}

*///?} elif >=1.21.2 && <=1.21.3 {
/*import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin {

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void hideItemFrame(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (!itemFrameEntityRenderState.invisible) {
            itemFrameEntityRenderState.invisible = !itemFrameEntityRenderState.contents.isEmpty();
        }
    }
}

*///?} elif >=1.17 && <=1.21.1 {
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ItemFrameEntity;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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
}
//?}
