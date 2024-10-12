package net.mcreator.lunanights.procedures;

import net.minecraft.world.entity.Entity;

public class HPDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getBoolean("Healing");
	}
}
