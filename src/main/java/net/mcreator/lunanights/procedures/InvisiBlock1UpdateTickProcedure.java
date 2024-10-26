package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class InvisiBlock1UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop == false) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
