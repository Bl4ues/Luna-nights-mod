
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.lunanights.client.renderer.TanukiRenderer;
import net.mcreator.lunanights.client.renderer.KnifeFreezeRenderer;
import net.mcreator.lunanights.client.renderer.HitodamaRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LunaNightsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(LunaNightsModEntities.KNIFE_FREEZE.get(), KnifeFreezeRenderer::new);
		event.registerEntityRenderer(LunaNightsModEntities.KNIFES_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(LunaNightsModEntities.HITODAMA.get(), HitodamaRenderer::new);
		event.registerEntityRenderer(LunaNightsModEntities.TANUKI.get(), TanukiRenderer::new);
	}
}
