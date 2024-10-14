package net.mcreator.lunanights.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.world.inventory.WarpMenuMenu;
import net.mcreator.lunanights.world.inventory.WarpChoiceMenu;
import net.mcreator.lunanights.network.LunaNightsModVariables;
import net.mcreator.lunanights.init.LunaNightsModItems;

import io.netty.buffer.Unpooled;

public class WGA2OnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LunaNightsModItems.LINK_REMOVER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == LunaNightsModItems.LINK_REMOVER.get()) {
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp1Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp1Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp1 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp2Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp2Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp2 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp3Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp3Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp3 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp4Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp4Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp4 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp5Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp5Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp5 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp6Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp6Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp6 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).equals(LunaNightsModVariables.MapVariables.get(world).Warp7Name)) {
				LunaNightsModVariables.MapVariables.get(world).Warp7Name = "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp7 = false;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("WarpName", "");
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			if ((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "WarpName")).isEmpty()) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("WarpMenu");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WarpMenuMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("WarpChoice");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WarpChoiceMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
