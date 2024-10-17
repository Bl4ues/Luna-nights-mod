
package net.mcreator.lunanights.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.lunanights.procedures.TimeDisplayProcedure;
import net.mcreator.lunanights.procedures.ShowTimeProcedure;
import net.mcreator.lunanights.procedures.ShowManaProcedure;
import net.mcreator.lunanights.procedures.ManaDisplayProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (ShowTimeProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.luna_nights.mana_overlay.label_time"), w / 2 + -207, h / 2 + 86, -6750055, false);
			if (ShowManaProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.luna_nights.mana_overlay.label_mp"), w / 2 + -207, h / 2 + 104, -16750900, false);
			if (ShowTimeProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						TimeDisplayProcedure.execute(entity), w / 2 + -189, h / 2 + 86, -65281, false);
			if (ShowManaProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ManaDisplayProcedure.execute(entity), w / 2 + -189, h / 2 + 104, -13382401, false);
		}
	}
}
