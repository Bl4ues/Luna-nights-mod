package net.mcreator.lunanights.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.lunanights.world.inventory.WarpChoiceMenu;
import net.mcreator.lunanights.procedures.Label7LogicProcedure;
import net.mcreator.lunanights.procedures.Label6LogicProcedure;
import net.mcreator.lunanights.procedures.Label5LogicProcedure;
import net.mcreator.lunanights.procedures.Label4LogicProcedure;
import net.mcreator.lunanights.procedures.Label3LogicProcedure;
import net.mcreator.lunanights.procedures.Label2LogicProcedure;
import net.mcreator.lunanights.procedures.Label1LogicProcedure;
import net.mcreator.lunanights.procedures.Button7LogicProcedure;
import net.mcreator.lunanights.procedures.Button6LogicProcedure;
import net.mcreator.lunanights.procedures.Button5LogicProcedure;
import net.mcreator.lunanights.procedures.Button4LogicProcedure;
import net.mcreator.lunanights.procedures.Button3LogicProcedure;
import net.mcreator.lunanights.procedures.Button2LogicProcedure;
import net.mcreator.lunanights.procedures.Button1LogicProcedure;
import net.mcreator.lunanights.network.WarpChoiceButtonMessage;
import net.mcreator.lunanights.LunaNightsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WarpChoiceScreen extends AbstractContainerScreen<WarpChoiceMenu> {
	private final static HashMap<String, Object> guistate = WarpChoiceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_button1;
	Button button_button2;
	Button button_button3;
	Button button_button4;
	Button button_button5;
	Button button_button6;
	Button button_button7;

	public WarpChoiceScreen(WarpChoiceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 163;
		this.imageHeight = 183;
	}

	private static final ResourceLocation texture = new ResourceLocation("luna_nights:textures/screens/warp_choice.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (Button1LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label1LogicProcedure.execute(world), 9, 17, -12829636, false);
		if (Button2LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label2LogicProcedure.execute(world), 9, 42, -12829636, false);
		if (Button3LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label3LogicProcedure.execute(world), 9, 67, -12829636, false);
		if (Button4LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label4LogicProcedure.execute(world), 9, 92, -12829636, false);
		if (Button5LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label5LogicProcedure.execute(world), 9, 117, -12829636, false);
		if (Button6LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label6LogicProcedure.execute(world), 9, 142, -12829636, false);
		if (Button7LogicProcedure.execute(world))
			guiGraphics.drawString(this.font,

					Label7LogicProcedure.execute(world), 9, 167, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_1"), 4, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_2"), 4, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_3"), 4, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_4"), 4, 82, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_5"), 4, 107, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_6"), 4, 132, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luna_nights.warp_choice.label_7"), 4, 157, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_button1 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button1"), e -> {
			if (Button1LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(0, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 7, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button1LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button1", button_button1);
		this.addRenderableWidget(button_button1);
		button_button2 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button2"), e -> {
			if (Button2LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(1, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 32, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button2LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button2", button_button2);
		this.addRenderableWidget(button_button2);
		button_button3 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button3"), e -> {
			if (Button3LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(2, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 57, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button3LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button3", button_button3);
		this.addRenderableWidget(button_button3);
		button_button4 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button4"), e -> {
			if (Button4LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(3, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 82, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button4LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button4", button_button4);
		this.addRenderableWidget(button_button4);
		button_button5 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button5"), e -> {
			if (Button5LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(4, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 107, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button5LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button5", button_button5);
		this.addRenderableWidget(button_button5);
		button_button6 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button6"), e -> {
			if (Button6LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(5, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 132, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button6LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button6", button_button6);
		this.addRenderableWidget(button_button6);
		button_button7 = Button.builder(Component.translatable("gui.luna_nights.warp_choice.button_button7"), e -> {
			if (Button7LogicProcedure.execute(world)) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new WarpChoiceButtonMessage(6, x, y, z));
				WarpChoiceButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 94, this.topPos + 157, 61, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Button7LogicProcedure.execute(world))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_button7", button_button7);
		this.addRenderableWidget(button_button7);
	}
}
