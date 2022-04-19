package net.mcreator.fireemblem.procedures;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemMod;

import java.util.jar.Attributes;
import java.util.Map;

public class HammorLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure HammorLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HammorLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity instanceof LivingEntity)
				? ((LivingEntity) sourceentity).getHealth()
				: -1) < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) / 2) {
			entity.setFire((int) 15);
			((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(2);
		} else {
			((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(1);
		}
	}
}
