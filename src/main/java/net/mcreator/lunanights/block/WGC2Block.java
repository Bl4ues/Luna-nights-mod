
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.procedures.C2Procedure;

import java.util.List;

public class WGC2Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGC2Block() {
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
			default -> Shapes.or(box(-16, 12, 5.75, 32, 14, 10.25), box(-16, 0, 6, 32, 12, 10), box(21.8, 16.8, 6.9, 32, 18.8, 9.1), box(23.7, 13.8, 7.1, 31.9, 15.8, 8.9), box(24, 11.8, 7, 26, 17.8, 9), box(-16, 16.8, 6.9, -5.8, 18.8, 9.1),
					box(-15.9, 13.8, 7.1, -7.7, 15.8, 8.9), box(-10, 11.8, 7, -8, 17.8, 9));
			case NORTH -> Shapes.or(box(-16, 12, 5.75, 32, 14, 10.25), box(-16, 0, 6, 32, 12, 10), box(-16, 16.8, 6.9, -5.8, 18.8, 9.1), box(-15.9, 13.8, 7.1, -7.7, 15.8, 8.9), box(-10, 11.8, 7, -8, 17.8, 9), box(21.8, 16.8, 6.9, 32, 18.8, 9.1),
					box(23.7, 13.8, 7.1, 31.9, 15.8, 8.9), box(24, 11.8, 7, 26, 17.8, 9));
			case EAST -> Shapes.or(box(5.75, 12, -16, 10.25, 14, 32), box(6, 0, -16, 10, 12, 32), box(6.9, 16.8, -16, 9.1, 18.8, -5.8), box(7.1, 13.8, -15.9, 8.9, 15.8, -7.7), box(7, 11.8, -10, 9, 17.8, -8), box(6.9, 16.8, 21.8, 9.1, 18.8, 32),
					box(7.1, 13.8, 23.7, 8.9, 15.8, 31.9), box(7, 11.8, 24, 9, 17.8, 26));
			case WEST -> Shapes.or(box(5.75, 12, -16, 10.25, 14, 32), box(6, 0, -16, 10, 12, 32), box(6.9, 16.8, 21.8, 9.1, 18.8, 32), box(7.1, 13.8, 23.7, 8.9, 15.8, 31.9), box(7, 11.8, 24, 9, 17.8, 26), box(6.9, 16.8, -16, 9.1, 18.8, -5.8),
					box(7.1, 13.8, -15.9, 8.9, 15.8, -7.7), box(7, 11.8, -10, 9, 17.8, -8));
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

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 10);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		C2Procedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 10);
	}
}
