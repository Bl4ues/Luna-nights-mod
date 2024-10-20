
package net.mcreator.lunanights.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.HitResult;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.procedures.D2Procedure;
import net.mcreator.lunanights.init.LunaNightsModBlocks;

import java.util.List;

public class WGD2Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGD2Block() {
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
			default -> Shapes.or(box(-16, 0, 5.75, 32, 2, 10.25), box(-16, 1.8, 6, 32, 7.8, 10), box(11.35, -15.35, 9.6, 12.65, 1.35, 11.2), box(3.35, -15.35, 9.6, 4.65, 1.35, 11.2), box(4, -15.3, 9.6, 12, -14, 11.1),
					box(3, -15.3, 9.3, 6, -14, 11.5), box(10, -15.3, 9.3, 13, -14, 11.5), box(10, -1, 9.3, 13, 0.3, 11.5), box(3, -1, 9.3, 6, 0.3, 11.5), box(4, 0, 9.6, 12, 1.3, 11.1), box(4, -15, 5.4, 12, 0.5, 10.9),
					box(11.35, -15.35, 4.8, 12.65, 1.35, 6.4), box(3.35, -15.35, 4.8, 4.65, 1.35, 6.4), box(4, -15.3, 4.9, 12, -14, 6.4), box(3, -15.3, 4.5, 6, -14, 6.7), box(10, -15.3, 4.5, 13, -14, 6.7), box(10, -1, 4.5, 13, 0.3, 6.7),
					box(3, -1, 4.5, 6, 0.3, 6.7), box(4, 0, 4.9, 12, 1.3, 6.4), box(4, -15, 5.1, 12, 0.5, 6.6), box(-16, 7, 5, 8, 10, 11), box(-16, 9.15019, 7, 8.06003, 11.15019, 14), box(-16, 9.15019, 8, -10.93997, 11.15019, 14),
					box(-16, 7, 5, 8, 10, 11), box(-16, 9.15019, 2, 8.06003, 11.15019, 9), box(-16, 9.15019, 2, -10.93997, 11.15019, 8), box(8, 7, 5, 32, 10, 11), box(7.93997, 9.15019, 7, 32, 11.15019, 14),
					box(26.93997, 9.15019, 8, 32, 11.15019, 14), box(8, 7, 5, 32, 10, 11), box(7.93997, 9.15019, 2, 32, 11.15019, 9), box(26.93997, 9.15019, 2, 32, 11.15019, 8));
			case NORTH -> Shapes.or(box(-16, 0, 5.75, 32, 2, 10.25), box(-16, 1.8, 6, 32, 7.8, 10), box(3.35, -15.35, 4.8, 4.65, 1.35, 6.4), box(11.35, -15.35, 4.8, 12.65, 1.35, 6.4), box(4, -15.3, 4.9, 12, -14, 6.4),
					box(10, -15.3, 4.5, 13, -14, 6.7), box(3, -15.3, 4.5, 6, -14, 6.7), box(3, -1, 4.5, 6, 0.3, 6.7), box(10, -1, 4.5, 13, 0.3, 6.7), box(4, 0, 4.9, 12, 1.3, 6.4), box(4, -15, 5.1, 12, 0.5, 10.6),
					box(3.35, -15.35, 9.6, 4.65, 1.35, 11.2), box(11.35, -15.35, 9.6, 12.65, 1.35, 11.2), box(4, -15.3, 9.6, 12, -14, 11.1), box(10, -15.3, 9.3, 13, -14, 11.5), box(3, -15.3, 9.3, 6, -14, 11.5), box(3, -1, 9.3, 6, 0.3, 11.5),
					box(10, -1, 9.3, 13, 0.3, 11.5), box(4, 0, 9.6, 12, 1.3, 11.1), box(4, -15, 9.4, 12, 0.5, 10.9), box(8, 7, 5, 32, 10, 11), box(7.93997, 9.15019, 2, 32, 11.15019, 9), box(26.93997, 9.15019, 2, 32, 11.15019, 8),
					box(8, 7, 5, 32, 10, 11), box(7.93997, 9.15019, 7, 32, 11.15019, 14), box(26.93997, 9.15019, 8, 32, 11.15019, 14), box(-16, 7, 5, 8, 10, 11), box(-16, 9.15019, 2, 8.06003, 11.15019, 9),
					box(-16, 9.15019, 2, -10.93997, 11.15019, 8), box(-16, 7, 5, 8, 10, 11), box(-16, 9.15019, 7, 8.06003, 11.15019, 14), box(-16, 9.15019, 8, -10.93997, 11.15019, 14));
			case EAST -> Shapes.or(box(5.75, 0, -16, 10.25, 2, 32), box(6, 1.8, -16, 10, 7.8, 32), box(9.6, -15.35, 3.35, 11.2, 1.35, 4.65), box(9.6, -15.35, 11.35, 11.2, 1.35, 12.65), box(9.6, -15.3, 4, 11.1, -14, 12),
					box(9.3, -15.3, 10, 11.5, -14, 13), box(9.3, -15.3, 3, 11.5, -14, 6), box(9.3, -1, 3, 11.5, 0.3, 6), box(9.3, -1, 10, 11.5, 0.3, 13), box(9.6, 0, 4, 11.1, 1.3, 12), box(5.4, -15, 4, 10.9, 0.5, 12),
					box(4.8, -15.35, 3.35, 6.4, 1.35, 4.65), box(4.8, -15.35, 11.35, 6.4, 1.35, 12.65), box(4.9, -15.3, 4, 6.4, -14, 12), box(4.5, -15.3, 10, 6.7, -14, 13), box(4.5, -15.3, 3, 6.7, -14, 6), box(4.5, -1, 3, 6.7, 0.3, 6),
					box(4.5, -1, 10, 6.7, 0.3, 13), box(4.9, 0, 4, 6.4, 1.3, 12), box(5.1, -15, 4, 6.6, 0.5, 12), box(5, 7, 8, 11, 10, 32), box(7, 9.15019, 7.93997, 14, 11.15019, 32), box(8, 9.15019, 26.93997, 14, 11.15019, 32),
					box(5, 7, 8, 11, 10, 32), box(2, 9.15019, 7.93997, 9, 11.15019, 32), box(2, 9.15019, 26.93997, 8, 11.15019, 32), box(5, 7, -16, 11, 10, 8), box(7, 9.15019, -16, 14, 11.15019, 8.06003),
					box(8, 9.15019, -16, 14, 11.15019, -10.93997), box(5, 7, -16, 11, 10, 8), box(2, 9.15019, -16, 9, 11.15019, 8.06003), box(2, 9.15019, -16, 8, 11.15019, -10.93997));
			case WEST -> Shapes.or(box(5.75, 0, -16, 10.25, 2, 32), box(6, 1.8, -16, 10, 7.8, 32), box(4.8, -15.35, 11.35, 6.4, 1.35, 12.65), box(4.8, -15.35, 3.35, 6.4, 1.35, 4.65), box(4.9, -15.3, 4, 6.4, -14, 12), box(4.5, -15.3, 3, 6.7, -14, 6),
					box(4.5, -15.3, 10, 6.7, -14, 13), box(4.5, -1, 10, 6.7, 0.3, 13), box(4.5, -1, 3, 6.7, 0.3, 6), box(4.9, 0, 4, 6.4, 1.3, 12), box(5.1, -15, 4, 10.6, 0.5, 12), box(9.6, -15.35, 11.35, 11.2, 1.35, 12.65),
					box(9.6, -15.35, 3.35, 11.2, 1.35, 4.65), box(9.6, -15.3, 4, 11.1, -14, 12), box(9.3, -15.3, 3, 11.5, -14, 6), box(9.3, -15.3, 10, 11.5, -14, 13), box(9.3, -1, 10, 11.5, 0.3, 13), box(9.3, -1, 3, 11.5, 0.3, 6),
					box(9.6, 0, 4, 11.1, 1.3, 12), box(9.4, -15, 4, 10.9, 0.5, 12), box(5, 7, -16, 11, 10, 8), box(2, 9.15019, -16, 9, 11.15019, 8.06003), box(2, 9.15019, -16, 8, 11.15019, -10.93997), box(5, 7, -16, 11, 10, 8),
					box(7, 9.15019, -16, 14, 11.15019, 8.06003), box(8, 9.15019, -16, 14, 11.15019, -10.93997), box(5, 7, 8, 11, 10, 32), box(2, 9.15019, 7.93997, 9, 11.15019, 32), box(2, 9.15019, 26.93997, 8, 11.15019, 32), box(5, 7, 8, 11, 10, 32),
					box(7, 9.15019, 7.93997, 14, 11.15019, 32), box(8, 9.15019, 26.93997, 14, 11.15019, 32));
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
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(LunaNightsModBlocks.WGA_2.get());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 3);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		D2Procedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 3);
	}
}
