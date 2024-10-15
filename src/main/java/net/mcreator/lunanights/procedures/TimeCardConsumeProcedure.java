package net.mcreator.lunanights.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class TimeCardConsumeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).MaxTime + 20;
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaxTime = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).TimeMultiplier + 1;
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TimeMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
