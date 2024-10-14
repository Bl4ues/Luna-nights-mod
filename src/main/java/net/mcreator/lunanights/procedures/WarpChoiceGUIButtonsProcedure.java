package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.lunanights.network.LunaNightsModVariables;

public class WarpChoiceGUIButtonsProcedure {
	public static void execute(LevelAccessor world) {
		if ((LunaNightsModVariables.MapVariables.get(world).Warp1Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp1 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp1 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp2Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp2 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp2 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp3Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp3 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp3 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp4Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp4 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp4 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp5Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp5 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp5 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp6Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp6 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp6 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LunaNightsModVariables.MapVariables.get(world).Warp7Name).isEmpty()) {
			LunaNightsModVariables.MapVariables.get(world).Warp7 = false;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LunaNightsModVariables.MapVariables.get(world).Warp7 = true;
			LunaNightsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
