package net.mcreator.fireemblem.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.fireemblem.entity.PegasusEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PegasusRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PegasusEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelpegasus(), 2f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("fire_emblem:textures/download_3_1.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelpegasus extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer TailA;
		private final ModelRenderer TailB;
		private final ModelRenderer TailC;
		private final ModelRenderer Leg1A;
		private final ModelRenderer Leg1B;
		private final ModelRenderer Leg1C;
		private final ModelRenderer Leg2A;
		private final ModelRenderer Leg2B;
		private final ModelRenderer Leg2C;
		private final ModelRenderer Leg3A;
		private final ModelRenderer Leg3B;
		private final ModelRenderer Leg3C;
		private final ModelRenderer Leg4A;
		private final ModelRenderer Leg4B;
		private final ModelRenderer Leg4C;
		private final ModelRenderer Head;
		private final ModelRenderer UMouth;
		private final ModelRenderer LMouth;
		private final ModelRenderer Ear1;
		private final ModelRenderer Ear2;
		private final ModelRenderer MuleEarL;
		private final ModelRenderer MuleEarR;
		private final ModelRenderer Neck;
		private final ModelRenderer Bag1;
		private final ModelRenderer Bag2;
		private final ModelRenderer Saddle;
		private final ModelRenderer SaddleB;
		private final ModelRenderer SaddleC;
		private final ModelRenderer SaddleL2;
		private final ModelRenderer SaddleL;
		private final ModelRenderer SaddleR2;
		private final ModelRenderer SaddleR;
		private final ModelRenderer SaddleMouthL;
		private final ModelRenderer SaddleMouthR;
		private final ModelRenderer SaddleMouthLine;
		private final ModelRenderer SaddleMouthLineR;
		private final ModelRenderer Mane;
		private final ModelRenderer HeadSaddle;
		private final ModelRenderer WingL;
		private final ModelRenderer bottom_r1;
		private final ModelRenderer WingR;
		private final ModelRenderer bottom_r2;
		public Modelpegasus() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 11.0F, 9.0F);
			Body.setTextureOffset(0, 34).addBox(-5.0F, -8.0F, -19.0F, 10.0F, 10.0F, 24.0F, 0.0F, true);
			TailA = new ModelRenderer(this);
			TailA.setRotationPoint(0.0F, 3.0F, 14.0F);
			setRotationAngle(TailA, -1.1345F, 0.0F, 0.0F);
			TailA.setTextureOffset(44, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, true);
			TailB = new ModelRenderer(this);
			TailB.setRotationPoint(0.0F, 3.0F, 14.0F);
			setRotationAngle(TailB, -1.1345F, 0.0F, 0.0F);
			TailB.setTextureOffset(38, 7).addBox(-1.5F, -2.0F, 3.0F, 3.0F, 4.0F, 7.0F, 0.0F, true);
			TailC = new ModelRenderer(this);
			TailC.setRotationPoint(0.0F, 3.0F, 14.0F);
			setRotationAngle(TailC, -1.4022F, 0.0F, 0.0F);
			TailC.setTextureOffset(24, 3).addBox(-1.5F, -4.5F, 9.0F, 3.0F, 4.0F, 7.0F, 0.0F, true);
			Leg1A = new ModelRenderer(this);
			Leg1A.setRotationPoint(-4.0F, 9.0F, 11.0F);
			Leg1A.setTextureOffset(78, 29).addBox(-1.5F, -2.0F, -2.5F, 4.0F, 9.0F, 5.0F, 0.0F, true);
			Leg1B = new ModelRenderer(this);
			Leg1B.setRotationPoint(-4.0F, 16.0F, 11.0F);
			Leg1B.setTextureOffset(78, 43).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);
			Leg1C = new ModelRenderer(this);
			Leg1C.setRotationPoint(-4.0F, 16.0F, 11.0F);
			Leg1C.setTextureOffset(78, 51).addBox(-1.5F, 5.1F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Leg2A = new ModelRenderer(this);
			Leg2A.setRotationPoint(4.0F, 9.0F, 11.0F);
			Leg2A.setTextureOffset(96, 29).addBox(-2.5F, -2.0F, -2.5F, 4.0F, 9.0F, 5.0F, 0.0F, true);
			Leg2B = new ModelRenderer(this);
			Leg2B.setRotationPoint(4.0F, 16.0F, 11.0F);
			Leg2B.setTextureOffset(96, 43).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, true);
			Leg2C = new ModelRenderer(this);
			Leg2C.setRotationPoint(4.0F, 16.0F, 11.0F);
			Leg2C.setTextureOffset(96, 51).addBox(-2.5F, 5.1F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Leg3A = new ModelRenderer(this);
			Leg3A.setRotationPoint(-4.0F, 9.0F, -8.0F);
			Leg3A.setTextureOffset(44, 29).addBox(-1.1F, -1.0F, -2.1F, 3.0F, 8.0F, 4.0F, 0.0F, true);
			Leg3B = new ModelRenderer(this);
			Leg3B.setRotationPoint(-4.0F, 16.0F, -8.0F);
			Leg3B.setTextureOffset(44, 41).addBox(-1.1F, 0.0F, -1.6F, 3.0F, 5.0F, 3.0F, 0.0F, true);
			Leg3C = new ModelRenderer(this);
			Leg3C.setRotationPoint(-4.0F, 16.0F, -8.0F);
			Leg3C.setTextureOffset(44, 51).addBox(-1.6F, 5.1F, -2.1F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Leg4A = new ModelRenderer(this);
			Leg4A.setRotationPoint(4.0F, 9.0F, -8.0F);
			Leg4A.setTextureOffset(60, 29).addBox(-1.9F, -1.0F, -2.1F, 3.0F, 8.0F, 4.0F, 0.0F, true);
			Leg4B = new ModelRenderer(this);
			Leg4B.setRotationPoint(4.0F, 16.0F, -8.0F);
			Leg4B.setTextureOffset(60, 41).addBox(-1.9F, 0.0F, -1.6F, 3.0F, 5.0F, 3.0F, 0.0F, true);
			Leg4C = new ModelRenderer(this);
			Leg4C.setRotationPoint(4.0F, 16.0F, -8.0F);
			Leg4C.setTextureOffset(60, 51).addBox(-2.4F, 5.1F, -2.1F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(Head, 0.5236F, 0.0F, 0.0F);
			Head.setTextureOffset(0, 0).addBox(-2.5F, -10.0F, -1.5F, 5.0F, 5.0F, 7.0F, 0.0F, true);
			UMouth = new ModelRenderer(this);
			UMouth.setRotationPoint(0.0F, 3.95F, -10.0F);
			setRotationAngle(UMouth, 0.5236F, 0.0F, 0.0F);
			UMouth.setTextureOffset(24, 18).addBox(-2.0F, -10.0F, -7.0F, 4.0F, 3.0F, 6.0F, 0.0F, true);
			LMouth = new ModelRenderer(this);
			LMouth.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(LMouth, 0.5236F, 0.0F, 0.0F);
			LMouth.setTextureOffset(24, 27).addBox(-2.0F, -7.0F, -6.5F, 4.0F, 2.0F, 5.0F, 0.0F, true);
			Ear1 = new ModelRenderer(this);
			Ear1.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(Ear1, 0.5236F, 0.0F, 0.0F);
			Ear1.setTextureOffset(0, 0).addBox(-2.45F, -12.0F, 4.0F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			Ear2 = new ModelRenderer(this);
			Ear2.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(Ear2, 0.5236F, 0.0F, 0.0F);
			Ear2.setTextureOffset(0, 0).addBox(0.45F, -12.0F, 4.0F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			MuleEarL = new ModelRenderer(this);
			MuleEarL.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(MuleEarL, 0.5236F, 0.0F, 0.2618F);
			MuleEarL.setTextureOffset(0, 12).addBox(0.0F, -16.0F, 4.0F, 2.0F, 7.0F, 1.0F, 0.0F, true);
			MuleEarR = new ModelRenderer(this);
			MuleEarR.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(MuleEarR, 0.5236F, 0.0F, -0.2618F);
			MuleEarR.setTextureOffset(0, 12).addBox(-2.0F, -16.0F, 4.0F, 2.0F, 7.0F, 1.0F, 0.0F, true);
			Neck = new ModelRenderer(this);
			Neck.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(Neck, 0.5236F, 0.0F, 0.0F);
			Neck.setTextureOffset(0, 12).addBox(-1.95F, -9.8F, -2.0F, 4.0F, 14.0F, 8.0F, 0.0F, true);
			Bag1 = new ModelRenderer(this);
			Bag1.setRotationPoint(7.5F, 3.0F, 10.0F);
			setRotationAngle(Bag1, 0.0F, 1.5708F, 0.0F);
			Bag2 = new ModelRenderer(this);
			Bag2.setRotationPoint(-4.5F, 3.0F, 10.0F);
			setRotationAngle(Bag2, 0.0F, -1.5708F, 0.0F);
			Saddle = new ModelRenderer(this);
			Saddle.setRotationPoint(0.0F, 2.0F, 2.0F);
			Saddle.setTextureOffset(80, 0).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 1.0F, 8.0F, 0.0F, true);
			SaddleB = new ModelRenderer(this);
			SaddleB.setRotationPoint(0.0F, 2.0F, 2.0F);
			SaddleB.setTextureOffset(106, 9).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 2.0F, 0.0F, true);
			SaddleC = new ModelRenderer(this);
			SaddleC.setRotationPoint(0.0F, 2.0F, 2.0F);
			SaddleC.setTextureOffset(80, 9).addBox(-4.0F, -1.0F, 3.0F, 8.0F, 1.0F, 2.0F, 0.0F, true);
			SaddleL2 = new ModelRenderer(this);
			SaddleL2.setRotationPoint(-5.0F, 3.0F, 2.0F);
			SaddleL2.setTextureOffset(74, 0).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
			SaddleL = new ModelRenderer(this);
			SaddleL.setRotationPoint(-5.0F, 3.0F, 2.0F);
			SaddleL.setTextureOffset(70, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
			SaddleR2 = new ModelRenderer(this);
			SaddleR2.setRotationPoint(5.0F, 3.0F, 2.0F);
			SaddleR2.setTextureOffset(74, 4).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
			SaddleR = new ModelRenderer(this);
			SaddleR.setRotationPoint(5.0F, 3.0F, 2.0F);
			SaddleR.setTextureOffset(80, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, true);
			SaddleMouthL = new ModelRenderer(this);
			SaddleMouthL.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(SaddleMouthL, 0.5236F, 0.0F, 0.0F);
			SaddleMouthL.setTextureOffset(74, 13).addBox(-2.5F, -8.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
			SaddleMouthR = new ModelRenderer(this);
			SaddleMouthR.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(SaddleMouthR, 0.5236F, 0.0F, 0.0F);
			SaddleMouthR.setTextureOffset(74, 13).addBox(1.5F, -8.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
			SaddleMouthLine = new ModelRenderer(this);
			SaddleMouthLine.setRotationPoint(0.0F, 4.0F, -10.0F);
			SaddleMouthLine.setTextureOffset(44, 10).addBox(-2.6F, -6.0F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, true);
			SaddleMouthLineR = new ModelRenderer(this);
			SaddleMouthLineR.setRotationPoint(0.0F, 4.0F, -10.0F);
			SaddleMouthLineR.setTextureOffset(44, 5).addBox(2.6F, -6.0F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, true);
			Mane = new ModelRenderer(this);
			Mane.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(Mane, 0.5236F, 0.0F, 0.0F);
			Mane.setTextureOffset(58, 0).addBox(-1.0F, -11.5F, 5.0F, 2.0F, 16.0F, 4.0F, 0.0F, true);
			HeadSaddle = new ModelRenderer(this);
			HeadSaddle.setRotationPoint(0.0F, 4.0F, -10.0F);
			setRotationAngle(HeadSaddle, 0.5236F, 0.0F, 0.0F);
			HeadSaddle.setTextureOffset(80, 12).addBox(-2.5F, -10.1F, -7.0F, 5.0F, 5.0F, 12.0F, 0.05F, true);
			WingL = new ModelRenderer(this);
			WingL.setRotationPoint(0.0F, 4.0F, -12.0F);
			setRotationAngle(WingL, -0.1723F, 0.017F, -0.1813F);
			bottom_r1 = new ModelRenderer(this);
			bottom_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			WingL.addChild(bottom_r1);
			setRotationAngle(bottom_r1, 0.0F, 0.3491F, 0.48F);
			bottom_r1.setTextureOffset(34, 68).addBox(-15.0F, -1.0F, 6.0F, 13.0F, 5.0F, 1.0F, 0.0F, false);
			bottom_r1.setTextureOffset(0, 68).addBox(-24.0F, -11.0F, 6.0F, 16.0F, 10.0F, 1.0F, 0.0F, false);
			WingR = new ModelRenderer(this);
			WingR.setRotationPoint(0.0F, 4.0F, -12.0F);
			setRotationAngle(WingR, -0.1723F, -0.017F, 0.1813F);
			bottom_r2 = new ModelRenderer(this);
			bottom_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			WingR.addChild(bottom_r2);
			setRotationAngle(bottom_r2, 0.0F, -0.3491F, -0.48F);
			bottom_r2.setTextureOffset(34, 68).addBox(2.0F, -1.0F, 6.0F, 13.0F, 5.0F, 1.0F, 0.0F, true);
			bottom_r2.setTextureOffset(0, 68).addBox(8.0F, -11.0F, 6.0F, 16.0F, 10.0F, 1.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			TailA.render(matrixStack, buffer, packedLight, packedOverlay);
			TailB.render(matrixStack, buffer, packedLight, packedOverlay);
			TailC.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg1A.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg1B.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg1C.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg2A.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg2B.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg2C.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg3A.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg3B.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg3C.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg4A.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg4B.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg4C.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			UMouth.render(matrixStack, buffer, packedLight, packedOverlay);
			LMouth.render(matrixStack, buffer, packedLight, packedOverlay);
			Ear1.render(matrixStack, buffer, packedLight, packedOverlay);
			Ear2.render(matrixStack, buffer, packedLight, packedOverlay);
			MuleEarL.render(matrixStack, buffer, packedLight, packedOverlay);
			MuleEarR.render(matrixStack, buffer, packedLight, packedOverlay);
			Neck.render(matrixStack, buffer, packedLight, packedOverlay);
			Bag1.render(matrixStack, buffer, packedLight, packedOverlay);
			Bag2.render(matrixStack, buffer, packedLight, packedOverlay);
			Saddle.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleB.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleC.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleL2.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleL.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleR2.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleR.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleMouthL.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleMouthR.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleMouthLine.render(matrixStack, buffer, packedLight, packedOverlay);
			SaddleMouthLineR.render(matrixStack, buffer, packedLight, packedOverlay);
			Mane.render(matrixStack, buffer, packedLight, packedOverlay);
			HeadSaddle.render(matrixStack, buffer, packedLight, packedOverlay);
			WingL.render(matrixStack, buffer, packedLight, packedOverlay);
			WingR.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Leg1A.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Leg3C.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Leg1B.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.SaddleMouthLine.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.SaddleMouthLine.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg3A.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Leg3B.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.SaddleMouthR.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.SaddleMouthR.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.UMouth.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.UMouth.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Mane.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Mane.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.SaddleMouthL.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.SaddleMouthL.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Ear1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Ear1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Neck.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Neck.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Ear2.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Ear2.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.SaddleMouthLineR.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.SaddleMouthLineR.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg2B.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg2C.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg4B.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg2A.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg4C.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg4A.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.HeadSaddle.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HeadSaddle.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LMouth.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.LMouth.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.WingL.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.WingR.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg1C.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
