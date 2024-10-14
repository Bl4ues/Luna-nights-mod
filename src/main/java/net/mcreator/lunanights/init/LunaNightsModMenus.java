
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.lunanights.world.inventory.WarpMenuMenu;
import net.mcreator.lunanights.world.inventory.WarpChoiceMenu;
import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LunaNightsMod.MODID);
	public static final RegistryObject<MenuType<WarpMenuMenu>> WARP_MENU = REGISTRY.register("warp_menu", () -> IForgeMenuType.create(WarpMenuMenu::new));
	public static final RegistryObject<MenuType<WarpChoiceMenu>> WARP_CHOICE = REGISTRY.register("warp_choice", () -> IForgeMenuType.create(WarpChoiceMenu::new));
}
