
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

import net.mcreator.lunanights.procedures.D3Procedure;
import net.mcreator.lunanights.init.LunaNightsModBlocks;

import java.util.List;

public class WGD3Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WGD3Block() {
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
			default -> Shapes.or(box(1, 0, 5.75, 20, 2, 10.25), box(-16, 12.15019, 2, 1.06003, 14.15019, 9), box(-16, 12.15019, 7, 1.06003, 14.15019, 14), box(-16, 7, 5, 1, 12, 11), box(-16, 1.8, 6, 1, 7.8, 10), box(-16, 0, 5.75, 1, 2, 10.25),
					box(1, 1.8, 6, 22, 7.8, 10), box(21.93997, 9.15019, 8, 29, 14.15019, 13), box(21.93997, 9.15019, 3, 29, 14.15019, 8), box(24.93217, 12.69764, 5.6, 31.99219, 15.69764, 10.6), box(1, 7, 5, 24, 12, 11),
					box(1, 12.15019, 7, 24.06003, 14.15019, 14), box(1, 7, 5, 23, 10, 11), box(1, 12.15019, 2, 24.06003, 14.15019, 9));
			case NORTH -> Shapes.or(box(-4, 0, 5.75, 15, 2, 10.25), box(14.93997, 12.15019, 7, 32, 14.15019, 14), box(14.93997, 12.15019, 2, 32, 14.15019, 9), box(15, 7, 5, 32, 12, 11), box(15, 1.8, 6, 32, 7.8, 10), box(15, 0, 5.75, 32, 2, 10.25),
					box(-6, 1.8, 6, 15, 7.8, 10), box(-13, 9.15019, 3, -5.93997, 14.15019, 8), box(-13, 9.15019, 8, -5.93997, 14.15019, 13), box(-15.99219, 12.69764, 5.4, -8.93217, 15.69764, 10.4), box(-8, 7, 5, 15, 12, 11),
					box(-8.06003, 12.15019, 2, 15, 14.15019, 9), box(-7, 7, 5, 15, 10, 11), box(-8.06003, 12.15019, 7, 15, 14.15019, 14));
			case EAST -> Shapes.or(box(5.75, 0, -4, 10.25, 2, 15), box(2, 12.15019, 14.93997, 9, 14.15019, 32), box(7, 12.15019, 14.93997, 14, 14.15019, 32), box(5, 7, 15, 11, 12, 32), box(6, 1.8, 15, 10, 7.8, 32), box(5.75, 0, 15, 10.25, 2, 32),
					box(6, 1.8, -6, 10, 7.8, 15), box(8, 9.15019, -13, 13, 14.15019, -5.93997), box(3, 9.15019, -13, 8, 14.15019, -5.93997), box(5.6, 12.69764, -15.99219, 10.6, 15.69764, -8.93217), box(5, 7, -8, 11, 12, 15),
					box(7, 12.15019, -8.06003, 14, 14.15019, 15), box(5, 7, -7, 11, 10, 15), box(2, 12.15019, -8.06003, 9, 14.15019, 15));
			case WEST -> Shapes.or(box(5.75, 0, 1, 10.25, 2, 20), box(7, 12.15019, -16, 14, 14.15019, 1.06003), box(2, 12.15019, -16, 9, 14.15019, 1.06003), box(5, 7, -16, 11, 12, 1), box(6, 1.8, -16, 10, 7.8, 1), box(5.75, 0, -16, 10.25, 2, 1),
					box(6, 1.8, 1, 10, 7.8, 22), box(3, 9.15019, 21.93997, 8, 14.15019, 29), box(8, 9.15019, 21.93997, 13, 14.15019, 29), box(5.4, 12.69764, 24.93217, 10.4, 15.69764, 31.99219), box(5, 7, 1, 11, 12, 24),
					box(2, 12.15019, 1, 9, 14.15019, 24.06003), box(5, 7, 1, 11, 10, 23), box(7, 12.15019, 1, 14, 14.15019, 24.06003));
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
		world.scheduleTick(pos, this, 10);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		D3Procedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 10);
	}
}
