
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.lunanights.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.lunanights.LunaNightsMod;

public class LunaNightsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LunaNightsMod.MODID);
	public static final RegistryObject<SoundEvent> TEL_SAVE = REGISTRY.register("tel_save", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "tel_save")));
	public static final RegistryObject<SoundEvent> SODA_MACHINE = REGISTRY.register("soda_machine", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "soda_machine")));
	public static final RegistryObject<SoundEvent> WARP = REGISTRY.register("warp", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "warp")));
	public static final RegistryObject<SoundEvent> TIMESTOP = REGISTRY.register("timestop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "timestop")));
	public static final RegistryObject<SoundEvent> TIMERESUMES = REGISTRY.register("timeresumes", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "timeresumes")));
	public static final RegistryObject<SoundEvent> KNIFE_HIT = REGISTRY.register("knife_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "knife_hit")));
	public static final RegistryObject<SoundEvent> THROW_KNIFE = REGISTRY.register("throw_knife", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "throw_knife")));
}
