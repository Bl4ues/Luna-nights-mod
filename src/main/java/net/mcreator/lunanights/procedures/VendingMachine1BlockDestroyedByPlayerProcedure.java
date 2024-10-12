package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.init.LunaNightsModBlocks;

public class VendingMachine1BlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, 2 + y, z))).getBlock() == LunaNightsModBlocks.VENDING_MACHINE_2.get()) {
			world.setBlock(BlockPos.containing(x, 2 + y, z), Blocks.AIR.defaultBlockState(), 3);
		} else {
			if ((world.getBlockState(BlockPos.containing(x, 2 + y, z))).getBlock() == LunaNightsModBlocks.VENDING_MACHINE_3.get()) {
				world.setBlock(BlockPos.containing(x, 2 + y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
