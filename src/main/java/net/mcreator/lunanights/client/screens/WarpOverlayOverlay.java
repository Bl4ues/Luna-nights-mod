package net.mcreator.lunanights.client.screens;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.GameRenderer;
import com.mojang.blaze3d.platform.GlStateManager;

// Import the procedures correctly
import net.mcreator.lunanights.procedures.IfWP1Procedure;
import net.mcreator.lunanights.procedures.IfWP2Procedure;
import net.mcreator.lunanights.procedures.IfWP3Procedure;
import net.mcreator.lunanights.procedures.IfWP4Procedure;
import net.mcreator.lunanights.procedures.IfWP5Procedure;
import net.mcreator.lunanights.procedures.IfWP6Procedure;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class WarpOverlayOverlay {

    @SubscribeEvent
    public static void eventHandler(RenderGuiOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Level world = mc.level;
        Player entity = mc.player;

        if (world == null || entity == null) {
            return;
        }

        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();

        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);

        // Calling the procedures to check if the conditions are met
        if (IfWP1Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_1.png"), 0, 0, 0, 0, w, h, w, h);
        }
        if (IfWP2Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_2.png"), 0, 0, 0, 0, w, h, w, h);
        }
        if (IfWP3Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_3.png"), 0, 0, 0, 0, w, h, w, h);
        }
        if (IfWP4Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_4.png"), 0, 0, 0, 0, w, h, w, h);
        }
        if (IfWP5Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_5.png"), 0, 0, 0, 0, w, h, w, h);
        }
        if (IfWP6Procedure.execute(entity)) {
            event.getGuiGraphics().blit(new ResourceLocation("luna_nights:textures/screens/teleport_overlay_6.png"), 0, 0, 0, 0, w, h, w, h);
        }

        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}
