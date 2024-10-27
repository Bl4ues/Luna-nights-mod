package net.mcreator.lunanights.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.lunanights.entity.TanukiEntity;
import net.mcreator.lunanights.LunaNightsMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class TanukiAttack3Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof TanukiEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			LunaNightsMod.queueServerWork(17, () -> {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof LivingEntity _entity)
								_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
									@Override
									public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
										String _translatekey = "death.attack." + "tanuki";
										if (this.getEntity() == null && this.getDirectEntity() == null) {
											return _msgEntity.getKillCredit() != null
													? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
													: Component.translatable(_translatekey, _msgEntity.getDisplayName());
										} else {
											Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
											ItemStack _itemstack = ItemStack.EMPTY;
											if (this.getEntity() instanceof LivingEntity _livingentity)
												_itemstack = _livingentity.getMainHandItem();
											return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
													? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
													: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
										}
									}
								}, 3);
						}
					}
				}
			});
		}
	}
}
