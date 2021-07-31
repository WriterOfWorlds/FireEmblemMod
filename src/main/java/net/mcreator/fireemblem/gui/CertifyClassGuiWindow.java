
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

import net.mcreator.fireemblem.procedures.ClassSelectProcedure;
import net.mcreator.fireemblem.procedures.CertifyThiefProcedure;
import net.mcreator.fireemblem.procedures.CertifyArcherProcedure;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class CertifyClassGuiWindow extends ContainerScreen<CertifyClassGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CertifyClassGui.guistate;
	public CertifyClassGuiWindow(CertifyClassGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}
	private static final ResourceLocation texture = new ResourceLocation("fire_emblem:textures/certify_class.png");
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
		this.font.drawString(ms, "Swordsman", 7, 11, -12829636);
		this.font.drawString(ms, "Archer", 95, 11, -12829636);
		this.font.drawString(ms, "Thief", 8, 57, -12829636);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 24, 60, 20, new StringTextComponent("Certify"), e -> {
			if (ClassSelectProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new CertifyClassGui.ButtonPressedMessage(0, x, y, z));
				CertifyClassGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ClassSelectProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 93, this.guiTop + 24, 60, 20, new StringTextComponent("Certify"), e -> {
			if (CertifyArcherProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new CertifyClassGui.ButtonPressedMessage(1, x, y, z));
				CertifyClassGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CertifyArcherProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 73, 60, 20, new StringTextComponent("Certify"), e -> {
			if (CertifyThiefProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new CertifyClassGui.ButtonPressedMessage(2, x, y, z));
				CertifyClassGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CertifyThiefProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
