
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

import net.mcreator.lunanights.item.PocketWatchItem;
import net.mcreator.lunanights.item.LinkRemoverItem;
import net.mcreator.lunanights.item.KnifesItem;
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
	public static final RegistryObject<Item> WGA_2 = block(LunaNightsModBlocks.WGA_2);
	public static final RegistryObject<Item> WGB_2 = block(LunaNightsModBlocks.WGB_2);
	public static final RegistryObject<Item> WGA_1 = block(LunaNightsModBlocks.WGA_1);
	public static final RegistryObject<Item> WGA_3 = block(LunaNightsModBlocks.WGA_3);
	public static final RegistryObject<Item> WGB_1 = block(LunaNightsModBlocks.WGB_1);
	public static final RegistryObject<Item> WGB_3 = block(LunaNightsModBlocks.WGB_3);
	public static final RegistryObject<Item> WGC_1 = block(LunaNightsModBlocks.WGC_1);
	public static final RegistryObject<Item> WGC_2 = block(LunaNightsModBlocks.WGC_2);
	public static final RegistryObject<Item> WGC_3 = block(LunaNightsModBlocks.WGC_3);
	public static final RegistryObject<Item> WGD_1 = block(LunaNightsModBlocks.WGD_1);
	public static final RegistryObject<Item> WGD_3 = block(LunaNightsModBlocks.WGD_3);
	public static final RegistryObject<Item> WGD_2 = block(LunaNightsModBlocks.WGD_2);
	public static final RegistryObject<Item> WGD_2_SYMBOL = block(LunaNightsModBlocks.WGD_2_SYMBOL);
	public static final RegistryObject<Item> LINK_REMOVER = REGISTRY.register("link_remover", () -> new LinkRemoverItem());
	public static final RegistryObject<Item> POCKET_WATCH = REGISTRY.register("pocket_watch", () -> new PocketWatchItem());
	public static final RegistryObject<Item> KNIFES = REGISTRY.register("knifes", () -> new KnifesItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
