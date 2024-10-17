package net.mcreator.lunanights.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;

public class DoubleJumpOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getBlockState(BlockPos.containing(x, y - 0.5, z)).canOcclude()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == LunaNightsModItems.MAID_OUTFIT_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == LunaNightsModItems.MAID_OUTFIT_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == LunaNightsModItems.MAID_OUTFIT_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == LunaNightsModItems.MAID_OUTFIT_BOOTS.get()
				&& (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).JumpVar == false) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.5), (entity.getDeltaMovement().z())));
			{
				boolean _setval = true;
				entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JumpVar = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 1, 1, 1, 2);
		}
	}
}
