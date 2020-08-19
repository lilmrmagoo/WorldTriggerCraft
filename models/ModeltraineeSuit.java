
/**
 * traineeSuit - lilmrmagoo Created using Tabula 7.1.0
 */
public static class ModeltraineeSuit extends ModelBase {
	public ModelRenderer field_178721_j;
	public ModelRenderer bootl;
	public ModelRenderer bootr;
	public ModelRenderer field_178722_k;
	public ModelRenderer field_178723_h;
	public ModelRenderer field_78115_e;
	public ModelRenderer field_178724_i;

	public ModeltraineeSuit() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.bootr = new ModelRenderer(this, 0, 22);
		this.bootr.setRotationPoint(-1.9F, 18.0F, 0.1F);
		this.bootr.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.bootl = new ModelRenderer(this, 16, 54);
		this.bootl.setRotationPoint(1.9F, 18.0F, 0.1F);
		this.bootl.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.field_178722_k = new ModelRenderer(this, 16, 48);
		this.field_178722_k.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.field_178722_k.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.field_178724_i = new ModelRenderer(this, 32, 48);
		this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(field_178724_i, 0.0F, 0.0F, -0.10000736613927509F);
		this.field_78115_e = new ModelRenderer(this, 16, 16);
		this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.field_178723_h = new ModelRenderer(this, 40, 16);
		this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(field_178723_h, 0.0F, 0.0F, 0.10000736613927509F);
		this.field_178721_j = new ModelRenderer(this, 0, 16);
		this.field_178721_j.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.field_178721_j.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.bootr.offsetX, this.bootr.offsetY, this.bootr.offsetZ);
		GlStateManager.translate(this.bootr.rotationPointX * f5, this.bootr.rotationPointY * f5,
				this.bootr.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.bootr.offsetX, -this.bootr.offsetY, -this.bootr.offsetZ);
		GlStateManager.translate(-this.bootr.rotationPointX * f5, -this.bootr.rotationPointY * f5,
				-this.bootr.rotationPointZ * f5);
		this.bootr.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.bootl.offsetX, this.bootl.offsetY, this.bootl.offsetZ);
		GlStateManager.translate(this.bootl.rotationPointX * f5, this.bootl.rotationPointY * f5,
				this.bootl.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.bootl.offsetX, -this.bootl.offsetY, -this.bootl.offsetZ);
		GlStateManager.translate(-this.bootl.rotationPointX * f5, -this.bootl.rotationPointY * f5,
				-this.bootl.rotationPointZ * f5);
		this.bootl.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.field_178722_k.offsetX, this.field_178722_k.offsetY, this.field_178722_k.offsetZ);
		GlStateManager.translate(this.field_178722_k.rotationPointX * f5, this.field_178722_k.rotationPointY * f5,
				this.field_178722_k.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.field_178722_k.offsetX, -this.field_178722_k.offsetY,
				-this.field_178722_k.offsetZ);
		GlStateManager.translate(-this.field_178722_k.rotationPointX * f5, -this.field_178722_k.rotationPointY * f5,
				-this.field_178722_k.rotationPointZ * f5);
		this.field_178722_k.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.field_178724_i.offsetX, this.field_178724_i.offsetY, this.field_178724_i.offsetZ);
		GlStateManager.translate(this.field_178724_i.rotationPointX * f5, this.field_178724_i.rotationPointY * f5,
				this.field_178724_i.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.field_178724_i.offsetX, -this.field_178724_i.offsetY,
				-this.field_178724_i.offsetZ);
		GlStateManager.translate(-this.field_178724_i.rotationPointX * f5, -this.field_178724_i.rotationPointY * f5,
				-this.field_178724_i.rotationPointZ * f5);
		this.field_178724_i.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.field_78115_e.offsetX, this.field_78115_e.offsetY, this.field_78115_e.offsetZ);
		GlStateManager.translate(this.field_78115_e.rotationPointX * f5, this.field_78115_e.rotationPointY * f5,
				this.field_78115_e.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.field_78115_e.offsetX, -this.field_78115_e.offsetY, -this.field_78115_e.offsetZ);
		GlStateManager.translate(-this.field_78115_e.rotationPointX * f5, -this.field_78115_e.rotationPointY * f5,
				-this.field_78115_e.rotationPointZ * f5);
		this.field_78115_e.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.field_178723_h.offsetX, this.field_178723_h.offsetY, this.field_178723_h.offsetZ);
		GlStateManager.translate(this.field_178723_h.rotationPointX * f5, this.field_178723_h.rotationPointY * f5,
				this.field_178723_h.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.field_178723_h.offsetX, -this.field_178723_h.offsetY,
				-this.field_178723_h.offsetZ);
		GlStateManager.translate(-this.field_178723_h.rotationPointX * f5, -this.field_178723_h.rotationPointY * f5,
				-this.field_178723_h.rotationPointZ * f5);
		this.field_178723_h.render(f5);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.field_178721_j.offsetX, this.field_178721_j.offsetY, this.field_178721_j.offsetZ);
		GlStateManager.translate(this.field_178721_j.rotationPointX * f5, this.field_178721_j.rotationPointY * f5,
				this.field_178721_j.rotationPointZ * f5);
		GlStateManager.scale(1.01D, 1.01D, 1.01D);
		GlStateManager.translate(-this.field_178721_j.offsetX, -this.field_178721_j.offsetY,
				-this.field_178721_j.offsetZ);
		GlStateManager.translate(-this.field_178721_j.rotationPointX * f5, -this.field_178721_j.rotationPointY * f5,
				-this.field_178721_j.rotationPointZ * f5);
		this.field_178721_j.render(f5);
		GlStateManager.popMatrix();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}
