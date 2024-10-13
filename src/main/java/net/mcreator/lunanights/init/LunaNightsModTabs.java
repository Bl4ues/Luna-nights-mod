
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LunaNightsMod.MODID);
	public static final RegistryObject<CreativeModeTab> TOUHOU_LUNA_NIGHTS = REGISTRY.register("touhou_luna_nights",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.luna_nights.touhou_luna_nights")).icon(() -> new ItemStack(LunaNightsModItems.ICON.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LunaNightsModBlocks.SAVE_TELEPHONE.get().asItem());
				tabData.accept(LunaNightsModBlocks.VENDING_MACHINE_1.get().asItem());
				tabData.accept(LunaNightsModBlocks.WGA_2.get().asItem());
			})

					.build());
}
