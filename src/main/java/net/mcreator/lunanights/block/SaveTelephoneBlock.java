
package net.mcreator.lunanights.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.lunanights.procedures.SavingClickProcedure;
import net.mcreator.lunanights.procedures.SaveTelephoneMarkProcedure;

import java.util.List;
import java.util.Collections;

public class SaveTelephoneBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public SaveTelephoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL).strength(3f, 10f).requiresCorrectToolForDrops().noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("A lifeline to save your progress"));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
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
			default -> Shapes.or(box(7.2, 0.025, 3.2, 8.8, 15.225, 4.8), box(6, 6.925, 2.9, 10, 11.225, 7), box(6.1, 15.525, 1.2, 11.3, 22.125, 6.8), box(4.9, 16.725, 2.4, 6.3, 20.925, 4.9), box(3.5, 15.225, 0.5, 12.5, 15.425, 7.2),
					box(3.5, 15.425, 0.5, 12.5, 26.225, 1), box(3.5, 25.725, 0.5, 12.5, 26.225, 7.2), box(12.2, 15.225, 0.9, 12.5, 25.825, 7.2), box(3.5, 15.425, 0.9, 3.8, 25.825, 7.2), box(7, 14.025, 3, 9, 15.225, 5));
			case NORTH -> Shapes.or(box(7.2, 0.025, 11.2, 8.8, 15.225, 12.8), box(6, 6.925, 9, 10, 11.225, 13.1), box(4.7, 15.525, 9.2, 9.9, 22.125, 14.8), box(9.7, 16.725, 11.1, 11.1, 20.925, 13.6), box(3.5, 15.225, 8.8, 12.5, 15.425, 15.5),
					box(3.5, 15.425, 15, 12.5, 26.225, 15.5), box(3.5, 25.725, 8.8, 12.5, 26.225, 15.5), box(3.5, 15.225, 8.8, 3.8, 25.825, 15.1), box(12.2, 15.425, 8.8, 12.5, 25.825, 15.1), box(7, 14.025, 11, 9, 15.225, 13));
			case EAST -> Shapes.or(box(3.2, 0.025, 7.2, 4.8, 15.225, 8.8), box(2.9, 6.925, 6, 7, 11.225, 10), box(1.2, 15.525, 4.7, 6.8, 22.125, 9.9), box(2.4, 16.725, 9.7, 4.9, 20.925, 11.1), box(0.5, 15.225, 3.5, 7.2, 15.425, 12.5),
					box(0.5, 15.425, 3.5, 1, 26.225, 12.5), box(0.5, 25.725, 3.5, 7.2, 26.225, 12.5), box(0.9, 15.225, 3.5, 7.2, 25.825, 3.8), box(0.9, 15.425, 12.2, 7.2, 25.825, 12.5), box(3, 14.025, 7, 5, 15.225, 9));
			case WEST -> Shapes.or(box(11.2, 0.025, 7.2, 12.8, 15.225, 8.8), box(9, 6.925, 6, 13.1, 11.225, 10), box(9.2, 15.525, 6.1, 14.8, 22.125, 11.3), box(11.1, 16.725, 4.9, 13.6, 20.925, 6.3), box(8.8, 15.225, 3.5, 15.5, 15.425, 12.5),
					box(15, 15.425, 3.5, 15.5, 26.225, 12.5), box(8.8, 25.725, 3.5, 15.5, 26.225, 12.5), box(8.8, 15.225, 12.2, 15.1, 25.825, 12.5), box(8.8, 15.425, 3.5, 15.1, 25.825, 3.8), box(11, 14.025, 7, 13, 15.225, 9));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.BLOCKED;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 2;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 6);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		SaveTelephoneMarkProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 6);
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		SavingClickProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}
