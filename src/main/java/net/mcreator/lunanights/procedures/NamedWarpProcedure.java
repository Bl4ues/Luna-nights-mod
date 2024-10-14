package net.mcreator.lunanights.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.lunanights.network.LunaNightsModVariables;

import java.util.HashMap;

public class NamedWarpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "").isEmpty() == false) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString("WarpName", (guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : ""));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((LunaNightsModVariables.MapVariables.get(world).Warp1Name).isEmpty()) {
				LunaNightsModVariables.MapVariables.get(world).Warp1Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp1_X = x;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp1_Y = y;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
				LunaNightsModVariables.MapVariables.get(world).Warp1_Z = z;
				LunaNightsModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((LunaNightsModVariables.MapVariables.get(world).Warp2Name).isEmpty()) {
					LunaNightsModVariables.MapVariables.get(world).Warp2Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
					LunaNightsModVariables.MapVariables.get(world).syncData(world);
					LunaNightsModVariables.MapVariables.get(world).Warp2_X = x;
					LunaNightsModVariables.MapVariables.get(world).syncData(world);
					LunaNightsModVariables.MapVariables.get(world).Warp2_Y = y;
					LunaNightsModVariables.MapVariables.get(world).syncData(world);
					LunaNightsModVariables.MapVariables.get(world).Warp2_Z = z;
					LunaNightsModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((LunaNightsModVariables.MapVariables.get(world).Warp3Name).isEmpty()) {
						LunaNightsModVariables.MapVariables.get(world).Warp3Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
						LunaNightsModVariables.MapVariables.get(world).syncData(world);
						LunaNightsModVariables.MapVariables.get(world).Warp3_X = x;
						LunaNightsModVariables.MapVariables.get(world).syncData(world);
						LunaNightsModVariables.MapVariables.get(world).Warp3_Y = y;
						LunaNightsModVariables.MapVariables.get(world).syncData(world);
						LunaNightsModVariables.MapVariables.get(world).Warp3_Z = z;
						LunaNightsModVariables.MapVariables.get(world).syncData(world);
					} else {
						if ((LunaNightsModVariables.MapVariables.get(world).Warp4Name).isEmpty()) {
							LunaNightsModVariables.MapVariables.get(world).Warp4Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
							LunaNightsModVariables.MapVariables.get(world).syncData(world);
							LunaNightsModVariables.MapVariables.get(world).Warp4_X = x;
							LunaNightsModVariables.MapVariables.get(world).syncData(world);
							LunaNightsModVariables.MapVariables.get(world).Warp4_Y = y;
							LunaNightsModVariables.MapVariables.get(world).syncData(world);
							LunaNightsModVariables.MapVariables.get(world).Warp4_Z = z;
							LunaNightsModVariables.MapVariables.get(world).syncData(world);
						} else {
							if ((LunaNightsModVariables.MapVariables.get(world).Warp5Name).isEmpty()) {
								LunaNightsModVariables.MapVariables.get(world).Warp5Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
								LunaNightsModVariables.MapVariables.get(world).syncData(world);
								LunaNightsModVariables.MapVariables.get(world).Warp5_X = x;
								LunaNightsModVariables.MapVariables.get(world).syncData(world);
								LunaNightsModVariables.MapVariables.get(world).Warp5_Y = y;
								LunaNightsModVariables.MapVariables.get(world).syncData(world);
								LunaNightsModVariables.MapVariables.get(world).Warp5_Z = z;
								LunaNightsModVariables.MapVariables.get(world).syncData(world);
							} else {
								if ((LunaNightsModVariables.MapVariables.get(world).Warp6Name).isEmpty()) {
									LunaNightsModVariables.MapVariables.get(world).Warp6Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
									LunaNightsModVariables.MapVariables.get(world).syncData(world);
									LunaNightsModVariables.MapVariables.get(world).Warp6_X = x;
									LunaNightsModVariables.MapVariables.get(world).syncData(world);
									LunaNightsModVariables.MapVariables.get(world).Warp6_Y = y;
									LunaNightsModVariables.MapVariables.get(world).syncData(world);
									LunaNightsModVariables.MapVariables.get(world).Warp6_Z = z;
									LunaNightsModVariables.MapVariables.get(world).syncData(world);
								} else {
									if ((LunaNightsModVariables.MapVariables.get(world).Warp7Name).isEmpty()) {
										LunaNightsModVariables.MapVariables.get(world).Warp7Name = guistate.containsKey("text:WarpGateName") ? ((EditBox) guistate.get("text:WarpGateName")).getValue() : "";
										LunaNightsModVariables.MapVariables.get(world).syncData(world);
										LunaNightsModVariables.MapVariables.get(world).Warp7_X = x;
										LunaNightsModVariables.MapVariables.get(world).syncData(world);
										LunaNightsModVariables.MapVariables.get(world).Warp7_Y = y;
										LunaNightsModVariables.MapVariables.get(world).syncData(world);
										LunaNightsModVariables.MapVariables.get(world).Warp7_Z = z;
										LunaNightsModVariables.MapVariables.get(world).syncData(world);
									}
								}
							}
						}
					}
				}
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
