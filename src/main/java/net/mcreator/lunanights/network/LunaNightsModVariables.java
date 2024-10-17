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
			clone.WalkOnWater = original.WalkOnWater;
			if (!event.isWasDeath()) {
				clone.JumpVar = original.JumpVar;
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
		public boolean GlideVar = false;

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
			GlideVar = nbt.getBoolean("GlideVar");
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
			nbt.putBoolean("GlideVar", GlideVar);
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
