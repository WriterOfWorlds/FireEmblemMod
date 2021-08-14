package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fireemblem.item.SilverSwordItem;
import net.mcreator.fireemblem.item.RelicSwordItem;
import net.mcreator.fireemblem.item.MagicRelicItem;
import net.mcreator.fireemblem.item.HammorItem;
import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class StatIncBCProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure StatIncBC!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StatIncBC!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency world for procedure StatIncBC!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		double rand = 0;
		if ((sourceentity instanceof ServerPlayerEntity)) {
			if ((((((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_SWORD)
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_SWORD))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_SWORD))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_SWORD))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SilverSwordItem.block))) {
				sourceentity.getPersistentData().putDouble("sword", 1);
				if (((((sourceentity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).crest)).equals("Blaiddyd M"))) {
					if ((((new Random()).nextInt((int) 99 + 1)) <= 19)) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
						if (!world.isRemote()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Crest CRIT"), ChatType.SYSTEM, Util.DUMMY_UUID);
						}
					}
				} else if (((((sourceentity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).crest)).equals("Blaiddyd m"))) {
					if ((((new Random()).nextInt((int) 99 + 1)) <= 9)) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 3);
						if (!world.isRemote()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Crest CRIT"), ChatType.SYSTEM, Util.DUMMY_UUID);
						}
					}
				}
			}
			if (((((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				sourceentity.getPersistentData().putDouble("axe", 1);
			}
			if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.BOW)
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CROSSBOW))) {
				sourceentity.getPersistentData().putDouble("bow", 1);
			}
			if ((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == RelicSwordItem.block)
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == HammorItem.block))
					|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == MagicRelicItem.block))) {
				sourceentity.getPersistentData().putDouble("magic", 1);
				if (((((sourceentity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).crest)).equals("Dominic M"))) {
					if ((((new Random()).nextInt((int) 99 + 1)) <= 19)) {
						(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDamage((int) (((((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getHeldItemMainhand()
										: ItemStack.EMPTY)).getDamage()) + 12));
						if (!world.isRemote()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Crest FIX"), ChatType.SYSTEM, Util.DUMMY_UUID);
						}
					}
				} else if (((((sourceentity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).crest)).equals("Dominic m"))) {
					if ((((new Random()).nextInt((int) 99 + 1)) <= 9)) {
						(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
								.setDamage((int) (((((sourceentity instanceof LivingEntity)
										? ((LivingEntity) sourceentity).getHeldItemMainhand()
										: ItemStack.EMPTY)).getDamage()) + 6));
						if (!world.isRemote()) {
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Crest FIX"), ChatType.SYSTEM, Util.DUMMY_UUID);
						}
					}
				}
			}
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.AIR.asItem())) {
				sourceentity.getPersistentData().putDouble("brawl", 1);
			}
		}
	}
}
