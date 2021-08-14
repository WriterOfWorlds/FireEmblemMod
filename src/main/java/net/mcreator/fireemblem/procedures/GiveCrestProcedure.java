package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class GiveCrestProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure GiveCrest!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double rand = 0;
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).crest)).equals(""))) {
			rand = (double) ((new Random()).nextInt((int) 23 + 1));
			if ((rand == 0)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Blaiddyd M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Blaiddyd M");
				} else {
					{
						String _setval = (String) "Blaiddyd m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Blaiddyd m");
				}
			} else if ((rand == 1)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Charon M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Charon M");
				} else {
					{
						String _setval = (String) "Charon m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Charon m");
				}
			}
			if ((rand == 2)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Daphnel M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Daphnel M");
				} else {
					{
						String _setval = (String) "Daphnel m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Daphnel m");
				}
			} else if ((rand == 3)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Dominic M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Dominic M");
				} else {
					{
						String _setval = (String) "Dominic m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Dominic m");
				}
			}
			if ((rand == 4)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Fraldarius M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Fraldarius M");
				} else {
					{
						String _setval = (String) "Fraldarius m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Fraldarius m");
				}
			} else if ((rand == 5)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Gautier M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Gautier M");
				} else {
					{
						String _setval = (String) "Gautier m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Gautier m");
				}
			}
			if ((rand == 6)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Gloucester M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Gloucester M");
				} else {
					{
						String _setval = (String) "Gloucester m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Gloucester m");
				}
			} else if ((rand == 7)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Goneril M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Goneril M");
				} else {
					{
						String _setval = (String) "Goneril m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Goneril m");
				}
			}
			if ((rand == 8)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Lamine M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Lamine M");
				} else {
					{
						String _setval = (String) "Lamine m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Lamine m");
				}
			} else if ((rand == 9)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Riegan M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Riegan M");
				} else {
					{
						String _setval = (String) "Riegan m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Riegan m");
				}
			}
			if ((rand == 10)) {
				if ((((new Random()).nextBoolean()) == (true))) {
					{
						String _setval = (String) "Maurice M";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Maurice M");
				} else {
					{
						String _setval = (String) "Maurice m";
						entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.crest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					entity.getPersistentData().putString("crest", "Maurice m");
				}
			} else if ((rand >= 11)) {
				{
					String _setval = (String) "None";
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.crest = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.getPersistentData().putString("crest", "None");
			}
		}
	}
}
