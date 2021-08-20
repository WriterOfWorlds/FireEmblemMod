package net.mcreator.fireemblem.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.fireemblem.FireEmblemModElements;

import java.lang.reflect.Method;

@FireEmblemModElements.ModElement.Tag
public class CrestGameRule extends FireEmblemModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("crest", GameRules.Category.PLAYER, create(0));
	public CrestGameRule(FireEmblemModElements instance) {
		super(instance, 164);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
