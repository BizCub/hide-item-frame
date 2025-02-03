package com.bizcub.hide_item_frame.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.render.entity.state.ItemFrameEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin<T extends ItemFrameEntity> extends EntityRenderer<T, ItemFrameEntityRenderState> {

    protected HideItemFrameMixin(EntityRendererFactory.Context context) {
        super(context);
    }

    @Inject(method = "render*", at = @At(value = "HEAD"))
    public void method1(ItemFrameEntityRenderState itemFrameEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        ItemStack itemStack = itemFrameEntityRenderState.contents;
        itemFrameEntityRenderState.invisible = !itemStack.isEmpty();
    }
}
