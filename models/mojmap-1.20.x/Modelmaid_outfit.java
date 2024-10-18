// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmaid_outfit<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "maid_outfit"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightBoot;
	private final ModelPart LeftBoot;

	public Modelmaid_outfit(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightBoot = root.getChild("RightBoot");
		this.LeftBoot = root.getChild("LeftBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(50, 28).addBox(
				-6.0F, -10.0F, -2.0F, 12.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(25, 28)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(0, 17)
						.addBox(-5.0F, 8.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition backlace_r1 = Body.addOrReplaceChild("backlace_r1",
				CubeListBuilder.create().texOffs(76, 0).addBox(0.0F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 3.1F, 0.0F, -0.6981F, 0.0F));

		PartDefinition backlace_r2 = Body.addOrReplaceChild("backlace_r2",
				CubeListBuilder.create().texOffs(43, 56).addBox(0.0F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 3.6F, 0.2935F, -0.2517F, -0.472F));

		PartDefinition backlace_r3 = Body.addOrReplaceChild("backlace_r3",
				CubeListBuilder.create().texOffs(66, 0).addBox(0.0F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, 3.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition backlace_r4 = Body.addOrReplaceChild("backlace_r4",
				CubeListBuilder.create().texOffs(29, 56).addBox(0.0F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, 3.5F, 0.2935F, -0.2517F, -0.472F));

		PartDefinition bow_r1 = Body.addOrReplaceChild("bow_r1",
				CubeListBuilder.create().texOffs(35, 73).mirror()
						.addBox(-4.0F, -2.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 3.5F, -2.2F, 0.0F, -0.2182F, 0.0F));

		PartDefinition lace_r1 = Body.addOrReplaceChild("lace_r1",
				CubeListBuilder.create().texOffs(17, 73).mirror()
						.addBox(-4.0F, -2.5F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 3.5F, -2.2F, 0.0F, -0.0873F, 0.0F));

		PartDefinition lace_r2 = Body
				.addOrReplaceChild("lace_r2",
						CubeListBuilder.create().texOffs(17, 73).addBox(0.0F, -2.5F, 0.0F, 4.0F, 6.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 3.5F, -2.2F, 0.0F, 0.0873F, 0.0F));

		PartDefinition lacetop_r1 = Body
				.addOrReplaceChild("lacetop_r1",
						CubeListBuilder.create().texOffs(35, 73).addBox(0.0F, -2.5F, 0.0F, 4.0F, 3.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 3.5F, -2.2F, 0.0F, 0.2182F, 0.0F));

		PartDefinition skirtside_r1 = Body.addOrReplaceChild("skirtside_r1",
				CubeListBuilder.create().texOffs(43, 0).addBox(-0.2819F, 0.6026F, -5.0F, 0.0F, 5.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.6F, 11.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition skirtside_r2 = Body.addOrReplaceChild("skirtside_r2",
				CubeListBuilder.create().texOffs(23, 0).mirror()
						.addBox(-0.2819F, 0.6026F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5F, 11.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition skirtthingy_r1 = Body
				.addOrReplaceChild("skirtthingy_r1",
						CubeListBuilder.create().texOffs(62, 20).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 12.0F, -3.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition skirtside_r3 = Body.addOrReplaceChild("skirtside_r3",
				CubeListBuilder.create().texOffs(43, 0).mirror()
						.addBox(0.2819F, 0.6026F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(4.6F, 11.5F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition skirtside_r4 = Body.addOrReplaceChild("skirtside_r4",
				CubeListBuilder.create().texOffs(23, 0).addBox(0.2819F, 0.6026F, -5.0F, 0.0F, 5.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 11.5F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition skirtback_r1 = Body
				.addOrReplaceChild("skirtback_r1",
						CubeListBuilder.create().texOffs(71, 35).addBox(-7.0F, -0.1F, 0.0F, 14.0F, 5.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 12.1F, 3.1F, 0.2618F, 0.0F, 0.0F));

		PartDefinition skirtback_r2 = Body
				.addOrReplaceChild("skirtback_r2",
						CubeListBuilder.create().texOffs(71, 23).addBox(-7.0F, -0.1F, 0.0F, 14.0F, 5.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 12.1F, 3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition skirtfront_r1 = Body.addOrReplaceChild("skirtfront_r1",
				CubeListBuilder.create().texOffs(85, 41).addBox(-7.0F, 0.25F, 0.0F, 14.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.75F, -3.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition skirtfront_r2 = Body.addOrReplaceChild("skirtfront_r2",
				CubeListBuilder.create().texOffs(71, 23).addBox(-7.0F, 0.25F, 0.0F, 14.0F, 5.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.75F, -2.9F, -0.3054F, 0.0F, 0.0F));

		PartDefinition backlace_r5 = Body.addOrReplaceChild("backlace_r5",
				CubeListBuilder.create().texOffs(29, 56).mirror()
						.addBox(-7.0F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 12.0F, 3.5F, 0.2935F, 0.2517F, 0.472F));

		PartDefinition backlace_r6 = Body.addOrReplaceChild("backlace_r6",
				CubeListBuilder.create().texOffs(76, 0).mirror()
						.addBox(-5.0F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 10.0F, 3.1F, 0.0F, 0.6981F, 0.0F));

		PartDefinition backlace_r7 = Body.addOrReplaceChild("backlace_r7",
				CubeListBuilder.create().texOffs(43, 56).mirror()
						.addBox(-7.0F, -4.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 12.0F, 3.6F, 0.2935F, 0.2517F, 0.472F));

		PartDefinition backlace_r8 = Body.addOrReplaceChild("backlace_r8",
				CubeListBuilder.create().texOffs(66, 0).mirror()
						.addBox(-5.0F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 10.0F, 3.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(44, 45)
				.addBox(-4.0F, -3.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition armdetail_r1 = RightArm.addOrReplaceChild(
				"armdetail_r1", CubeListBuilder.create().texOffs(62, 10).addBox(-0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F,
						8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.1F, 0.5F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition armdetail_r2 = RightArm.addOrReplaceChild("armdetail_r2",
				CubeListBuilder.create().texOffs(52, 57).mirror()
						.addBox(-0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.9F, 0.6F, 2.5F, 1.5708F, 1.3963F, 1.5708F));

		PartDefinition armdetail_r3 = RightArm.addOrReplaceChild("armdetail_r3",
				CubeListBuilder.create().texOffs(51, 66).mirror()
						.addBox(-0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-3.5F, 0.7F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition armdetail_r4 = RightArm.addOrReplaceChild("armdetail_r4",
				CubeListBuilder.create().texOffs(1, 62).addBox(-0.2819F, 0.6026F, -3.0F, 0.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.6F, -2.5F, -1.5708F, -1.3963F, 1.5708F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(21, 45)
				.addBox(-1.0F, -3.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.25F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition armdetail_r5 = LeftArm.addOrReplaceChild("armdetail_r5",
				CubeListBuilder.create().texOffs(62, 10).mirror()
						.addBox(0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.1F, 0.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition armdetail_r6 = LeftArm.addOrReplaceChild("armdetail_r6",
				CubeListBuilder.create().texOffs(52, 57).addBox(0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, 0.6F, 2.5F, 1.5708F, -1.3963F, -1.5708F));

		PartDefinition armdetail_r7 = LeftArm.addOrReplaceChild("armdetail_r7",
				CubeListBuilder.create().texOffs(1, 62).mirror()
						.addBox(0.2819F, 0.6026F, -3.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 0.6F, -2.5F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition armdetail_r8 = LeftArm.addOrReplaceChild(
				"armdetail_r8", CubeListBuilder.create().texOffs(51, 66).addBox(0.2819F, 0.6026F, -4.0F, 0.0F, 1.0F,
						8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, 0.7F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 71)
				.addBox(-1.9F, 4.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition RightBoot = partdefinition.addOrReplaceChild("RightBoot",
				CubeListBuilder.create().texOffs(68, 55).mirror()
						.addBox(-1.9F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition LeftBoot = partdefinition.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(68, 55)
				.addBox(-2.1F, 9.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}