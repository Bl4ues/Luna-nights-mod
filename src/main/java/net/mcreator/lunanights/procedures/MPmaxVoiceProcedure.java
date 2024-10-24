package net.mcreator.lunanights.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.LunaNightsMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MPmaxVoiceProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Mana < (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LunaNightsModVariables.PlayerVariables())).MaxMana) {
			{
				boolean _setval = true;
				entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MPLoop = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).MPLoop && !entity.getPersistentData().getBoolean("Healing")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:mpmax")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:mpmax")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MPrestoredOverlay = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				LunaNightsMod.queueServerWork(25, () -> {
					{
						boolean _setval = false;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MPrestoredOverlay = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				{
					boolean _setval = false;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MPLoop = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).Time < (entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LunaNightsModVariables.PlayerVariables())).MaxTime) {
			{
				boolean _setval = true;
				entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TGLoop = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if ((entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LunaNightsModVariables.PlayerVariables())).TGLoop) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:tgmax")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:tgmax")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.TGrestoredOverlay = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				LunaNightsMod.queueServerWork(25, () -> {
					{
						boolean _setval = false;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.TGrestoredOverlay = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				{
					boolean _setval = false;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.TGLoop = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
