package net.mcreator.fireemblem.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;

public class MarbleAdditionalGenerationConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency world for procedure MarbleAdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((net.minecraftforge.fml.ModList.get().isLoaded("quark"))) {
			return (false);
		}
		return (true);
	}
}
