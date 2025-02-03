package com.bizcub.hide_item_frame.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameEntityRenderer.class)
public abstract class HideItemFrameMixin<T extends ItemFrameEntity> extends EntityRenderer<T> {

    protected HideItemFrameMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Inject(
            method = "render*",
            at = @At(
                    value = "INVOKE", target = "Lnet/minecraft/entity/decoration/ItemFrameEntity;isInvisible()Z",
                    shift = At.Shift.AFTER),
            slice = @Slice(
                    from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/decoration/ItemFrameEntity;getYaw()F"),
                    to = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/block/BlockRenderManager;getModels()Lnet/minecraft/client/render/block/BlockModels;")
            ))
    public boolean method3(T itemFrameEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        ItemStack itemStack = itemFrameEntity.getHeldItemStack();
        return !itemStack.isEmpty();
    }
}
//test