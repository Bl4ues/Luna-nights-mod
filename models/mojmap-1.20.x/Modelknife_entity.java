// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelknife_entity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "knife_entity"), "main");
	private final ModelPart knife;

	public Modelknife_entity(ModelPart root) {
		this.knife = root.getChild("knife");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition knife = partdefinition.addOrReplaceChild("knife",
				CubeListBuilder.create().texOffs(9, 5)
						.addBox(-0.45F, 12.25F, 17.0F, 1.0F, 1.5F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-0.45F, 12.5F, 18.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(7, 2)
						.addBox(0.05F, 12.5F, 11.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 3.0F, -17.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		knife.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}