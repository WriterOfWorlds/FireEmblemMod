
package net.mcreator.fireemblem.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.fireemblem.FireEmblemModElements;

@FireEmblemModElements.ModElement.Tag
public class ForgedDiamondAxeItem extends FireEmblemModElements.ModElement {
	@ObjectHolder("fire_emblem:forged_diamond_axe")
	public static final Item block = null;

	public ForgedDiamondAxeItem(FireEmblemModElements instance) {
		super(instance, 148);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1611;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 7.5f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.DIAMOND));
			}
		}, 3, -2.8f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("forged_diamond_axe"));
	}
}
