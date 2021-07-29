package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class StatHealthProcedure {
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
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure StatHealth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)
				.setBaseValue((20 + ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		{
			double _setval = (double) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) / 8);
			entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.res = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
