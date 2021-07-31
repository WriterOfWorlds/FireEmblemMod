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
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
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
		public double sword = 0;
		public double axe = 0;
		public double lance = 0;
		public double magic = 0;
		public double brawl = 0;
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
		if (!event.isWasDeath()) {
			clone.headslow = original.headslow;
			clone.chestslow = original.chestslow;
			clone.legslow = original.legslow;
			clone.footslow = original.footslow;
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
