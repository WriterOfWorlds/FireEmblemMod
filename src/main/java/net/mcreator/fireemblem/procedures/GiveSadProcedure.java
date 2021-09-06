package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.fireemblem.item.ForgedSilverSwordItem;
import net.mcreator.fireemblem.item.ForgedNetherSwordItem;
import net.mcreator.fireemblem.item.ForgedNetherAxeItem;
import net.mcreator.fireemblem.item.ForgedIronSwordItem;
import net.mcreator.fireemblem.item.ForgedIronAxeItem;
import net.mcreator.fireemblem.item.ForgedGoldSwordItem;
import net.mcreator.fireemblem.item.ForgedGoldAxeItem;
import net.mcreator.fireemblem.item.ForgedDiamondSwordItem;
import net.mcreator.fireemblem.item.ForgedDiamondAxeItem;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class GiveSadProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onItemDestroyed(PlayerDestroyItemEvent event) {
			Entity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			ItemStack itemstack = event.getOriginal();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			dependencies.put("itemstack", itemstack);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure GiveSad!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency itemstack for procedure GiveSad!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).getItem() == ForgedIronSwordItem.block) || (((itemstack).getItem() == ForgedIronAxeItem.block)
				|| (((itemstack).getItem() == ForgedGoldSwordItem.block) || (((itemstack).getItem() == ForgedGoldAxeItem.block)
						|| (((itemstack).getItem() == ForgedDiamondSwordItem.block) || (((itemstack).getItem() == ForgedDiamondAxeItem.block)
								|| (((itemstack).getItem() == ForgedNetherSwordItem.block) || (((itemstack).getItem() == ForgedNetherAxeItem.block)
										|| ((itemstack).getItem() == ForgedSilverSwordItem.block)))))))))) {
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("fire_emblem:sad")))
							.isDone()
					: false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("fire_emblem:sad"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
	}
}
