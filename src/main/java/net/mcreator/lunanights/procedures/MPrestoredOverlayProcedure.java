package net.mcreator.lunanights.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class MPrestoredOverlayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).MPrestoredOverlay;
	}
}
