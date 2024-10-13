
package net.mcreator.lunanights.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

public class WGB3Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGB3Block() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(10f).noOcclusion().pushReaction(PushReaction.BLOCK).isRedstoneConductor((bs, br, bp) -> false).noLootTable());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(-14, 0, 2, -2, 32, 14), box(9.01472, 13, -11.25, 13.01472, 19, 15), box(9.03984, 13, -2.17157, 13.03984, 19, 27.00736), box(5, 23, -11, 15, 24.5, -1), box(6, 0, -9.5, 14, 23, -2.5),
					box(9.03158, 25.52405, -11.76418, 16.53158, 27.02405, -0.26418), box(3.4883, 25.57205, -11.76418, 10.9883, 27.07205, -0.26418), box(4.25, 23.8, -12.65, 15.75, 25.3, -5.15), box(4.25, 25, -6.65, 15.75, 26.5, 0.85),
					box(9.03158, 25.52405, 16.23582, 16.53158, 27.02405, 27.73582), box(3.4883, 25.57205, 16.23582, 10.9883, 27.07205, 27.73582), box(4.25, 23.8, 15.35, 15.75, 25.3, 22.85), box(4.25, 25, 21.35, 15.75, 26.5, 28.85),
					box(6.5, 0, 18.5, 13.5, 23, 25.5), box(4.5, 23, 17, 15.5, 24.5, 27));
			case NORTH -> Shapes.or(box(18, 0, 2, 30, 32, 14), box(2.98528, 13, 1, 6.98528, 19, 27.25), box(2.96016, 13, -11.00736, 6.96016, 19, 18.17157), box(1, 23, 17, 11, 24.5, 27), box(2, 0, 18.5, 10, 23, 25.5),
					box(-0.53158, 25.52405, 16.26418, 6.96842, 27.02405, 27.76418), box(5.0117, 25.57205, 16.26418, 12.5117, 27.07205, 27.76418), box(0.25, 23.8, 21.15, 11.75, 25.3, 28.65), box(0.25, 25, 15.15, 11.75, 26.5, 22.65),
					box(-0.53158, 25.52405, -11.73582, 6.96842, 27.02405, -0.23582), box(5.0117, 25.57205, -11.73582, 12.5117, 27.07205, -0.23582), box(0.25, 23.8, -6.85, 11.75, 25.3, 0.65), box(0.25, 25, -12.85, 11.75, 26.5, -5.35),
					box(2.5, 0, -9.5, 9.5, 23, -2.5), box(0.5, 23, -11, 11.5, 24.5, -1));
			case EAST -> Shapes.or(box(2, 0, 18, 14, 32, 30), box(-11.25, 13, 2.98528, 15, 19, 6.98528), box(-2.17157, 13, 2.96016, 27.00736, 19, 6.96016), box(-11, 23, 1, -1, 24.5, 11), box(-9.5, 0, 2, -2.5, 23, 10),
					box(-11.76418, 25.52405, -0.53158, -0.26418, 27.02405, 6.96842), box(-11.76418, 25.57205, 5.0117, -0.26418, 27.07205, 12.5117), box(-12.65, 23.8, 0.25, -5.15, 25.3, 11.75), box(-6.65, 25, 0.25, 0.85, 26.5, 11.75),
					box(16.23582, 25.52405, -0.53158, 27.73582, 27.02405, 6.96842), box(16.23582, 25.57205, 5.0117, 27.73582, 27.07205, 12.5117), box(15.35, 23.8, 0.25, 22.85, 25.3, 11.75), box(21.35, 25, 0.25, 28.85, 26.5, 11.75),
					box(18.5, 0, 2.5, 25.5, 23, 9.5), box(17, 23, 0.5, 27, 24.5, 11.5));
			case WEST -> Shapes.or(box(2, 0, -14, 14, 32, -2), box(1, 13, 9.01472, 27.25, 19, 13.01472), box(-11.00736, 13, 9.03984, 18.17157, 19, 13.03984), box(17, 23, 5, 27, 24.5, 15), box(18.5, 0, 6, 25.5, 23, 14),
					box(16.26418, 25.52405, 9.03158, 27.76418, 27.02405, 16.53158), box(16.26418, 25.57205, 3.4883, 27.76418, 27.07205, 10.9883), box(21.15, 23.8, 4.25, 28.65, 25.3, 15.75), box(15.15, 25, 4.25, 22.65, 26.5, 15.75),
					box(-11.73582, 25.52405, 9.03158, -0.23582, 27.02405, 16.53158), box(-11.73582, 25.57205, 3.4883, -0.23582, 27.07205, 10.9883), box(-6.85, 23.8, 4.25, 0.65, 25.3, 15.75), box(-12.85, 25, 4.25, -5.35, 26.5, 15.75),
					box(-9.5, 0, 6.5, -2.5, 23, 13.5), box(-11, 23, 4.5, -1, 24.5, 15.5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
