package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class Label4LogicProcedure {
	public static String execute(LevelAccessor world) {
		return LunaNightsModVariables.MapVariables.get(world).Warp4Name;
	}
}
