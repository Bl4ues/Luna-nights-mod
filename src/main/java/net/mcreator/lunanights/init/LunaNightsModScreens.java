
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.lunanights.client.gui.WarpMenuScreen;
import net.mcreator.lunanights.client.gui.WarpChoiceScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LunaNightsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(LunaNightsModMenus.WARP_MENU.get(), WarpMenuScreen::new);
			MenuScreens.register(LunaNightsModMenus.WARP_CHOICE.get(), WarpChoiceScreen::new);
		});
	}
}
