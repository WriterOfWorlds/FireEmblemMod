
package net.mcreator.fireemblem.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.fireemblem.procedures.CheckPage4Procedure;
import net.mcreator.fireemblem.procedures.CheckPage3Procedure;
import net.mcreator.fireemblem.procedures.CheckPage2Procedure;
import net.mcreator.fireemblem.procedures.CheckPage1Procedure;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class GoddessGuiWindow extends ContainerScreen<GoddessGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = GoddessGui.guistate;
	public GoddessGuiWindow(GoddessGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 84;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}
	private static final ResourceLocation texture = new ResourceLocation("fire_emblem:textures/goddess.png");
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
		if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "Sothis is the progenitor god of ", 5, 5, -12829636);
		if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "god of F\u00F3dlan, also known as The", 5, 15, -12829636);
		if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "Beginning. Provides a strength", 5, 25, -12829636);
		if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "blessing to her followers.", 5, 35, -12829636);
		if (CheckPage2Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "Ashera is the god of Order, she", 5, 5, -12829636);
		if (CheckPage2Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "provides a haste blessing to her", 5, 15, -12829636);
		if (CheckPage2Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "followers.", 5, 25, -12829636);
		if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "Yune is the Tellius godess of", 5, 5, -12829636);
		if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "of chaos, one half of the", 5, 15, -12829636);
		if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "goddess Ashunera, provides a", 5, 25, -12829636);
		if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "speed blessing to her followers.", 5, 35, -12829636);
		if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "Mila is the Earth Mother, and", 5, 5, -12829636);
		if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "the goddess of Valentia. She", 5, 15, -12829636);
		if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "provides a resistance blessing", 5, 25, -12829636);
		if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
			this.font.drawString(ms, "to her followers.", 5, 35, -12829636);
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
		this.addButton(new Button(this.guiLeft + 10, this.guiTop + 50, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(0, x, y, z));
				GoddessGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 135, this.guiTop + 50, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(1, x, y, z));
				GoddessGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 50, 55, 20, new StringTextComponent("Sothis"), e -> {
			if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(2, x, y, z));
				GoddessGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CheckPage1Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 50, 55, 20, new StringTextComponent("Ashera"), e -> {
			if (CheckPage2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(3, x, y, z));
				GoddessGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CheckPage2Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 50, 55, 20, new StringTextComponent("Yune"), e -> {
			if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(4, x, y, z));
				GoddessGui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CheckPage3Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + 50, 55, 20, new StringTextComponent("Mila"), e -> {
			if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new GoddessGui.ButtonPressedMessage(5, x, y, z));
				GoddessGui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CheckPage4Procedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
