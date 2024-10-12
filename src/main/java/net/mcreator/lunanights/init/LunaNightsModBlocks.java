
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

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
}
