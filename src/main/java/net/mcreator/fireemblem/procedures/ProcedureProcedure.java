package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.world.CrestGameRule;
import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class ProcedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure Procedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency world for procedure Procedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 1)) {
			{
				String _setval = (String) "Blaiddyd M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 2)) {
			{
				String _setval = (String) "Blaiddyd m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 3)) {
			{
				String _setval = (String) "Charon M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 4)) {
			{
				String _setval = (String) "Charon m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 5)) {
			{
				String _setval = (String) "Daphnel M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 6)) {
			{
				String _setval = (String) "Daphnel m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 7)) {
			{
				String _setval = (String) "Dominic M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 8)) {
			{
				String _setval = (String) "Dominic m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 9)) {
			{
				String _setval = (String) "Fraldarius M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 10)) {
			{
				String _setval = (String) "Fraldarius m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 11)) {
			{
				String _setval = (String) "Gautier M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 12)) {
			{
				String _setval = (String) "Gautier m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 13)) {
			{
				String _setval = (String) "Gloucester M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 14)) {
			{
				String _setval = (String) "Gloucester m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 15)) {
			{
				String _setval = (String) "Goneril M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 16)) {
			{
				String _setval = (String) "Goneril m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 17)) {
			{
				String _setval = (String) "Lamine M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 18)) {
			{
				String _setval = (String) "Lamine m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 19)) {
			{
				String _setval = (String) "Riegan M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 20)) {
			{
				String _setval = (String) "Riegan m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 21)) {
			{
				String _setval = (String) "Maurice M";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getInt(CrestGameRule.gamerule)) == 22)) {
			{
				String _setval = (String) "Maurice m";
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.crest = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
