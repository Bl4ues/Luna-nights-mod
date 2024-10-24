
package net.mcreator.lunanights.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.lunanights.entity.KnifeFreezeEntity;
import net.mcreator.lunanights.client.model.Modelknife_entity;

public class KnifeFreezeRenderer extends MobRenderer<KnifeFreezeEntity, Modelknife_entity<KnifeFreezeEntity>> {
	public KnifeFreezeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelknife_entity(context.bakeLayer(Modelknife_entity.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(KnifeFreezeEntity entity) {
		return new ResourceLocation("luna_nights:textures/entities/knifes_entity.png");
	}
}
