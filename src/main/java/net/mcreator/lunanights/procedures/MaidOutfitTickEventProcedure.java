package net.mcreator.lunanights.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;

public class MaidOutfitTickEventProcedure {
	public static void execute(ItemStack itemstack) {
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(-100, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
	}
}
