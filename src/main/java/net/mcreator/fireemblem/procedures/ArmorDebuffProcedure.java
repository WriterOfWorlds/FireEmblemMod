package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class ArmorDebuffProcedure {
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
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure ArmorDebuff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == Items.IRON_HELMET)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.headslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == Items.IRON_CHESTPLATE)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chestslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
				: ItemStack.EMPTY).getItem() == Items.IRON_LEGGINGS)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.legslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == Items.IRON_BOOTS)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.footslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.headslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE)) {
			{
				double _setval = (double) 1;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chestslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
				: ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS)) {
			{
				double _setval = (double) 1;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.legslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == Items.DIAMOND_BOOTS)) {
			{
				double _setval = (double) 0;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.footslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET)) {
			{
				double _setval = (double) 1;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.headslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == Items.NETHERITE_CHESTPLATE)) {
			{
				double _setval = (double) 2;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chestslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
				: ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS)) {
			{
				double _setval = (double) 1;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.legslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == Items.NETHERITE_BOOTS)) {
			{
				double _setval = (double) 1;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.footslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			{
				double _setval = (double) (-1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.headslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			{
				double _setval = (double) (-1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chestslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
				: ItemStack.EMPTY).getItem() == Items.ELYTRA)) {
			{
				double _setval = (double) (-1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chestslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			{
				double _setval = (double) (-1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.legslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			{
				double _setval = (double) (-1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.footslow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).headslow)
				+ ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).chestslow))
				+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).legslow)
						+ ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireEmblemModVariables.PlayerVariables())).footslow))) >= 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20,
						(int) (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new FireEmblemModVariables.PlayerVariables())).headslow)
								+ ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireEmblemModVariables.PlayerVariables())).chestslow))
								+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireEmblemModVariables.PlayerVariables())).legslow)
										+ ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireEmblemModVariables.PlayerVariables())).footslow)))
								- ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new FireEmblemModVariables.PlayerVariables())).res))));
		}
	}
}
