
package net.mcreator.lunanights.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.lunanights.procedures.TimeStopOverlayProcedure;
import net.mcreator.lunanights.procedures.TimeStopOverlayFalseProcedure;
import net.mcreator.lunanights.procedures.TimeDisplayProcedure;
import net.mcreator.lunanights.procedures.TimeBar9Procedure;
import net.mcreator.lunanights.procedures.TimeBar8Procedure;
import net.mcreator.lunanights.procedures.TimeBar7Procedure;
import net.mcreator.lunanights.procedures.TimeBar6Procedure;
import net.mcreator.lunanights.procedures.TimeBar5Procedure;
import net.mcreator.lunanights.procedures.TimeBar4Procedure;
import net.mcreator.lunanights.procedures.TimeBar3Procedure;
import net.mcreator.lunanights.procedures.TimeBar2Procedure;
import net.mcreator.lunanights.procedures.TimeBar1Procedure;
import net.mcreator.lunanights.procedures.TimeBar16Procedure;
import net.mcreator.lunanights.procedures.TimeBar15Procedure;
import net.mcreator.lunanights.procedures.TimeBar14Procedure;
import net.mcreator.lunanights.procedures.TimeBar13Procedure;
import net.mcreator.lunanights.procedures.TimeBar12Procedure;
import net.mcreator.lunanights.procedures.TimeBar11Procedure;
import net.mcreator.lunanights.procedures.TimeBar10Procedure;
import net.mcreator.lunanights.procedures.TimeBar0Procedure;
import net.mcreator.lunanights.procedures.TGrestoredOverlayProcedure;
import net.mcreator.lunanights.procedures.ShowTimeProcedure;
import net.mcreator.lunanights.procedures.ShowManaProcedure;
import net.mcreator.lunanights.procedures.ManaDisplayProcedure;
import net.mcreator.lunanights.procedures.ManaBar9Procedure;
import net.mcreator.lunanights.procedures.ManaBar8Procedure;
import net.mcreator.lunanights.procedures.ManaBar7Procedure;
import net.mcreator.lunanights.procedures.ManaBar6Procedure;
import net.mcreator.lunanights.procedures.ManaBar5Procedure;
import net.mcreator.lunanights.procedures.ManaBar4Procedure;
import net.mcreator.lunanights.procedures.ManaBar3Procedure;
import net.mcreator.lunanights.procedures.ManaBar30Procedure;
import net.mcreator.lunanights.procedures.ManaBar2Procedure;
import net.mcreator.lunanights.procedures.ManaBar29Procedure;
import net.mcreator.lunanights.procedures.ManaBar28Procedure;
import net.mcreator.lunanights.procedures.ManaBar27Procedure;
import net.mcreator.lunanights.procedures.ManaBar26Procedure;
import net.mcreator.lunanights.procedures.ManaBar25Procedure;
import net.mcreator.lunanights.procedures.ManaBar24Procedure;
import net.mcreator.lunanights.procedures.ManaBar23Procedure;
import net.mcreator.lunanights.procedures.ManaBar22Procedure;
import net.mcreator.lunanights.procedures.ManaBar21Procedure;
import net.mcreator.lunanights.procedures.ManaBar20Procedure;
import net.mcreator.lunanights.procedures.ManaBar1Procedure;
import net.mcreator.lunanights.procedures.ManaBar19Procedure;
import net.mcreator.lunanights.procedures.ManaBar18Procedure;
import net.mcreator.lunanights.procedures.ManaBar17Procedure;
import net.mcreator.lunanights.procedures.ManaBar16Procedure;
import net.mcreator.lunanights.procedures.ManaBar15Procedure;
import net.mcreator.lunanights.procedures.ManaBar14Procedure;
import net.mcreator.lunanights.procedures.ManaBar13Procedure;
import net.mcreator.lunanights.procedures.ManaBar12Procedure;
import net.mcreator.lunanights.procedures.ManaBar11Procedure;
import net.mcreator.lunanights.procedures.ManaBar10Procedure;
import net.mcreator.lunanights.procedures.ManaBar0Procedure;
import net.mcreator.lunanights.procedures.MPrestoredOverlayProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

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
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (ShowTimeProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_overlay.png"), 12, h - 176, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_16.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_15.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_14.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_13.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_12.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_11.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_10.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_9.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_8.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_7.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_6.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_5.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_4.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_3.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_2.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_1.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (TimeBar0Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/clock_0.png"), 12, h - 178, 0, 0, 156, 156, 156, 156);
			}
			if (ShowManaProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/mana_bar.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar0Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/0.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/1.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/2.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/3.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/4.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/5.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/6.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/7.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/8.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/9.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/10.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar11Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/11.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar12Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/12.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar13Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/13.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar14Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/14.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar15Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/15.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar16Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/16.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar17Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/17.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar18Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/18.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar19Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/19.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar20Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/20.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar21Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/21.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar22Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/22.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar23Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/23.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar24Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/24.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar25Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/25.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar26Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/26.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar27Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/27.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar28Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/28.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar29Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/29.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ManaBar30Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/30.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (ShowManaProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/mp_overlay.png"), 24, h - 34, 0, 0, 156, 12, 156, 12);
			}
			if (TimeStopOverlayFalseProcedure.execute(world, entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/timemove.png"), 92, h - 48, 0, 0, 156, 12, 156, 12);
			}
			if (TimeStopOverlayProcedure.execute(world, entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/timestop.png"), 92, h - 48, 0, 0, 156, 12, 156, 12);
			}
			if (MPrestoredOverlayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/mp_max.png"), 1, h - 138, 0, 0, 120, 11, 120, 11);
			}
			if (TGrestoredOverlayProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/time_max.png"), 1, h - 138, 0, 0, 120, 11, 120, 11);
			}
			if (ShowTimeProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						TimeDisplayProcedure.execute(entity), 99, h - 46, -1, false);
			if (ShowManaProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ManaDisplayProcedure.execute(entity), 31, h - 32, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
