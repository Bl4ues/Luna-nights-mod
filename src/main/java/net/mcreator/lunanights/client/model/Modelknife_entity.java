package net.mcreator.lunanights.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelknife_entity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("luna_nights", "modelknife_entity"), "main");
	public final ModelPart knife;

	public Modelknife_entity(ModelPart root) {
		this.knife = root.getChild("knife");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition knife = partdefinition.addOrReplaceChild("knife", CubeListBuilder.create().texOffs(9, 5).addBox(-0.5F, -0.75F, -0.1667F, 1.0F, 1.5F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
				.addBox(-0.5F, -0.5F, 0.8333F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(7, 2).addBox(0.0F, -0.5F, -6.1667F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.05F, 16.0F, 0.1667F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		knife.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.knife.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.knife.xRot = headPitch / (180F / (float) Math.PI);
	}
}
