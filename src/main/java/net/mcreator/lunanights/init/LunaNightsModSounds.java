
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
	public static final RegistryObject<SoundEvent> LVLUPSOUND = REGISTRY.register("lvlupsound", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "lvlupsound")));
	public static final RegistryObject<SoundEvent> MPMAX = REGISTRY.register("mpmax", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "mpmax")));
	public static final RegistryObject<SoundEvent> TGMAX = REGISTRY.register("tgmax", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "tgmax")));
	public static final RegistryObject<SoundEvent> GEMDROP = REGISTRY.register("gemdrop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "gemdrop")));
	public static final RegistryObject<SoundEvent> DESTROY = REGISTRY.register("destroy", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "destroy")));
	public static final RegistryObject<SoundEvent> DESTROY_ECHO = REGISTRY.register("destroy_echo", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("luna_nights", "destroy_echo")));
}
