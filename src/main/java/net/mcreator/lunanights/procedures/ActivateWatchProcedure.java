package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class ActivateWatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Time > 0) {
			if (LunaNightsModVariables.MapVariables.get(world).TimeStop) {
				LunaNightsModVariables.MapVariables.get(world).TimeStop = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			} else {
				LunaNightsModVariables.MapVariables.get(world).TimeStop = true;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			LunaNightsModVariables.MapVariables.get(world).TimeStop = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		TimeStopProcedure.execute(world, x, y, z, entity);
	}
}
