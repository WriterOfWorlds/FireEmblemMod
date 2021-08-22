package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class TimePassProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency world for procedure TimePass!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((FireEmblemModVariables.MapVariables.get(world).tick < 20)) {
			FireEmblemModVariables.MapVariables.get(world).tick = (double) (FireEmblemModVariables.MapVariables.get(world).tick + 1);
			FireEmblemModVariables.MapVariables.get(world).syncData(world);
		} else if ((FireEmblemModVariables.MapVariables.get(world).tick == 20)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent(((((world instanceof World) ? ((World) world).isDaytime() : false))
							+ "" + (FireEmblemModVariables.MapVariables.get(world).tick))), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			FireEmblemModVariables.MapVariables.get(world).tick = (double) 0;
			FireEmblemModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
