package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.init.LunaNightsModBlocks;

import java.util.Map;

public class WGA2BlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 4, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 4, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 5, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 5, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 6, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x - 1, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 6, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(BlockPos.containing(x + 2, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 6, z))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = BlockPos.containing(x, y + 2, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGB_2.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x, y + 4, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGC_2.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x, y + 6, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGD_2.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x - 3, y, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGA_1.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x + 3, y, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGA_3.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x - 3, y + 2, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGB_1.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x + 3, y + 2, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGB_3.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x - 3, y + 4, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGC_1.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x + 3, y + 4, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGC_3.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x - 3, y + 6, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGD_1.get().defaultBlockState(), Direction.SOUTH));
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
				{
					BlockPos _bp = BlockPos.containing(x + 3, y + 6, z);
					BlockState _bs = (new Object() {
						public BlockState with(BlockState _bs, Direction newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
								return _bs.setValue(_dp, newValue);
							_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
							return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
						}
					}.with(LunaNightsModBlocks.WGD_3.get().defaultBlockState(), Direction.SOUTH));
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
			}
		} else {
			if ((new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					else if (_bs.hasProperty(BlockStateProperties.AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
					else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
						return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH) {
				if ((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 4, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 5, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 6, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x - 1, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 6, z))).getBlock() == Blocks.AIR
						&& (world.getBlockState(BlockPos.containing(x + 2, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 6, z))).getBlock() == Blocks.AIR) {
					{
						BlockPos _bp = BlockPos.containing(x, y + 2, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGB_2.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x, y + 4, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGC_2.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x, y + 6, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGD_2.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x + 3, y, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGA_1.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x - 3, y, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGA_3.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x + 3, y + 2, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGB_1.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x - 3, y + 2, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGB_3.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x + 3, y + 4, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGC_1.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x - 3, y + 4, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGC_3.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x + 3, y + 6, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGD_1.get().defaultBlockState(), Direction.NORTH));
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
					{
						BlockPos _bp = BlockPos.containing(x - 3, y + 6, z);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(LunaNightsModBlocks.WGD_3.get().defaultBlockState(), Direction.NORTH));
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
				}
			} else {
				if ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						else if (_bs.hasProperty(BlockStateProperties.AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
						else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
							return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST) {
					if ((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 4, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 4, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 5, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 5, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 6, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x - 1, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 6, z))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + 2, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 6, z))).getBlock() == Blocks.AIR) {
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGB_2.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 4, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGC_2.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 6, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGD_2.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y, z + 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGA_1.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y, z - 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGA_3.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z + 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGB_1.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 2, z - 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGB_3.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 4, z + 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGC_1.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 4, z - 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGC_3.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 6, z + 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGD_1.get().defaultBlockState(), Direction.EAST));
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 6, z - 3);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(LunaNightsModBlocks.WGD_3.get().defaultBlockState(), Direction.EAST));
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
					}
				} else {
					if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							BlockState _bs = world.getBlockState(pos);
							Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (property != null && _bs.getValue(property) instanceof Direction _dir)
								return _dir;
							else if (_bs.hasProperty(BlockStateProperties.AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
							else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
								return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
							return Direction.NORTH;
						}
					}.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST) {
						if ((world.getBlockState(BlockPos.containing(x - 3, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 1, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 2, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 3, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 4, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 4, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 4, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 4, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 5, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 5, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 5, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 3, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 2, y + 6, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x - 1, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y + 6, z))).getBlock() == Blocks.AIR
								&& (world.getBlockState(BlockPos.containing(x + 2, y + 6, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 3, y + 6, z))).getBlock() == Blocks.AIR) {
							{
								BlockPos _bp = BlockPos.containing(x, y + 2, z);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGB_2.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 4, z);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGC_2.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 6, z);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGD_2.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y, z - 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGA_1.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y, z + 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGA_3.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 2, z - 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGB_1.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 2, z + 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGB_3.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 4, z - 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGC_1.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 4, z + 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGC_3.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 6, z - 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGD_1.get().defaultBlockState(), Direction.WEST));
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
							{
								BlockPos _bp = BlockPos.containing(x, y + 6, z + 3);
								BlockState _bs = (new Object() {
									public BlockState with(BlockState _bs, Direction newValue) {
										Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
										if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
											return _bs.setValue(_dp, newValue);
										_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
										return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
									}
								}.with(LunaNightsModBlocks.WGD_3.get().defaultBlockState(), Direction.WEST));
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
						}
					}
				}
			}
		}
	}
}
