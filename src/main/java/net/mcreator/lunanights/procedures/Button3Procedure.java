package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.LunaNightsMod;

public class Button3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		EffectsProcedure.execute(world, x, y, z, entity);
		LunaNightsMod.queueServerWork(60, () -> {
			{
				Entity _ent = entity;
				_ent.teleportTo(LunaNightsModVariables.MapVariables.get(world).Warp3_X, LunaNightsModVariables.MapVariables.get(world).Warp3_Y, LunaNightsModVariables.MapVariables.get(world).Warp3_Z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(LunaNightsModVariables.MapVariables.get(world).Warp3_X, LunaNightsModVariables.MapVariables.get(world).Warp3_Y, LunaNightsModVariables.MapVariables.get(world).Warp3_Z, _ent.getYRot(),
							_ent.getXRot());
			}
		});
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
