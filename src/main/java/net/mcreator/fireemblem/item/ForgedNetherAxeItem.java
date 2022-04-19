
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
public class ForgedNetherAxeItem extends FireEmblemModElements.ModElement {
	@ObjectHolder("fire_emblem:forged_nether_axe")
	public static final Item block = null;

	public ForgedNetherAxeItem(FireEmblemModElements instance) {
		super(instance, 150);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2081;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 8.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 17;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.NETHERITE_SCRAP), new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 3, -2.7999999999999998f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("forged_nether_axe"));
	}
}
