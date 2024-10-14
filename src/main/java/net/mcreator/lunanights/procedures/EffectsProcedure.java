package net.mcreator.lunanights.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.LunaNightsMod;

public class EffectsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 1, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 100, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 200, false, false));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:warp")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("luna_nights:warp")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 10, 3, 3, 3, 1);
		LunaNightsMod.queueServerWork(20, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 20, 3, 3, 3, 1);
			LunaNightsMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 40, 3, 3, 3, 1);
				LunaNightsMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 80, 3, 3, 3, 1);
				});
			});
		});
		LunaNightsMod.queueServerWork(10, () -> {
			{
				boolean _setval = true;
				entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WarpOverlay_1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			LunaNightsMod.queueServerWork(10, () -> {
				{
					boolean _setval = false;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WarpOverlay_1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WarpOverlay_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				LunaNightsMod.queueServerWork(10, () -> {
					{
						boolean _setval = false;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WarpOverlay_2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WarpOverlay_3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					LunaNightsMod.queueServerWork(10, () -> {
						{
							boolean _setval = false;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WarpOverlay_3 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WarpOverlay_4 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						LunaNightsMod.queueServerWork(10, () -> {
							{
								boolean _setval = false;
								entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.WarpOverlay_4 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = true;
								entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.WarpOverlay_5 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							LunaNightsMod.queueServerWork(10, () -> {
								{
									boolean _setval = false;
									entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WarpOverlay_5 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = true;
									entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WarpOverlay_6 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								LunaNightsMod.queueServerWork(2, () -> {
									{
										boolean _setval = false;
										entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.WarpOverlay_6 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										boolean _setval = true;
										entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.WarpOverlay_5 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									LunaNightsMod.queueServerWork(2, () -> {
										{
											boolean _setval = false;
											entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.WarpOverlay_5 = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											boolean _setval = true;
											entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.WarpOverlay_4 = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										LunaNightsMod.queueServerWork(2, () -> {
											{
												boolean _setval = false;
												entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.WarpOverlay_4 = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											{
												boolean _setval = true;
												entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.WarpOverlay_3 = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											LunaNightsMod.queueServerWork(2, () -> {
												{
													boolean _setval = false;
													entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.WarpOverlay_3 = _setval;
														capability.syncPlayerVariables(entity);
													});
												}
												{
													boolean _setval = true;
													entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
														capability.WarpOverlay_2 = _setval;
														capability.syncPlayerVariables(entity);
													});
												}
												LunaNightsMod.queueServerWork(2, () -> {
													{
														boolean _setval = false;
														entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.WarpOverlay_2 = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
													{
														boolean _setval = true;
														entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.WarpOverlay_1 = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
													LunaNightsMod.queueServerWork(2, () -> {
														{
															boolean _setval = false;
															entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
																capability.WarpOverlay_1 = _setval;
																capability.syncPlayerVariables(entity);
															});
														}
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
