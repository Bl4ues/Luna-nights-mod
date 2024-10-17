
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

import net.mcreator.lunanights.item.TopazItem;
import net.mcreator.lunanights.item.TimeTicketItem;
import net.mcreator.lunanights.item.SapphireItem;
import net.mcreator.lunanights.item.RubyItem;
import net.mcreator.lunanights.item.PocketWatchItem;
import net.mcreator.lunanights.item.ManaTicketItem;
import net.mcreator.lunanights.item.MaidOutfitItem;
import net.mcreator.lunanights.item.LinkRemoverItem;
import net.mcreator.lunanights.item.KnifesProjectileModelItem;
import net.mcreator.lunanights.item.KnifesItem;
import net.mcreator.lunanights.item.IconItem;
import net.mcreator.lunanights.item.EmeraldTLNItem;
import net.mcreator.lunanights.item.AquamarineItem;
import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LunaNightsMod.MODID);
	public static final RegistryObject<Item> KNIFES = REGISTRY.register("knifes", () -> new KnifesItem());
	public static final RegistryObject<Item> POCKET_WATCH = REGISTRY.register("pocket_watch", () -> new PocketWatchItem());
	public static final RegistryObject<Item> MANA_TICKET = REGISTRY.register("mana_ticket", () -> new ManaTicketItem());
	public static final RegistryObject<Item> TIME_TICKET = REGISTRY.register("time_ticket", () -> new TimeTicketItem());
	public static final RegistryObject<Item> SAVE_TELEPHONE = block(LunaNightsModBlocks.SAVE_TELEPHONE);
	public static final RegistryObject<Item> VENDING_MACHINE_1 = block(LunaNightsModBlocks.VENDING_MACHINE_1);
	public static final RegistryObject<Item> WGA_2 = block(LunaNightsModBlocks.WGA_2);
	public static final RegistryObject<Item> LINK_REMOVER = REGISTRY.register("link_remover", () -> new LinkRemoverItem());
	public static final RegistryObject<Item> ICON = REGISTRY.register("icon", () -> new IconItem());
	public static final RegistryObject<Item> SAVE_TELEPHONE_SIGN = block(LunaNightsModBlocks.SAVE_TELEPHONE_SIGN);
	public static final RegistryObject<Item> VENDING_MACHINE_2 = block(LunaNightsModBlocks.VENDING_MACHINE_2);
	public static final RegistryObject<Item> VENDING_MACHINE_3 = block(LunaNightsModBlocks.VENDING_MACHINE_3);
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
	public static final RegistryObject<Item> AQUAMARINE = REGISTRY.register("aquamarine", () -> new AquamarineItem());
	public static final RegistryObject<Item> TOPAZ = REGISTRY.register("topaz", () -> new TopazItem());
	public static final RegistryObject<Item> RUBY = REGISTRY.register("ruby", () -> new RubyItem());
	public static final RegistryObject<Item> SAPPHIRE = REGISTRY.register("sapphire", () -> new SapphireItem());
	public static final RegistryObject<Item> EMERALD_TLN = REGISTRY.register("emerald_tln", () -> new EmeraldTLNItem());
	public static final RegistryObject<Item> KNIFES_PROJECTILE_MODEL = REGISTRY.register("knifes_projectile_model", () -> new KnifesProjectileModelItem());
	public static final RegistryObject<Item> MAID_OUTFIT_HELMET = REGISTRY.register("maid_outfit_helmet", () -> new MaidOutfitItem.Helmet());
	public static final RegistryObject<Item> MAID_OUTFIT_CHESTPLATE = REGISTRY.register("maid_outfit_chestplate", () -> new MaidOutfitItem.Chestplate());
	public static final RegistryObject<Item> MAID_OUTFIT_LEGGINGS = REGISTRY.register("maid_outfit_leggings", () -> new MaidOutfitItem.Leggings());
	public static final RegistryObject<Item> MAID_OUTFIT_BOOTS = REGISTRY.register("maid_outfit_boots", () -> new MaidOutfitItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
