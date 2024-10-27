
package net.mcreator.lunanights.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.lunanights.procedures.TopazCountProcedure;
import net.mcreator.lunanights.procedures.SapphireCountProcedure;
import net.mcreator.lunanights.procedures.RubyCountProcedure;
import net.mcreator.lunanights.procedures.GemCountDisplayOverlayIngameProcedure;
import net.mcreator.lunanights.procedures.EmeraldCountProcedure;
import net.mcreator.lunanights.procedures.AquaCountProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class GemCountOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof InventoryScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
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
			if (GemCountDisplayOverlayIngameProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/gems.png"), 2, h - 229, 0, 0, 150, 100, 150, 100);

				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						AquaCountProcedure.execute(entity), 28, h - 224, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						TopazCountProcedure.execute(entity), 28, h - 205, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						RubyCountProcedure.execute(entity), 28, h - 186, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						SapphireCountProcedure.execute(entity), 28, h - 167, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						EmeraldCountProcedure.execute(entity), 28, h - 148, -1, false);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
