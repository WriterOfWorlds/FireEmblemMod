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
		if (((FireEmblemModVariables.MapVariables.get(world).dorn == (false))
				&& (((world instanceof World) ? ((World) world).isDaytime() : false) == (false)))) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("WHY THIS DO"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			FireEmblemModVariables.MapVariables.get(world).dorn = (boolean) (true);
			FireEmblemModVariables.MapVariables.get(world).syncData(world);
		}
		if ((FireEmblemModVariables.MapVariables.get(world).dorn && ((world instanceof World) ? ((World) world).isDaytime() : false))) {
			FireEmblemModVariables.MapVariables.get(world).dorn = (boolean) (false);
			FireEmblemModVariables.MapVariables.get(world).syncData(world);
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent((("THIST DO A WORK") + "" + ((FireEmblemModVariables.MapVariables.get(world).day + 1)))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Guardian Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Pegasus Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Pegasus Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 28)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 28)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Lone Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Lone Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Great Tree Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Great Tree Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 30)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 30)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Harpstring Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Harpstring Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Garland Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Garland Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 30)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 30)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Blue Sea Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Blue Sea Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Verdant Rain Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Verdant Rain Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Horsebow Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Horsebow Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 30)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 30)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Wyvern Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Wyvern Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Red Wolf Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Red Wolf Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 30)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 30)) {
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Ethereal Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (((FireEmblemModVariables.MapVariables.get(world).month).equals("Ethereal Moon"))) {
				if ((FireEmblemModVariables.MapVariables.get(world).day < 31)) {
					FireEmblemModVariables.MapVariables.get(world).day = (double) (FireEmblemModVariables.MapVariables.get(world).day + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				} else if ((FireEmblemModVariables.MapVariables.get(world).day == 31)) {
					FireEmblemModVariables.MapVariables.get(world).year = (double) (FireEmblemModVariables.MapVariables.get(world).year + 1);
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).month = (String) "Guardian Moon";
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
					FireEmblemModVariables.MapVariables.get(world).day = (double) 1;
					FireEmblemModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
