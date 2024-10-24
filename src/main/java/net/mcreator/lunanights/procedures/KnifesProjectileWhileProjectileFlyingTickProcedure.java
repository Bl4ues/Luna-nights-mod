package net.mcreator.lunanights.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModEntities;
import net.mcreator.lunanights.entity.KnifesProjectileEntity;
import net.mcreator.lunanights.LunaNightsMod;

import java.util.List;
import java.util.Comparator;

public class KnifesProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("yaw", (entity.getYRot()));
		entity.getPersistentData().putDouble("pitch", (entity.getXRot()));
		if (LunaNightsModVariables.MapVariables.get(world).TimeStop == true) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof KnifesProjectileEntity) {
						LunaNightsMod.queueServerWork(3, () -> {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = LunaNightsModEntities.KNIFE_FREEZE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot((float) entity.getPersistentData().getDouble("yaw"));
									entityToSpawn.setYBodyRot((float) entity.getPersistentData().getDouble("yaw"));
									entityToSpawn.setYHeadRot((float) entity.getPersistentData().getDouble("yaw"));
									entityToSpawn.setXRot((float) entity.getPersistentData().getDouble("pitch"));
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						});
					}
				}
			}
		}
	}
}
