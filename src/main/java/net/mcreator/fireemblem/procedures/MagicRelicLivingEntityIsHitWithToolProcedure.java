package net.mcreator.fireemblem.procedures;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;

public class MagicRelicLivingEntityIsHitWithToolProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure MagicRelicLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MagicRelicLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		entity.setMotionMultiplier(null, new Vector3d(0.25D, (double) 0.05F, 0.25D));
		entity.extinguish();
		if (sourceentity instanceof PlayerEntity)
			((PlayerEntity) sourceentity).giveExperiencePoints((int) 5);
	}
}
