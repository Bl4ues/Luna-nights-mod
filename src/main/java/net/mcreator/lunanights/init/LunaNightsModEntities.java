
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.lunanights.entity.KnifesProjectileEntity;
import net.mcreator.lunanights.entity.KnifeFreezeEntity;
import net.mcreator.lunanights.entity.HitodamaEntity;
import net.mcreator.lunanights.LunaNightsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LunaNightsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LunaNightsMod.MODID);
	public static final RegistryObject<EntityType<KnifeFreezeEntity>> KNIFE_FREEZE = register("knife_freeze",
			EntityType.Builder.<KnifeFreezeEntity>of(KnifeFreezeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KnifeFreezeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KnifesProjectileEntity>> KNIFES_PROJECTILE = register("projectile_knifes_projectile", EntityType.Builder.<KnifesProjectileEntity>of(KnifesProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(KnifesProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HitodamaEntity>> HITODAMA = register("hitodama",
			EntityType.Builder.<HitodamaEntity>of(HitodamaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(20).setUpdateInterval(3).setCustomClientFactory(HitodamaEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			KnifeFreezeEntity.init();
			HitodamaEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(KNIFE_FREEZE.get(), KnifeFreezeEntity.createAttributes().build());
		event.put(HITODAMA.get(), HitodamaEntity.createAttributes().build());
	}
}
