
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.lunanights.client.model.Modelknife_entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LunaNightsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelknife_entity.LAYER_LOCATION, Modelknife_entity::createBodyLayer);
	}
}
