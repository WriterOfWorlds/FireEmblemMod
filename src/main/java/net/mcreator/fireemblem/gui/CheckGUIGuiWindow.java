
package net.mcreator.fireemblem.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.fireemblem.FireEmblemModVariables;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CheckGUIGuiWindow extends ContainerScreen<CheckGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CheckGUIGui.guistate;
	public CheckGUIGuiWindow(CheckGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 180;
		this.ySize = 115;
	}
	private static final ResourceLocation texture = new ResourceLocation("fire_emblem:textures/check_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Sword: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).sword) + "", 8, 10, -12829636);
		this.font.drawString(ms, "Axe: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).axe) + "", 8, 20, -12829636);
		this.font.drawString(ms, "Magic: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).magic) + "", 8, 30, -12829636);
		this.font.drawString(ms, "Bow: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).bow) + "", 8, 40, -12829636);
		this.font.drawString(ms, "Brawl: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).brawl) + "", 8, 51, -12829636);
		this.font.drawString(ms, "Heavy Armor: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).heavyarmor) + "", 8, 62, -12829636);
		this.font.drawString(ms, "Attack: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).atk) + "", 8, 73, -12829636);
		this.font.drawString(ms, "Player Stats", 108, 16, -12829636);
		this.font.drawString(ms, "Class: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).playerclass) + "", 8, 98, -12829636);
		this.font.drawString(ms, "Crest: " + ((entity.getCapability(FireEmblemModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new FireEmblemModVariables.PlayerVariables())).crest) + "", 8, 88, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
