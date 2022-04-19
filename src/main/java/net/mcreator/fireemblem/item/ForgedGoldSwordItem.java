
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
public class ForgedGoldSwordItem extends FireEmblemModElements.ModElement {
	@ObjectHolder("fire_emblem:forged_gold_sword")
	public static final Item block = null;

	public ForgedGoldSwordItem(FireEmblemModElements instance) {
		super(instance, 145);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 82;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 24;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLD_INGOT));
			}
		}, 3, -2.2f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("forged_gold_sword"));
	}
}
