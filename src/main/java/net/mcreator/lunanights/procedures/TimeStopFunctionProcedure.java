package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TimeStopFunctionProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop) {
			if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(LunaNightsModItems.POCKET_WATCH.get())) : false) == false) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().stop();
				entity.setNoGravity(true);
				entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				if (entity instanceof Mob _mob) {
					_mob.setNoAi(true);
				}
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			}
		} else {
			entity.setNoGravity(false);
			if (entity instanceof Mob _mob) {
				_mob.setNoAi(false);
			}
		}
	}
}
