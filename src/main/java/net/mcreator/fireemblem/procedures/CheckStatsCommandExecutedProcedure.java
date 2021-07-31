package net.mcreator.fireemblem.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.fireemblem.FireEmblemModVariables;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.Map;

public class CheckStatsCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency entity for procedure CheckStatsCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FireEmblemMod.LOGGER.warn("Failed to load dependency world for procedure CheckStatsCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent(
										(("Sword: ") + ""
												+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireEmblemModVariables.PlayerVariables())).sword)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent(
										(("Axe: ") + ""
												+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireEmblemModVariables.PlayerVariables())).axe)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent(
										(("Bow: ") + ""
												+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireEmblemModVariables.PlayerVariables())).bow)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent(
										(("Magic: ") + ""
												+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireEmblemModVariables.PlayerVariables())).magic)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent(
										(("Brawl: ") + ""
												+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new FireEmblemModVariables.PlayerVariables())).brawl)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent((("Health: ") + "" + (((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH).getBaseValue()))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent(
								(("Attack: ") + "" + (((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue()))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(
						new StringTextComponent(
								(("Attack Speed: ") + "" + (((LivingEntity) entity).getAttribute(Attributes.ATTACK_SPEED).getBaseValue()))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.func_232641_a_(
								new StringTextComponent((("Class: ") + ""
										+ (((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass)))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
