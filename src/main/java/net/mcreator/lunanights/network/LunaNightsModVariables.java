package net.mcreator.lunanights.network;

import org.checkerframework.checker.units.qual.Time;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.lunanights.LunaNightsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LunaNightsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LunaNightsMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		LunaNightsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.WarpOverlay_1 = original.WarpOverlay_1;
			clone.WarpOverlay_2 = original.WarpOverlay_2;
			clone.WarpOverlay_3 = original.WarpOverlay_3;
			clone.WarpOverlay_4 = original.WarpOverlay_4;
			clone.WarpOverlay_5 = original.WarpOverlay_5;
			clone.WarpOverlay_6 = original.WarpOverlay_6;
			clone.ManaStart = original.ManaStart;
			clone.MaxMana = original.MaxMana;
			clone.ManaMultiplier = original.ManaMultiplier;
			clone.Mana = original.Mana;
			clone.TimeStart = original.TimeStart;
			clone.MaxTime = original.MaxTime;
			clone.TimeMultiplier = original.TimeMultiplier;
			clone.Time = original.Time;
			clone.AquamarineCount = original.AquamarineCount;
			clone.TopazCount = original.TopazCount;
			clone.RubyCount = original.RubyCount;
			clone.SapphireCount = original.SapphireCount;
			clone.EmeraldCount = original.EmeraldCount;
			clone.LvLtrack = original.LvLtrack;
			clone.MPtrack = original.MPtrack;
			clone.TGtrack = original.TGtrack;
			clone.LvlUpOverlay = original.LvlUpOverlay;
			clone.MPInc1 = original.MPInc1;
			clone.MPInc2 = original.MPInc2;
			clone.MPInc3 = original.MPInc3;
			clone.MPInc4 = original.MPInc4;
			clone.MPInc5 = original.MPInc5;
			clone.TGInc1 = original.TGInc1;
			clone.TGInc2 = original.TGInc2;
			clone.TGInc3 = original.TGInc3;
			clone.TGInc4 = original.TGInc4;
			clone.TGInc5 = original.TGInc5;
			clone.TGInc6 = original.TGInc6;
			clone.ManaBar_0 = original.ManaBar_0;
			clone.ManaBar_1 = original.ManaBar_1;
			clone.ManaBar_2 = original.ManaBar_2;
			clone.ManaBar_3 = original.ManaBar_3;
			clone.ManaBar_4 = original.ManaBar_4;
			clone.ManaBar_5 = original.ManaBar_5;
			clone.ManaBar_6 = original.ManaBar_6;
			clone.ManaBar_7 = original.ManaBar_7;
			clone.ManaBar_8 = original.ManaBar_8;
			clone.ManaBar_9 = original.ManaBar_9;
			clone.ManaBar_10 = original.ManaBar_10;
			clone.ManaBar_11 = original.ManaBar_11;
			clone.ManaBar_12 = original.ManaBar_12;
			clone.ManaBar_13 = original.ManaBar_13;
			clone.ManaBar_14 = original.ManaBar_14;
			clone.ManaBar_15 = original.ManaBar_15;
			clone.ManaBar_16 = original.ManaBar_16;
			clone.ManaBar_17 = original.ManaBar_17;
			clone.ManaBar_18 = original.ManaBar_18;
			clone.ManaBar_19 = original.ManaBar_19;
			clone.ManaBar_20 = original.ManaBar_20;
			clone.ManaBar_21 = original.ManaBar_21;
			clone.ManaBar_22 = original.ManaBar_22;
			clone.ManaBar_23 = original.ManaBar_23;
			clone.ManaBar_24 = original.ManaBar_24;
			clone.ManaBar_25 = original.ManaBar_25;
			clone.ManaBar_26 = original.ManaBar_26;
			clone.ManaBar_27 = original.ManaBar_27;
			clone.ManaBar_28 = original.ManaBar_28;
			clone.ManaBar_29 = original.ManaBar_29;
			clone.ManaBar_30 = original.ManaBar_30;
			clone.TimeBar_0 = original.TimeBar_0;
			clone.TimeBar_1 = original.TimeBar_1;
			clone.TimeBar_2 = original.TimeBar_2;
			clone.TimeBar_3 = original.TimeBar_3;
			clone.TimeBar_4 = original.TimeBar_4;
			clone.TimeBar_5 = original.TimeBar_5;
			clone.TimeBar_6 = original.TimeBar_6;
			clone.TimeBar_7 = original.TimeBar_7;
			clone.TimeBar_8 = original.TimeBar_8;
			clone.TimeBar_9 = original.TimeBar_9;
			clone.TimeBar_10 = original.TimeBar_10;
			clone.TimeBar_11 = original.TimeBar_11;
			clone.TimeBar_12 = original.TimeBar_12;
			clone.TimeBar_13 = original.TimeBar_13;
			clone.TimeBar_14 = original.TimeBar_14;
			clone.TimeBar_15 = original.TimeBar_15;
			clone.TimeBar_16 = original.TimeBar_16;
			if (!event.isWasDeath()) {
				clone.WalkOnWater = original.WalkOnWater;
				clone.JumpVar = original.JumpVar;
				clone.DoubleJumping = original.DoubleJumping;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "luna_nights_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "luna_nights_mapvars";
		public double Warp1_X = 0;
		public double Warp2_X = 0;
		public double Warp3_X = 0;
		public double Warp4_X = 0;
		public double Warp5_X = 0;
		public double Warp6_X = 0;
		public double Warp7_X = 0;
		public double Warp1_Y = 0;
		public double Warp2_Y = 0;
		public double Warp3_Y = 0;
		public double Warp4_Y = 0;
		public double Warp5_Y = 0;
		public double Warp6_Y = 0;
		public double Warp7_Y = 0;
		public double Warp1_Z = 0;
		public double Warp2_Z = 0;
		public double Warp3_Z = 0;
		public double Warp4_Z = 0;
		public double Warp5_Z = 0;
		public double Warp6_Z = 0;
		public double Warp7_Z = 0;
		public boolean Warp1 = false;
		public boolean Warp2 = false;
		public boolean Warp3 = false;
		public boolean Warp4 = false;
		public boolean Warp5 = false;
		public boolean Warp6 = false;
		public boolean Warp7 = false;
		public String Warp1Name = "";
		public String Warp2Name = "";
		public String Warp3Name = "";
		public String Warp4Name = "";
		public String Warp5Name = "";
		public String Warp6Name = "";
		public String Warp7Name = "";
		public boolean TimeStop = false;
		public boolean sitMana = false;
		public boolean sitTime = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			Warp1_X = nbt.getDouble("Warp1_X");
			Warp2_X = nbt.getDouble("Warp2_X");
			Warp3_X = nbt.getDouble("Warp3_X");
			Warp4_X = nbt.getDouble("Warp4_X");
			Warp5_X = nbt.getDouble("Warp5_X");
			Warp6_X = nbt.getDouble("Warp6_X");
			Warp7_X = nbt.getDouble("Warp7_X");
			Warp1_Y = nbt.getDouble("Warp1_Y");
			Warp2_Y = nbt.getDouble("Warp2_Y");
			Warp3_Y = nbt.getDouble("Warp3_Y");
			Warp4_Y = nbt.getDouble("Warp4_Y");
			Warp5_Y = nbt.getDouble("Warp5_Y");
			Warp6_Y = nbt.getDouble("Warp6_Y");
			Warp7_Y = nbt.getDouble("Warp7_Y");
			Warp1_Z = nbt.getDouble("Warp1_Z");
			Warp2_Z = nbt.getDouble("Warp2_Z");
			Warp3_Z = nbt.getDouble("Warp3_Z");
			Warp4_Z = nbt.getDouble("Warp4_Z");
			Warp5_Z = nbt.getDouble("Warp5_Z");
			Warp6_Z = nbt.getDouble("Warp6_Z");
			Warp7_Z = nbt.getDouble("Warp7_Z");
			Warp1 = nbt.getBoolean("Warp1");
			Warp2 = nbt.getBoolean("Warp2");
			Warp3 = nbt.getBoolean("Warp3");
			Warp4 = nbt.getBoolean("Warp4");
			Warp5 = nbt.getBoolean("Warp5");
			Warp6 = nbt.getBoolean("Warp6");
			Warp7 = nbt.getBoolean("Warp7");
			Warp1Name = nbt.getString("Warp1Name");
			Warp2Name = nbt.getString("Warp2Name");
			Warp3Name = nbt.getString("Warp3Name");
			Warp4Name = nbt.getString("Warp4Name");
			Warp5Name = nbt.getString("Warp5Name");
			Warp6Name = nbt.getString("Warp6Name");
			Warp7Name = nbt.getString("Warp7Name");
			TimeStop = nbt.getBoolean("TimeStop");
			sitMana = nbt.getBoolean("sitMana");
			sitTime = nbt.getBoolean("sitTime");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("Warp1_X", Warp1_X);
			nbt.putDouble("Warp2_X", Warp2_X);
			nbt.putDouble("Warp3_X", Warp3_X);
			nbt.putDouble("Warp4_X", Warp4_X);
			nbt.putDouble("Warp5_X", Warp5_X);
			nbt.putDouble("Warp6_X", Warp6_X);
			nbt.putDouble("Warp7_X", Warp7_X);
			nbt.putDouble("Warp1_Y", Warp1_Y);
			nbt.putDouble("Warp2_Y", Warp2_Y);
			nbt.putDouble("Warp3_Y", Warp3_Y);
			nbt.putDouble("Warp4_Y", Warp4_Y);
			nbt.putDouble("Warp5_Y", Warp5_Y);
			nbt.putDouble("Warp6_Y", Warp6_Y);
			nbt.putDouble("Warp7_Y", Warp7_Y);
			nbt.putDouble("Warp1_Z", Warp1_Z);
			nbt.putDouble("Warp2_Z", Warp2_Z);
			nbt.putDouble("Warp3_Z", Warp3_Z);
			nbt.putDouble("Warp4_Z", Warp4_Z);
			nbt.putDouble("Warp5_Z", Warp5_Z);
			nbt.putDouble("Warp6_Z", Warp6_Z);
			nbt.putDouble("Warp7_Z", Warp7_Z);
			nbt.putBoolean("Warp1", Warp1);
			nbt.putBoolean("Warp2", Warp2);
			nbt.putBoolean("Warp3", Warp3);
			nbt.putBoolean("Warp4", Warp4);
			nbt.putBoolean("Warp5", Warp5);
			nbt.putBoolean("Warp6", Warp6);
			nbt.putBoolean("Warp7", Warp7);
			nbt.putString("Warp1Name", Warp1Name);
			nbt.putString("Warp2Name", Warp2Name);
			nbt.putString("Warp3Name", Warp3Name);
			nbt.putString("Warp4Name", Warp4Name);
			nbt.putString("Warp5Name", Warp5Name);
			nbt.putString("Warp6Name", Warp6Name);
			nbt.putString("Warp7Name", Warp7Name);
			nbt.putBoolean("TimeStop", TimeStop);
			nbt.putBoolean("sitMana", sitMana);
			nbt.putBoolean("sitTime", sitTime);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("luna_nights", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean WarpOverlay_1 = false;
		public boolean WarpOverlay_2 = false;
		public boolean WarpOverlay_3 = false;
		public boolean WarpOverlay_4 = false;
		public boolean WarpOverlay_5 = false;
		public boolean WarpOverlay_6 = false;
		public boolean ManaStart = false;
		public double MaxMana = 0.0;
		public double ManaMultiplier = 0.0;
		public double Mana = 100.0;
		public boolean TimeStart = false;
		public double MaxTime = 100.0;
		public double TimeMultiplier = 0.0;
		public double Time = 100.0;
		public double AquamarineCount = 0.0;
		public double TopazCount = 0.0;
		public double RubyCount = 0.0;
		public double SapphireCount = 0.0;
		public double EmeraldCount = 0.0;
		public boolean WalkOnWater = false;
		public boolean JumpVar = false;
		public boolean DoubleJumping = false;
		public double LvLtrack = 0;
		public boolean MPtrack = true;
		public boolean TGtrack = true;
		public boolean LvlUpOverlay = false;
		public boolean MPInc1 = false;
		public boolean MPInc2 = false;
		public boolean MPInc3 = false;
		public boolean MPInc4 = false;
		public boolean MPInc5 = false;
		public boolean TGInc1 = false;
		public boolean TGInc2 = false;
		public boolean TGInc3 = false;
		public boolean TGInc4 = false;
		public boolean TGInc5 = false;
		public boolean TGInc6 = false;
		public boolean ManaBar_0 = false;
		public boolean ManaBar_1 = false;
		public boolean ManaBar_2 = false;
		public boolean ManaBar_3 = false;
		public boolean ManaBar_4 = false;
		public boolean ManaBar_5 = false;
		public boolean ManaBar_6 = false;
		public boolean ManaBar_7 = false;
		public boolean ManaBar_8 = false;
		public boolean ManaBar_9 = false;
		public boolean ManaBar_10 = false;
		public boolean ManaBar_11 = false;
		public boolean ManaBar_12 = false;
		public boolean ManaBar_13 = false;
		public boolean ManaBar_14 = false;
		public boolean ManaBar_15 = false;
		public boolean ManaBar_16 = false;
		public boolean ManaBar_17 = false;
		public boolean ManaBar_18 = false;
		public boolean ManaBar_19 = false;
		public boolean ManaBar_20 = false;
		public boolean ManaBar_21 = false;
		public boolean ManaBar_22 = false;
		public boolean ManaBar_23 = false;
		public boolean ManaBar_24 = false;
		public boolean ManaBar_25 = false;
		public boolean ManaBar_26 = false;
		public boolean ManaBar_27 = false;
		public boolean ManaBar_28 = false;
		public boolean ManaBar_29 = false;
		public boolean ManaBar_30 = false;
		public boolean TimeBar_0 = false;
		public boolean TimeBar_1 = false;
		public boolean TimeBar_2 = false;
		public boolean TimeBar_3 = false;
		public boolean TimeBar_4 = false;
		public boolean TimeBar_5 = false;
		public boolean TimeBar_6 = false;
		public boolean TimeBar_7 = false;
		public boolean TimeBar_8 = false;
		public boolean TimeBar_9 = false;
		public boolean TimeBar_10 = false;
		public boolean TimeBar_11 = false;
		public boolean TimeBar_12 = false;
		public boolean TimeBar_13 = false;
		public boolean TimeBar_14 = false;
		public boolean TimeBar_15 = false;
		public boolean TimeBar_16 = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				LunaNightsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("WarpOverlay_1", WarpOverlay_1);
			nbt.putBoolean("WarpOverlay_2", WarpOverlay_2);
			nbt.putBoolean("WarpOverlay_3", WarpOverlay_3);
			nbt.putBoolean("WarpOverlay_4", WarpOverlay_4);
			nbt.putBoolean("WarpOverlay_5", WarpOverlay_5);
			nbt.putBoolean("WarpOverlay_6", WarpOverlay_6);
			nbt.putBoolean("ManaStart", ManaStart);
			nbt.putDouble("MaxMana", MaxMana);
			nbt.putDouble("ManaMultiplier", ManaMultiplier);
			nbt.putDouble("Mana", Mana);
			nbt.putBoolean("TimeStart", TimeStart);
			nbt.putDouble("MaxTime", MaxTime);
			nbt.putDouble("TimeMultiplier", TimeMultiplier);
			nbt.putDouble("Time", Time);
			nbt.putDouble("AquamarineCount", AquamarineCount);
			nbt.putDouble("TopazCount", TopazCount);
			nbt.putDouble("RubyCount", RubyCount);
			nbt.putDouble("SapphireCount", SapphireCount);
			nbt.putDouble("EmeraldCount", EmeraldCount);
			nbt.putBoolean("WalkOnWater", WalkOnWater);
			nbt.putBoolean("JumpVar", JumpVar);
			nbt.putBoolean("DoubleJumping", DoubleJumping);
			nbt.putDouble("LvLtrack", LvLtrack);
			nbt.putBoolean("MPtrack", MPtrack);
			nbt.putBoolean("TGtrack", TGtrack);
			nbt.putBoolean("LvlUpOverlay", LvlUpOverlay);
			nbt.putBoolean("MPInc1", MPInc1);
			nbt.putBoolean("MPInc2", MPInc2);
			nbt.putBoolean("MPInc3", MPInc3);
			nbt.putBoolean("MPInc4", MPInc4);
			nbt.putBoolean("MPInc5", MPInc5);
			nbt.putBoolean("TGInc1", TGInc1);
			nbt.putBoolean("TGInc2", TGInc2);
			nbt.putBoolean("TGInc3", TGInc3);
			nbt.putBoolean("TGInc4", TGInc4);
			nbt.putBoolean("TGInc5", TGInc5);
			nbt.putBoolean("TGInc6", TGInc6);
			nbt.putBoolean("ManaBar_0", ManaBar_0);
			nbt.putBoolean("ManaBar_1", ManaBar_1);
			nbt.putBoolean("ManaBar_2", ManaBar_2);
			nbt.putBoolean("ManaBar_3", ManaBar_3);
			nbt.putBoolean("ManaBar_4", ManaBar_4);
			nbt.putBoolean("ManaBar_5", ManaBar_5);
			nbt.putBoolean("ManaBar_6", ManaBar_6);
			nbt.putBoolean("ManaBar_7", ManaBar_7);
			nbt.putBoolean("ManaBar_8", ManaBar_8);
			nbt.putBoolean("ManaBar_9", ManaBar_9);
			nbt.putBoolean("ManaBar_10", ManaBar_10);
			nbt.putBoolean("ManaBar_11", ManaBar_11);
			nbt.putBoolean("ManaBar_12", ManaBar_12);
			nbt.putBoolean("ManaBar_13", ManaBar_13);
			nbt.putBoolean("ManaBar_14", ManaBar_14);
			nbt.putBoolean("ManaBar_15", ManaBar_15);
			nbt.putBoolean("ManaBar_16", ManaBar_16);
			nbt.putBoolean("ManaBar_17", ManaBar_17);
			nbt.putBoolean("ManaBar_18", ManaBar_18);
			nbt.putBoolean("ManaBar_19", ManaBar_19);
			nbt.putBoolean("ManaBar_20", ManaBar_20);
			nbt.putBoolean("ManaBar_21", ManaBar_21);
			nbt.putBoolean("ManaBar_22", ManaBar_22);
			nbt.putBoolean("ManaBar_23", ManaBar_23);
			nbt.putBoolean("ManaBar_24", ManaBar_24);
			nbt.putBoolean("ManaBar_25", ManaBar_25);
			nbt.putBoolean("ManaBar_26", ManaBar_26);
			nbt.putBoolean("ManaBar_27", ManaBar_27);
			nbt.putBoolean("ManaBar_28", ManaBar_28);
			nbt.putBoolean("ManaBar_29", ManaBar_29);
			nbt.putBoolean("ManaBar_30", ManaBar_30);
			nbt.putBoolean("TimeBar_0", TimeBar_0);
			nbt.putBoolean("TimeBar_1", TimeBar_1);
			nbt.putBoolean("TimeBar_2", TimeBar_2);
			nbt.putBoolean("TimeBar_3", TimeBar_3);
			nbt.putBoolean("TimeBar_4", TimeBar_4);
			nbt.putBoolean("TimeBar_5", TimeBar_5);
			nbt.putBoolean("TimeBar_6", TimeBar_6);
			nbt.putBoolean("TimeBar_7", TimeBar_7);
			nbt.putBoolean("TimeBar_8", TimeBar_8);
			nbt.putBoolean("TimeBar_9", TimeBar_9);
			nbt.putBoolean("TimeBar_10", TimeBar_10);
			nbt.putBoolean("TimeBar_11", TimeBar_11);
			nbt.putBoolean("TimeBar_12", TimeBar_12);
			nbt.putBoolean("TimeBar_13", TimeBar_13);
			nbt.putBoolean("TimeBar_14", TimeBar_14);
			nbt.putBoolean("TimeBar_15", TimeBar_15);
			nbt.putBoolean("TimeBar_16", TimeBar_16);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			WarpOverlay_1 = nbt.getBoolean("WarpOverlay_1");
			WarpOverlay_2 = nbt.getBoolean("WarpOverlay_2");
			WarpOverlay_3 = nbt.getBoolean("WarpOverlay_3");
			WarpOverlay_4 = nbt.getBoolean("WarpOverlay_4");
			WarpOverlay_5 = nbt.getBoolean("WarpOverlay_5");
			WarpOverlay_6 = nbt.getBoolean("WarpOverlay_6");
			ManaStart = nbt.getBoolean("ManaStart");
			MaxMana = nbt.getDouble("MaxMana");
			ManaMultiplier = nbt.getDouble("ManaMultiplier");
			Mana = nbt.getDouble("Mana");
			TimeStart = nbt.getBoolean("TimeStart");
			MaxTime = nbt.getDouble("MaxTime");
			TimeMultiplier = nbt.getDouble("TimeMultiplier");
			Time = nbt.getDouble("Time");
			AquamarineCount = nbt.getDouble("AquamarineCount");
			TopazCount = nbt.getDouble("TopazCount");
			RubyCount = nbt.getDouble("RubyCount");
			SapphireCount = nbt.getDouble("SapphireCount");
			EmeraldCount = nbt.getDouble("EmeraldCount");
			WalkOnWater = nbt.getBoolean("WalkOnWater");
			JumpVar = nbt.getBoolean("JumpVar");
			DoubleJumping = nbt.getBoolean("DoubleJumping");
			LvLtrack = nbt.getDouble("LvLtrack");
			MPtrack = nbt.getBoolean("MPtrack");
			TGtrack = nbt.getBoolean("TGtrack");
			LvlUpOverlay = nbt.getBoolean("LvlUpOverlay");
			MPInc1 = nbt.getBoolean("MPInc1");
			MPInc2 = nbt.getBoolean("MPInc2");
			MPInc3 = nbt.getBoolean("MPInc3");
			MPInc4 = nbt.getBoolean("MPInc4");
			MPInc5 = nbt.getBoolean("MPInc5");
			TGInc1 = nbt.getBoolean("TGInc1");
			TGInc2 = nbt.getBoolean("TGInc2");
			TGInc3 = nbt.getBoolean("TGInc3");
			TGInc4 = nbt.getBoolean("TGInc4");
			TGInc5 = nbt.getBoolean("TGInc5");
			TGInc6 = nbt.getBoolean("TGInc6");
			ManaBar_0 = nbt.getBoolean("ManaBar_0");
			ManaBar_1 = nbt.getBoolean("ManaBar_1");
			ManaBar_2 = nbt.getBoolean("ManaBar_2");
			ManaBar_3 = nbt.getBoolean("ManaBar_3");
			ManaBar_4 = nbt.getBoolean("ManaBar_4");
			ManaBar_5 = nbt.getBoolean("ManaBar_5");
			ManaBar_6 = nbt.getBoolean("ManaBar_6");
			ManaBar_7 = nbt.getBoolean("ManaBar_7");
			ManaBar_8 = nbt.getBoolean("ManaBar_8");
			ManaBar_9 = nbt.getBoolean("ManaBar_9");
			ManaBar_10 = nbt.getBoolean("ManaBar_10");
			ManaBar_11 = nbt.getBoolean("ManaBar_11");
			ManaBar_12 = nbt.getBoolean("ManaBar_12");
			ManaBar_13 = nbt.getBoolean("ManaBar_13");
			ManaBar_14 = nbt.getBoolean("ManaBar_14");
			ManaBar_15 = nbt.getBoolean("ManaBar_15");
			ManaBar_16 = nbt.getBoolean("ManaBar_16");
			ManaBar_17 = nbt.getBoolean("ManaBar_17");
			ManaBar_18 = nbt.getBoolean("ManaBar_18");
			ManaBar_19 = nbt.getBoolean("ManaBar_19");
			ManaBar_20 = nbt.getBoolean("ManaBar_20");
			ManaBar_21 = nbt.getBoolean("ManaBar_21");
			ManaBar_22 = nbt.getBoolean("ManaBar_22");
			ManaBar_23 = nbt.getBoolean("ManaBar_23");
			ManaBar_24 = nbt.getBoolean("ManaBar_24");
			ManaBar_25 = nbt.getBoolean("ManaBar_25");
			ManaBar_26 = nbt.getBoolean("ManaBar_26");
			ManaBar_27 = nbt.getBoolean("ManaBar_27");
			ManaBar_28 = nbt.getBoolean("ManaBar_28");
			ManaBar_29 = nbt.getBoolean("ManaBar_29");
			ManaBar_30 = nbt.getBoolean("ManaBar_30");
			TimeBar_0 = nbt.getBoolean("TimeBar_0");
			TimeBar_1 = nbt.getBoolean("TimeBar_1");
			TimeBar_2 = nbt.getBoolean("TimeBar_2");
			TimeBar_3 = nbt.getBoolean("TimeBar_3");
			TimeBar_4 = nbt.getBoolean("TimeBar_4");
			TimeBar_5 = nbt.getBoolean("TimeBar_5");
			TimeBar_6 = nbt.getBoolean("TimeBar_6");
			TimeBar_7 = nbt.getBoolean("TimeBar_7");
			TimeBar_8 = nbt.getBoolean("TimeBar_8");
			TimeBar_9 = nbt.getBoolean("TimeBar_9");
			TimeBar_10 = nbt.getBoolean("TimeBar_10");
			TimeBar_11 = nbt.getBoolean("TimeBar_11");
			TimeBar_12 = nbt.getBoolean("TimeBar_12");
			TimeBar_13 = nbt.getBoolean("TimeBar_13");
			TimeBar_14 = nbt.getBoolean("TimeBar_14");
			TimeBar_15 = nbt.getBoolean("TimeBar_15");
			TimeBar_16 = nbt.getBoolean("TimeBar_16");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.WarpOverlay_1 = message.data.WarpOverlay_1;
					variables.WarpOverlay_2 = message.data.WarpOverlay_2;
					variables.WarpOverlay_3 = message.data.WarpOverlay_3;
					variables.WarpOverlay_4 = message.data.WarpOverlay_4;
					variables.WarpOverlay_5 = message.data.WarpOverlay_5;
					variables.WarpOverlay_6 = message.data.WarpOverlay_6;
					variables.ManaStart = message.data.ManaStart;
					variables.MaxMana = message.data.MaxMana;
					variables.ManaMultiplier = message.data.ManaMultiplier;
					variables.Mana = message.data.Mana;
					variables.TimeStart = message.data.TimeStart;
					variables.MaxTime = message.data.MaxTime;
					variables.TimeMultiplier = message.data.TimeMultiplier;
					variables.Time = message.data.Time;
					variables.AquamarineCount = message.data.AquamarineCount;
					variables.TopazCount = message.data.TopazCount;
					variables.RubyCount = message.data.RubyCount;
					variables.SapphireCount = message.data.SapphireCount;
					variables.EmeraldCount = message.data.EmeraldCount;
					variables.WalkOnWater = message.data.WalkOnWater;
					variables.JumpVar = message.data.JumpVar;
					variables.DoubleJumping = message.data.DoubleJumping;
					variables.LvLtrack = message.data.LvLtrack;
					variables.MPtrack = message.data.MPtrack;
					variables.TGtrack = message.data.TGtrack;
					variables.LvlUpOverlay = message.data.LvlUpOverlay;
					variables.MPInc1 = message.data.MPInc1;
					variables.MPInc2 = message.data.MPInc2;
					variables.MPInc3 = message.data.MPInc3;
					variables.MPInc4 = message.data.MPInc4;
					variables.MPInc5 = message.data.MPInc5;
					variables.TGInc1 = message.data.TGInc1;
					variables.TGInc2 = message.data.TGInc2;
					variables.TGInc3 = message.data.TGInc3;
					variables.TGInc4 = message.data.TGInc4;
					variables.TGInc5 = message.data.TGInc5;
					variables.TGInc6 = message.data.TGInc6;
					variables.ManaBar_0 = message.data.ManaBar_0;
					variables.ManaBar_1 = message.data.ManaBar_1;
					variables.ManaBar_2 = message.data.ManaBar_2;
					variables.ManaBar_3 = message.data.ManaBar_3;
					variables.ManaBar_4 = message.data.ManaBar_4;
					variables.ManaBar_5 = message.data.ManaBar_5;
					variables.ManaBar_6 = message.data.ManaBar_6;
					variables.ManaBar_7 = message.data.ManaBar_7;
					variables.ManaBar_8 = message.data.ManaBar_8;
					variables.ManaBar_9 = message.data.ManaBar_9;
					variables.ManaBar_10 = message.data.ManaBar_10;
					variables.ManaBar_11 = message.data.ManaBar_11;
					variables.ManaBar_12 = message.data.ManaBar_12;
					variables.ManaBar_13 = message.data.ManaBar_13;
					variables.ManaBar_14 = message.data.ManaBar_14;
					variables.ManaBar_15 = message.data.ManaBar_15;
					variables.ManaBar_16 = message.data.ManaBar_16;
					variables.ManaBar_17 = message.data.ManaBar_17;
					variables.ManaBar_18 = message.data.ManaBar_18;
					variables.ManaBar_19 = message.data.ManaBar_19;
					variables.ManaBar_20 = message.data.ManaBar_20;
					variables.ManaBar_21 = message.data.ManaBar_21;
					variables.ManaBar_22 = message.data.ManaBar_22;
					variables.ManaBar_23 = message.data.ManaBar_23;
					variables.ManaBar_24 = message.data.ManaBar_24;
					variables.ManaBar_25 = message.data.ManaBar_25;
					variables.ManaBar_26 = message.data.ManaBar_26;
					variables.ManaBar_27 = message.data.ManaBar_27;
					variables.ManaBar_28 = message.data.ManaBar_28;
					variables.ManaBar_29 = message.data.ManaBar_29;
					variables.ManaBar_30 = message.data.ManaBar_30;
					variables.TimeBar_0 = message.data.TimeBar_0;
					variables.TimeBar_1 = message.data.TimeBar_1;
					variables.TimeBar_2 = message.data.TimeBar_2;
					variables.TimeBar_3 = message.data.TimeBar_3;
					variables.TimeBar_4 = message.data.TimeBar_4;
					variables.TimeBar_5 = message.data.TimeBar_5;
					variables.TimeBar_6 = message.data.TimeBar_6;
					variables.TimeBar_7 = message.data.TimeBar_7;
					variables.TimeBar_8 = message.data.TimeBar_8;
					variables.TimeBar_9 = message.data.TimeBar_9;
					variables.TimeBar_10 = message.data.TimeBar_10;
					variables.TimeBar_11 = message.data.TimeBar_11;
					variables.TimeBar_12 = message.data.TimeBar_12;
					variables.TimeBar_13 = message.data.TimeBar_13;
					variables.TimeBar_14 = message.data.TimeBar_14;
					variables.TimeBar_15 = message.data.TimeBar_15;
					variables.TimeBar_16 = message.data.TimeBar_16;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
