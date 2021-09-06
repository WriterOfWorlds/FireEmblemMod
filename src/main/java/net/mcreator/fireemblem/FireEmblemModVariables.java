package net.mcreator.fireemblem;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class FireEmblemModVariables {
	public FireEmblemModVariables(FireEmblemModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "fire_emblem_worldvars";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "fire_emblem_mapvars";
		public double day = 1.0;
		public String month = "Guardian Moon";
		public double year = 1180.0;
		public boolean dorn = false;
		public double tick = 0;
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			day = nbt.getDouble("day");
			month = nbt.getString("month");
			year = nbt.getDouble("year");
			dorn = nbt.getBoolean("dorn");
			tick = nbt.getDouble("tick");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("day", day);
			nbt.putString("month", month);
			nbt.putDouble("year", year);
			nbt.putBoolean("dorn", dorn);
			nbt.putDouble("tick", tick);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("fire_emblem", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("headslow", instance.headslow);
			nbt.putDouble("chestslow", instance.chestslow);
			nbt.putDouble("legslow", instance.legslow);
			nbt.putDouble("footslow", instance.footslow);
			nbt.putDouble("res", instance.res);
			nbt.putString("goddess", instance.goddess);
			nbt.putString("playerclass", instance.playerclass);
			nbt.putDouble("bow", instance.bow);
			nbt.putDouble("sword", instance.sword);
			nbt.putDouble("axe", instance.axe);
			nbt.putDouble("lance", instance.lance);
			nbt.putDouble("magic", instance.magic);
			nbt.putDouble("brawl", instance.brawl);
			nbt.putDouble("heavyarmor", instance.heavyarmor);
			nbt.putDouble("atk", instance.atk);
			nbt.putDouble("page", instance.page);
			nbt.putString("crest", instance.crest);
			nbt.putBoolean("hasSB", instance.hasSB);
			nbt.putDouble("atkmod", instance.atkmod);
			nbt.putDouble("atkformula", instance.atkformula);
			nbt.putBoolean("hasSS", instance.hasSS);
			nbt.putBoolean("SSip", instance.SSip);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.headslow = nbt.getDouble("headslow");
			instance.chestslow = nbt.getDouble("chestslow");
			instance.legslow = nbt.getDouble("legslow");
			instance.footslow = nbt.getDouble("footslow");
			instance.res = nbt.getDouble("res");
			instance.goddess = nbt.getString("goddess");
			instance.playerclass = nbt.getString("playerclass");
			instance.bow = nbt.getDouble("bow");
			instance.sword = nbt.getDouble("sword");
			instance.axe = nbt.getDouble("axe");
			instance.lance = nbt.getDouble("lance");
			instance.magic = nbt.getDouble("magic");
			instance.brawl = nbt.getDouble("brawl");
			instance.heavyarmor = nbt.getDouble("heavyarmor");
			instance.atk = nbt.getDouble("atk");
			instance.page = nbt.getDouble("page");
			instance.crest = nbt.getString("crest");
			instance.hasSB = nbt.getBoolean("hasSB");
			instance.atkmod = nbt.getDouble("atkmod");
			instance.atkformula = nbt.getDouble("atkformula");
			instance.hasSS = nbt.getBoolean("hasSS");
			instance.SSip = nbt.getBoolean("SSip");
		}
	}

	public static class PlayerVariables {
		public double headslow = 0;
		public double chestslow = 0;
		public double legslow = 0;
		public double footslow = 0;
		public double res = 0;
		public String goddess = "";
		public String playerclass = "Commoner";
		public double bow = 0;
		public double sword = 0.0;
		public double axe = 0;
		public double lance = 0;
		public double magic = 0;
		public double brawl = 0;
		public double heavyarmor = 0;
		public double atk = 0.0;
		public double page = 0.0;
		public String crest = "";
		public boolean hasSB = false;
		public double atkmod = 0;
		public double atkformula = 0;
		public boolean hasSS = false;
		public boolean SSip = false;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				FireEmblemMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.res = original.res;
		clone.goddess = original.goddess;
		clone.playerclass = original.playerclass;
		clone.bow = original.bow;
		clone.sword = original.sword;
		clone.axe = original.axe;
		clone.lance = original.lance;
		clone.magic = original.magic;
		clone.brawl = original.brawl;
		clone.heavyarmor = original.heavyarmor;
		clone.atk = original.atk;
		clone.crest = original.crest;
		clone.hasSB = original.hasSB;
		clone.hasSS = original.hasSS;
		if (!event.isWasDeath()) {
			clone.headslow = original.headslow;
			clone.chestslow = original.chestslow;
			clone.legslow = original.legslow;
			clone.footslow = original.footslow;
			clone.page = original.page;
			clone.atkmod = original.atkmod;
			clone.atkformula = original.atkformula;
			clone.SSip = original.SSip;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.headslow = message.data.headslow;
					variables.chestslow = message.data.chestslow;
					variables.legslow = message.data.legslow;
					variables.footslow = message.data.footslow;
					variables.res = message.data.res;
					variables.goddess = message.data.goddess;
					variables.playerclass = message.data.playerclass;
					variables.bow = message.data.bow;
					variables.sword = message.data.sword;
					variables.axe = message.data.axe;
					variables.lance = message.data.lance;
					variables.magic = message.data.magic;
					variables.brawl = message.data.brawl;
					variables.heavyarmor = message.data.heavyarmor;
					variables.atk = message.data.atk;
					variables.page = message.data.page;
					variables.crest = message.data.crest;
					variables.hasSB = message.data.hasSB;
					variables.atkmod = message.data.atkmod;
					variables.atkformula = message.data.atkformula;
					variables.hasSS = message.data.hasSS;
					variables.SSip = message.data.SSip;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
