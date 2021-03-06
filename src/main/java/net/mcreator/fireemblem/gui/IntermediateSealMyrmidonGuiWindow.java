
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

import net.mcreator.fireemblem.procedures.CertifyThiefProcedure;
import net.mcreator.fireemblem.procedures.CertifyMercenaryProcedure;
import net.mcreator.fireemblem.FireEmblemMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class IntermediateSealMyrmidonGuiWindow extends ContainerScreen<IntermediateSealMyrmidonGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = IntermediateSealMyrmidonGui.guistate;

	public IntermediateSealMyrmidonGuiWindow(IntermediateSealMyrmidonGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 182;
		this.ySize = 134;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("fire_emblem:textures/intermediate_seal_myrmidon.png");

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
		this.font.drawString(ms, "Mercenary", 13, 13, -12829636);
		this.font.drawString(ms, "Thief", 97, 14, -12829636);
		this.font.drawString(ms, ".", 10, 28, -12829636);
		this.font.drawString(ms, "Sword C+", 15, 30, -12829636);
		this.font.drawString(ms, ".", 92, 28, -12829636);
		this.font.drawString(ms, "Sword C+", 98, 30, -12829636);
		this.font.drawString(ms, "Intermediate Classes ", 35, 94, -12829636);
		this.font.drawString(ms, "Myrmidon Path", 53, 105, -12829636);
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
		this.addButton(new Button(this.guiLeft + 10, this.guiTop + 50, 60, 20, new StringTextComponent("Certify"), e -> {
			if (CertifyMercenaryProcedure.executeProcedure(ImmutableMap.<String, Object>builder().put("entity", entity).build())) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new IntermediateSealMyrmidonGui.ButtonPressedMessage(0, x, y, z));
				IntermediateSealMyrmidonGui.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CertifyMercenaryProcedure.executeProcedure(ImmutableMap.<String, Object>builder().put("entity", entity).build()))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 50, 60, 20, new StringTextComponent("Certify"), e -> {
			if (CertifyThiefProcedure.executeProcedure(ImmutableMap.<String, Object>builder().put("entity", entity).build())) {
				FireEmblemMod.PACKET_HANDLER.sendToServer(new IntermediateSealMyrmidonGui.ButtonPressedMessage(1, x, y, z));
				IntermediateSealMyrmidonGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (CertifyThiefProcedure.executeProcedure(ImmutableMap.<String, Object>builder().put("entity", entity).build()))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
