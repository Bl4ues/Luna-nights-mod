
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.lunanights.block.WGD3Block;
import net.mcreator.lunanights.block.WGD2SymbolBlock;
import net.mcreator.lunanights.block.WGD2Block;
import net.mcreator.lunanights.block.WGD1Block;
import net.mcreator.lunanights.block.WGC3Block;
import net.mcreator.lunanights.block.WGC2Block;
import net.mcreator.lunanights.block.WGC1Block;
import net.mcreator.lunanights.block.WGB3Block;
import net.mcreator.lunanights.block.WGB2Block;
import net.mcreator.lunanights.block.WGB1Block;
import net.mcreator.lunanights.block.WGA3Block;
import net.mcreator.lunanights.block.WGA2Block;
import net.mcreator.lunanights.block.WGA1Block;
import net.mcreator.lunanights.block.VendingMachine3Block;
import net.mcreator.lunanights.block.VendingMachine2Block;
import net.mcreator.lunanights.block.VendingMachine1Block;
import net.mcreator.lunanights.block.SaveTelephoneSignBlock;
import net.mcreator.lunanights.block.SaveTelephoneBlock;
import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, LunaNightsMod.MODID);
	public static final RegistryObject<Block> SAVE_TELEPHONE = REGISTRY.register("save_telephone", () -> new SaveTelephoneBlock());
	public static final RegistryObject<Block> SAVE_TELEPHONE_SIGN = REGISTRY.register("save_telephone_sign", () -> new SaveTelephoneSignBlock());
	public static final RegistryObject<Block> VENDING_MACHINE_1 = REGISTRY.register("vending_machine_1", () -> new VendingMachine1Block());
	public static final RegistryObject<Block> VENDING_MACHINE_2 = REGISTRY.register("vending_machine_2", () -> new VendingMachine2Block());
	public static final RegistryObject<Block> VENDING_MACHINE_3 = REGISTRY.register("vending_machine_3", () -> new VendingMachine3Block());
	public static final RegistryObject<Block> WGA_2 = REGISTRY.register("wga_2", () -> new WGA2Block());
	public static final RegistryObject<Block> WGB_2 = REGISTRY.register("wgb_2", () -> new WGB2Block());
	public static final RegistryObject<Block> WGA_1 = REGISTRY.register("wga_1", () -> new WGA1Block());
	public static final RegistryObject<Block> WGA_3 = REGISTRY.register("wga_3", () -> new WGA3Block());
	public static final RegistryObject<Block> WGB_1 = REGISTRY.register("wgb_1", () -> new WGB1Block());
	public static final RegistryObject<Block> WGB_3 = REGISTRY.register("wgb_3", () -> new WGB3Block());
	public static final RegistryObject<Block> WGC_1 = REGISTRY.register("wgc_1", () -> new WGC1Block());
	public static final RegistryObject<Block> WGC_2 = REGISTRY.register("wgc_2", () -> new WGC2Block());
	public static final RegistryObject<Block> WGC_3 = REGISTRY.register("wgc_3", () -> new WGC3Block());
	public static final RegistryObject<Block> WGD_1 = REGISTRY.register("wgd_1", () -> new WGD1Block());
	public static final RegistryObject<Block> WGD_3 = REGISTRY.register("wgd_3", () -> new WGD3Block());
	public static final RegistryObject<Block> WGD_2 = REGISTRY.register("wgd_2", () -> new WGD2Block());
	public static final RegistryObject<Block> WGD_2_SYMBOL = REGISTRY.register("wgd_2_symbol", () -> new WGD2SymbolBlock());
}
