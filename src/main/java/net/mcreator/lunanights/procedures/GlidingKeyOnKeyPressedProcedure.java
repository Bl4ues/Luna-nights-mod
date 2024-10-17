package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class GlidingKeyOnKeyPressedProcedure {
	public static void execute(LevelAccessor world) {
		LunaNightsModVariables.MapVariables.get(world).GlideVar = true;
		LunaNightsModVariables.MapVariables.get(world).syncData(world);
	}
}
