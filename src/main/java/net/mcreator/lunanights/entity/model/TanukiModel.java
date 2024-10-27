package net.mcreator.lunanights.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.lunanights.entity.TanukiEntity;

public class TanukiModel extends GeoModel<TanukiEntity> {
	@Override
	public ResourceLocation getAnimationResource(TanukiEntity entity) {
		return new ResourceLocation("luna_nights", "animations/tanuki.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TanukiEntity entity) {
		return new ResourceLocation("luna_nights", "geo/tanuki.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TanukiEntity entity) {
		return new ResourceLocation("luna_nights", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(TanukiEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}