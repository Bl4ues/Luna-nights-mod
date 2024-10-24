package net.mcreator.lunanights.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.lunanights.world.inventory.WarpMenuMenu;
import net.mcreator.lunanights.network.WarpMenuButtonMessage;
import net.mcreator.lunanights.LunaNightsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WarpMenuScreen extends AbstractContainerScreen<WarpMenuMenu> {
	private final static HashMap<String, Object> guistate = WarpMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox WarpGateName;
	Button button_accept;

	public WarpMenuScreen(WarpMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 127;
		this.imageHeight = 71;
	}

	private static final ResourceLocation texture = new ResourceLocation("luna_nights:textures/screens/warp_menu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		WarpGateName.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("luna_nights:textures/screens/warp_gate.png"), this.leftPos + 6, this.topPos + 5, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (WarpGateName.isFocused())
			return WarpGateName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		WarpGateName.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_menu.label_warp_gate"), 23, 9, -16777216, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		WarpGateName = new EditBox(this.font, this.leftPos + 4, this.topPos + 26, 118, 18, Component.translatable("gui.luna_nights.warp_menu.WarpGateName")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.luna_nights.warp_menu.WarpGateName").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.luna_nights.warp_menu.WarpGateName").getString());
				else
					setSuggestion(null);
			}
		};
		WarpGateName.setSuggestion(Component.translatable("gui.luna_nights.warp_menu.WarpGateName").getString());
		WarpGateName.setMaxLength(32767);
		guistate.put("text:WarpGateName", WarpGateName);
		this.addWidget(this.WarpGateName);
		button_accept = Button.builder(Component.translatable("gui.luna_nights.warp_menu.button_accept"), e -> {
			if (true) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpMenuButtonMessage(0, x, y, z));
				WarpMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 66, this.topPos + 46, 56, 20).build();
		guistate.put("button:button_accept", button_accept);
		this.addRenderableWidget(button_accept);
	}
}
