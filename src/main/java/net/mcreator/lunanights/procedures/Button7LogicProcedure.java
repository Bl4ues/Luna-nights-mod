package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class Button7LogicProcedure {
	public static boolean execute(LevelAccessor world) {
		return LunaNightsModVariables.MapVariables.get(world).Warp7;
	}
}
