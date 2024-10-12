
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
}
