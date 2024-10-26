package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;
import net.mcreator.lunanights.init.LunaNightsModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WalkOnWaterProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LunaNightsModItems.POCKET_WATCH.get())) : false) {
				if (!((entity.isInWater() || entity.isInWaterOrBubble() || entity.isInLava()) && (entity.isSwimming() || entity.isUnderWater()))) {
					if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.VOID_AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
							&& ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).createLegacyBlock()).getFluidState().isSource()
									|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == LunaNightsModBlocks.INVISI_BLOCK_1.get())) {
							entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.2), (entity.getDeltaMovement().z())));
						}
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), LunaNightsModBlocks.INVISI_BLOCK_1.get().defaultBlockState(), 3);
					} else {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.VOID_AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
							&& ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1)).createLegacyBlock()).getFluidState().isSource()
									|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1)).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), LunaNightsModBlocks.INVISI_BLOCK_2.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.SOUTH;
							BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ());
							BlockState _bs = world.getBlockState(_pos);
							Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
								world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
							} else {
								_property = _bs.getBlock().getStateDefinition().getProperty("axis");
								if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
									world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
							}
						}
					} else {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.VOID_AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
							&& ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1)).createLegacyBlock()).getFluidState().isSource()
									|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1)).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), LunaNightsModBlocks.INVISI_BLOCK_2.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.NORTH;
							BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ());
							BlockState _bs = world.getBlockState(_pos);
							Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
								world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
							} else {
								_property = _bs.getBlock().getStateDefinition().getProperty("axis");
								if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
									world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
							}
						}
					} else {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.VOID_AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
							&& ((world.getFluidState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ())).createLegacyBlock()).getFluidState().isSource()
									|| (world.getFluidState(BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), LunaNightsModBlocks.INVISI_BLOCK_2.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.WEST;
							BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ());
							BlockState _bs = world.getBlockState(_pos);
							Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
								world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
							} else {
								_property = _bs.getBlock().getStateDefinition().getProperty("axis");
								if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
									world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
							}
						}
					} else {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.VOID_AIR
							|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
							&& ((world.getFluidState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ())).createLegacyBlock()).getFluidState().isSource()
									|| (world.getFluidState(BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						world.setBlock(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), LunaNightsModBlocks.INVISI_BLOCK_2.get().defaultBlockState(), 3);
						{
							Direction _dir = Direction.EAST;
							BlockPos _pos = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ());
							BlockState _bs = world.getBlockState(_pos);
							Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
							if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
								world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
							} else {
								_property = _bs.getBlock().getStateDefinition().getProperty("axis");
								if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
									world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
							}
						}
					} else {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WalkOnWater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
