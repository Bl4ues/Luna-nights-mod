
package net.mcreator.lunanights.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.lunanights.procedures.TimeCardConsumeProcedure;

import java.util.List;

public class TimeTicketItem extends Item {
	public TimeTicketItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 1;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Increases the Time Gauge when consumed"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		TimeCardConsumeProcedure.execute(entity);
		return retval;
	}
}