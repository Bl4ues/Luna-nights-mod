package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.init.LunaNightsModBlocks;

import java.util.Map;

public class B2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == LunaNightsModBlocks.WGB_3.get() && (world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == LunaNightsModBlocks.WGB_1.get()
				&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == LunaNightsModBlocks.WGC_2.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == LunaNightsModBlocks.WGA_2.get()) == true) {
			{
				BlockPos _bp = BlockPos.containing(x, y + 1, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else {
			if (((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == LunaNightsModBlocks.WGB_3.get() && (world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == LunaNightsModBlocks.WGB_1.get()
					&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == LunaNightsModBlocks.WGC_2.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == LunaNightsModBlocks.WGA_2.get()) == true) {
				{
					BlockPos _bp = BlockPos.containing(x, y + 1, z);
					BlockState _bs = Blocks.AIR.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			} else {
				if (((world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock() == LunaNightsModBlocks.WGB_3.get() && (world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock() == LunaNightsModBlocks.WGB_1.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == LunaNightsModBlocks.WGC_2.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == LunaNightsModBlocks.WGA_2.get()) == true) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockState _bs = Blocks.AIR.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				} else {
					if (((world.getBlockState(BlockPos.containing(x, y, z + 3))).getBlock() == LunaNightsModBlocks.WGB_3.get() && (world.getBlockState(BlockPos.containing(x, y, z - 3))).getBlock() == LunaNightsModBlocks.WGB_1.get()
							&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == LunaNightsModBlocks.WGC_2.get() && (world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == LunaNightsModBlocks.WGA_2.get()) == true) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = Blocks.AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					} else {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
		}
	}
}
