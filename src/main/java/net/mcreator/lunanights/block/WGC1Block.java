
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

public class WGC1Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGC1Block() {
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
			default ->
				Shapes.or(box(18, 0, 2, 30, 32, 14), box(16, 30, -1, 32, 32, 17), box(-2.75, 12, 5.65, 1.5, 14, 10.35), box(-0.25, 12, 5.75, 19, 14, 10.25), box(0, 0, 6, 19, 12, 10), box(11, 11.8, 7, 13, 17.8, 9), box(8.8, 16.8, 6.9, 19, 18.8, 9.1));
			case NORTH -> Shapes.or(box(-14, 0, 2, -2, 32, 14), box(-16, 30, -1, 0, 32, 17), box(14.5, 12, 5.65, 18.75, 14, 10.35), box(-3, 12, 5.75, 16.25, 14, 10.25), box(-3, 0, 6, 16, 12, 10), box(3, 11.8, 7, 5, 17.8, 9),
					box(-3, 16.8, 6.9, 7.2, 18.8, 9.1));
			case EAST -> Shapes.or(box(2, 0, -14, 14, 32, -2), box(-1, 30, -16, 17, 32, 0), box(5.65, 12, 14.5, 10.35, 14, 18.75), box(5.75, 12, -3, 10.25, 14, 16.25), box(6, 0, -3, 10, 12, 16), box(7, 11.8, 3, 9, 17.8, 5),
					box(6.9, 16.8, -3, 9.1, 18.8, 7.2));
			case WEST ->
				Shapes.or(box(2, 0, 18, 14, 32, 30), box(-1, 30, 16, 17, 32, 32), box(5.65, 12, -2.75, 10.35, 14, 1.5), box(5.75, 12, -0.25, 10.25, 14, 19), box(6, 0, 0, 10, 12, 19), box(7, 11.8, 11, 9, 17.8, 13), box(6.9, 16.8, 8.8, 9.1, 18.8, 19));
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
