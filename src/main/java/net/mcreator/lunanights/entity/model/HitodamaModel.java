package net.mcreator.lunanights.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.lunanights.entity.HitodamaEntity;

public class HitodamaModel extends GeoModel<HitodamaEntity> {
	@Override
	public ResourceLocation getAnimationResource(HitodamaEntity entity) {
		return new ResourceLocation("luna_nights", "animations/hitodama.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HitodamaEntity entity) {
		return new ResourceLocation("luna_nights", "geo/hitodama.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HitodamaEntity entity) {
		return new ResourceLocation("luna_nights", "textures/entities/" + entity.getTexture() + ".png");
	}

}
