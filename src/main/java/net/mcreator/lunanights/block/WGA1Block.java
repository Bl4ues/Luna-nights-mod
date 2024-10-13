
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

public class WGA1Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGA1Block() {
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
			default -> Shapes.or(box(18, 0, 2, 30, 31, 14), box(18.75, 31, 2.75, 29.25, 32, 13.25), box(2.98528, 13, -11.25, 6.98528, 19, 15), box(2.96016, 13, -2.17157, 6.96016, 19, 27.00736), box(2.5, 0, 18.5, 9.5, 32, 25.5),
					box(0.5, 0, 16.5, 11.5, 5, 27.5), box(2.5, 0, -9.5, 9.5, 32, -2.5), box(0.5, 0, -11.5, 11.5, 5, -0.5));
			case NORTH -> Shapes.or(box(-14, 0, 2, -2, 31, 14), box(-13.25, 31, 2.75, -2.75, 32, 13.25), box(9.01472, 13, 1, 13.01472, 19, 27.25), box(9.03984, 13, -11.00736, 13.03984, 19, 18.17157), box(6.5, 0, -9.5, 13.5, 32, -2.5),
					box(4.5, 0, -11.5, 15.5, 5, -0.5), box(6.5, 0, 18.5, 13.5, 32, 25.5), box(4.5, 0, 16.5, 15.5, 5, 27.5));
			case EAST -> Shapes.or(box(2, 0, -14, 14, 31, -2), box(2.75, 31, -13.25, 13.25, 32, -2.75), box(-11.25, 13, 9.01472, 15, 19, 13.01472), box(-2.17157, 13, 9.03984, 27.00736, 19, 13.03984), box(18.5, 0, 6.5, 25.5, 32, 13.5),
					box(16.5, 0, 4.5, 27.5, 5, 15.5), box(-9.5, 0, 6.5, -2.5, 32, 13.5), box(-11.5, 0, 4.5, -0.5, 5, 15.5));
			case WEST -> Shapes.or(box(2, 0, 18, 14, 31, 30), box(2.75, 31, 18.75, 13.25, 32, 29.25), box(1, 13, 2.98528, 27.25, 19, 6.98528), box(-11.00736, 13, 2.96016, 18.17157, 19, 6.96016), box(-9.5, 0, 2.5, -2.5, 32, 9.5),
					box(-11.5, 0, 0.5, -0.5, 5, 11.5), box(18.5, 0, 2.5, 25.5, 32, 9.5), box(16.5, 0, 0.5, 27.5, 5, 11.5));
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
