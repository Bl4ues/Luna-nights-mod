package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
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
public class PocketTimeUsageAndAnimationProcedure {
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
			{
				double _setval = (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Time - 0.5;
				entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Time <= 1) {
			LunaNightsModVariables.MapVariables.get(world).TimeStop = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
			TimeStopProcedure.execute(world, x, y, z, entity);
		}
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LunaNightsModItems.POCKET_WATCH.get())) : false) {
				if (entity.isNoGravity() == false) {
					if ((world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).createLegacyBlock()).getFluidState().isSource()
							|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock
							|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ())).createLegacyBlock()).getFluidState().isSource()
							|| (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ())).createLegacyBlock()).getBlock() instanceof LiquidBlock) {
						entity.setNoGravity(true);
						if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).WalkOnWater == false) {
							entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
						}
					} else {
						entity.setNoGravity(false);
					}
				}
			}
		}
	}
}
