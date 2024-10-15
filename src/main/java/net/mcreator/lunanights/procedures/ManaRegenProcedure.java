package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.LunaNightsMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaRegenProcedure {
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
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Mana < (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LunaNightsModVariables.PlayerVariables())).MaxMana) {
			LunaNightsMod.queueServerWork(1, () -> {
				{
					double _setval = (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Mana + 0.1
							+ (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).AquamarineCount;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
