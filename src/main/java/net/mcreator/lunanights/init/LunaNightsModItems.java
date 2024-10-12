
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.lunanights.item.IconItem;
import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LunaNightsMod.MODID);
	public static final RegistryObject<Item> SAVE_TELEPHONE = block(LunaNightsModBlocks.SAVE_TELEPHONE);
	public static final RegistryObject<Item> ICON = REGISTRY.register("icon", () -> new IconItem());
	public static final RegistryObject<Item> SAVE_TELEPHONE_SIGN = block(LunaNightsModBlocks.SAVE_TELEPHONE_SIGN);
	public static final RegistryObject<Item> VENDING_MACHINE_1 = block(LunaNightsModBlocks.VENDING_MACHINE_1);
	public static final RegistryObject<Item> VENDING_MACHINE_2 = block(LunaNightsModBlocks.VENDING_MACHINE_2);
	public static final RegistryObject<Item> VENDING_MACHINE_3 = block(LunaNightsModBlocks.VENDING_MACHINE_3);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
