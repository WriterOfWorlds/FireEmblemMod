package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
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

public class GiveForgeProcedure {
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
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure GiveForge!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedIronSwordItem.block)) : false)
				|| (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedIronAxeItem.block))
						: false)
						|| (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedGoldSwordItem.block))
								: false)
								|| (((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedGoldAxeItem.block))
										: false)
										|| (((entity instanceof PlayerEntity)
												? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedDiamondSwordItem.block))
												: false)
												|| (((entity instanceof PlayerEntity)
														? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ForgedDiamondAxeItem.block))
														: false)
														|| (((entity instanceof PlayerEntity)
																? ((PlayerEntity) entity).inventory
																		.hasItemStack(new ItemStack(ForgedNetherSwordItem.block))
																: false)
																|| (((entity instanceof PlayerEntity)
																		? ((PlayerEntity) entity).inventory
																				.hasItemStack(new ItemStack(ForgedNetherAxeItem.block))
																		: false)
																		|| ((entity instanceof PlayerEntity)
																				? ((PlayerEntity) entity).inventory
																						.hasItemStack(new ItemStack(ForgedSilverSwordItem.block))
																				: false)))))))))) {
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("fire_emblem:forge")))
							.isDone()
					: false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("fire_emblem:forge"));
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
