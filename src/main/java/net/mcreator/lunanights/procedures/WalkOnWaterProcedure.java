package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WalkOnWaterProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LunaNightsModItems.POCKET_WATCH.get())) : false) {
				if (((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.AIR
						|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.VOID_AIR
						|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == Blocks.CAVE_AIR)
						&& ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).createLegacyBlock()).getFluidState().isSource()
								|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock)) {
					{
						boolean _setval = true;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WalkOnWater = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.setNoGravity(true);
				} else {
					{
						boolean _setval = false;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WalkOnWater = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.setNoGravity(false);
				}
			}
		}
	}
}
