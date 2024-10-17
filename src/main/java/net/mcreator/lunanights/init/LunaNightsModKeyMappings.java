
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.lunanights.network.GlidingKeyMessage;
import net.mcreator.lunanights.network.DoubleJumpMessage;
import net.mcreator.lunanights.LunaNightsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LunaNightsModKeyMappings {
	public static final KeyMapping DOUBLE_JUMP = new KeyMapping("key.luna_nights.double_jump", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new DoubleJumpMessage(0, 0));
				DoubleJumpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GLIDING_KEY = new KeyMapping("key.luna_nights.gliding_key", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LunaNightsMod.PACKET_HANDLER.sendToServer(new GlidingKeyMessage(0, 0));
				GlidingKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GLIDING_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GLIDING_KEY_LASTPRESS);
				LunaNightsMod.PACKET_HANDLER.sendToServer(new GlidingKeyMessage(1, dt));
				GlidingKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long GLIDING_KEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(DOUBLE_JUMP);
		event.register(GLIDING_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				DOUBLE_JUMP.consumeClick();
				GLIDING_KEY.consumeClick();
			}
		}
	}
}