package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.lunanights.network.LunaNightsModVariables;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class DoubleJumpOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.SLOW_FALLING);
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).JumpVar
				&& world.getBlockFloorHeight(BlockPos.containing(entity.getX(), entity.getY() - 0.5, entity.getZ())) > 0) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("luna_nights", "player_animation"));
					if (animation != null) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("luna_nights", "doublejumpland"))));
					}
				}
			}
		}
	}
}
