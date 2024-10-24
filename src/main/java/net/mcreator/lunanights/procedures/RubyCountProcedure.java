package net.mcreator.lunanights.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class RubyCountProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).RubyCount);
	}
}
