package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.item.SilverSwordItem;
import net.mcreator.fireemblem.item.SilverAxeItem;
import net.mcreator.fireemblem.item.RelicSwordItem;
import net.mcreator.fireemblem.item.MagicRelicItem;
import net.mcreator.fireemblem.item.HammorItem;
import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class StatIncProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerCriticalHit(CriticalHitEvent event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			double i = sourceentity.getPosX();
			double j = sourceentity.getPosY();
			double k = sourceentity.getPosZ();
			World world = sourceentity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("damagemodifier", event.getDamageModifier());
			dependencies.put("isvanillacritical", event.isVanillaCritical());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure StatInc!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StatInc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
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
			{
				double _setval = (double) (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).sword) + 1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sword = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
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
						.getItem() == Items.NETHERITE_AXE))
				|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == SilverAxeItem.block))) {
			{
				double _setval = (double) (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).axe) + 1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.axe = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BOW)
				|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.CROSSBOW))) {
			{
				double _setval = (double) (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).bow) + 1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.bow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == RelicSwordItem.block)
				|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == HammorItem.block))
				|| (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == MagicRelicItem.block))) {
			{
				double _setval = (double) (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new FireEmblemModVariables.PlayerVariables())).magic) + 1);
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.magic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
