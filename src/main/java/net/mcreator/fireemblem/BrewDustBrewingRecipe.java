
package net.mcreator.fireemblem;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.fireemblem.item.CrushedDustItem;

@FireEmblemModElements.ModElement.Tag
public class BrewDustBrewingRecipe extends FireEmblemModElements.ModElement {
	public BrewDustBrewingRecipe(FireEmblemModElements instance) {
		super(instance, 45);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(Items.POTION)),
				Ingredient.fromStacks(new ItemStack(CrushedDustItem.block)), new ItemStack(Items.GLASS_BOTTLE));
	}
}
