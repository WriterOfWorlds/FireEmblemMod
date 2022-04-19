
package net.mcreator.fireemblem.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.fireemblem.procedures.ThunderBrandGlowProcedure;
import net.mcreator.fireemblem.FireEmblemModElements;

import com.google.common.collect.ImmutableMap;

@FireEmblemModElements.ModElement.Tag
public class HammorItem extends FireEmblemModElements.ModElement {
	@ObjectHolder("fire_emblem:thunderbrand")
	public static final Item block = null;

	public HammorItem(FireEmblemModElements instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 225;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 8.5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.3f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				PlayerEntity entity = Minecraft.getInstance().player;
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (!(ThunderBrandGlowProcedure.executeProcedure(ImmutableMap.<String, Object>builder().put("entity", entity).build()))) {
					return false;
				}
				return true;
			}
		}.setRegistryName("thunderbrand"));
	}
}
