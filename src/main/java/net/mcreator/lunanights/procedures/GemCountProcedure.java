package net.mcreator.lunanights.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GemCountProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("" + (new ItemStack(LunaNightsModItems.AQUAMARINE.get()).getCount() - 0.9));
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AquamarineCount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("" + (new ItemStack(LunaNightsModItems.TOPAZ.get()).getCount() - 0.9));
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TopazCount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("" + (new ItemStack(LunaNightsModItems.RUBY.get()).getCount() - 0.9));
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RubyCount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("" + (new ItemStack(LunaNightsModItems.SAPPHIRE.get()).getCount() - 0.9));
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SapphireCount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert("" + (new ItemStack(LunaNightsModItems.EMERALD_TLN.get()).getCount() - 0.9));
			entity.getCapability(LunaNightsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EmeraldCount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
