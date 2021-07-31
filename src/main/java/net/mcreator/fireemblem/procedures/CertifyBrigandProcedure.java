package net.mcreator.fireemblem.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;

public class CertifyBrigandProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure CertifyBrigand!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).axe) >= 100)) {
			return (true);
		}
		return (false);
	}
}
