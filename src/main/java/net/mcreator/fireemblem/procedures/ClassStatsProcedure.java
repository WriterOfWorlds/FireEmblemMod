package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.fireemblem.item.SilverSwordItem;
import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;
import java.util.HashMap;

public class ClassStatsProcedure {
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
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure ClassStats!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Myrmidon"))) {
			if ((((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_SWORD)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SilverSwordItem.block))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Fighter"))) {
			if (((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BOW)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CROSSBOW))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
					.asItem())) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Mercenary"))) {
			if ((((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_SWORD)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SilverSwordItem.block))) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Thief"))) {
			if ((((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_SWORD)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SilverSwordItem.block))) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BOW)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CROSSBOW))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Brigand"))) {
			if (((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
					.asItem())) {
				{
					double _setval = (double) 2;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("AK"))) {
			{
				double _setval = (double) 2;
				entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.heavyarmor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Archer"))) {
			if ((((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_SWORD)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_SWORD))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SilverSwordItem.block))) {
				{
					double _setval = (double) 1;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BOW)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CROSSBOW))) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (((((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)).equals("Brawler"))) {
			if (((((((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.WOODEN_AXE)
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.STONE_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.GOLDEN_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.DIAMOND_AXE))
					|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.NETHERITE_AXE))) {
				{
					double _setval = (double) 2;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
					.asItem())) {
				{
					double _setval = (double) 3;
					entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.atk = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
