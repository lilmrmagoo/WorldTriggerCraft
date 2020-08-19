
package net.mcreator.worldtriggercraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import com.mojang.blaze3d.platform.GlStateManager;

@WorldtriggercraftModElements.ModElement.Tag
public class TraineeSuitItem extends WorldtriggercraftModElements.ModElement {
	@ObjectHolder("worldtriggercraft:trainee_suit_helmet")
	public static final Item helmet = null;
	@ObjectHolder("worldtriggercraft:trainee_suit_chestplate")
	public static final Item body = null;
	@ObjectHolder("worldtriggercraft:trainee_suit_leggings")
	public static final Item legs = null;
	@ObjectHolder("worldtriggercraft:trainee_suit_boots")
	public static final Item boots = null;
	public TraineeSuitItem(WorldtriggercraftModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "trainee_suit";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(null)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedBody = new ModeltraineeSuit().field_78115_e;
				armorModel.bipedLeftArm = new ModeltraineeSuit().field_178724_i;
				armorModel.bipedRightArm = new ModeltraineeSuit().field_178723_h;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "worldtriggercraft:textures/traineemale.png";
			}
		}.setRegistryName("trainee_suit_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(null)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedLeftLeg = new ModeltraineeSuit().field_178722_k;
				armorModel.bipedRightLeg = new ModeltraineeSuit().field_178721_j;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "worldtriggercraft:textures/traineemale.png";
			}
		}.setRegistryName("trainee_suit_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(null)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel();
				armorModel.bipedLeftLeg = new ModeltraineeSuit().bootl;
				armorModel.bipedRightLeg = new ModeltraineeSuit().bootr;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "worldtriggercraft:textures/traineemale.png";
			}
		}.setRegistryName("trainee_suit_boots"));
	}
	/**
	 * traineeSuit - lilmrmagoo Created using Tabula 7.1.0
	 */
	public static class ModeltraineeSuit extends EntityModel<Entity> {
		public RendererModel field_178721_j;
		public RendererModel bootl;
		public RendererModel bootr;
		public RendererModel field_178722_k;
		public RendererModel field_178723_h;
		public RendererModel field_78115_e;
		public RendererModel field_178724_i;
		public ModeltraineeSuit() {
			this.textureWidth = 64;
			this.textureHeight = 64;
			this.bootr = new RendererModel(this, 0, 22);
			this.bootr.setRotationPoint(-1.9F, 18.0F, 0.1F);
			this.bootr.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
			this.bootl = new RendererModel(this, 16, 54);
			this.bootl.setRotationPoint(1.9F, 18.0F, 0.1F);
			this.bootl.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
			this.field_178722_k = new RendererModel(this, 16, 48);
			this.field_178722_k.setRotationPoint(1.9F, 12.0F, 0.1F);
			this.field_178722_k.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
			this.field_178724_i = new RendererModel(this, 32, 48);
			this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
			this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
			this.setRotateAngle(field_178724_i, 0.0F, 0.0F, -0.10000736613927509F);
			this.field_78115_e = new RendererModel(this, 16, 16);
			this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
			this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
			this.field_178723_h = new RendererModel(this, 40, 16);
			this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
			this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
			this.setRotateAngle(field_178723_h, 0.0F, 0.0F, 0.10000736613927509F);
			this.field_178721_j = new RendererModel(this, 0, 16);
			this.field_178721_j.setRotationPoint(-1.9F, 12.0F, 0.1F);
			this.field_178721_j.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.bootr.offsetX, this.bootr.offsetY, this.bootr.offsetZ);
			GlStateManager.translated(this.bootr.rotationPointX * f5, this.bootr.rotationPointY * f5, this.bootr.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.bootr.offsetX, -this.bootr.offsetY, -this.bootr.offsetZ);
			GlStateManager.translated(-this.bootr.rotationPointX * f5, -this.bootr.rotationPointY * f5, -this.bootr.rotationPointZ * f5);
			this.bootr.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.bootl.offsetX, this.bootl.offsetY, this.bootl.offsetZ);
			GlStateManager.translated(this.bootl.rotationPointX * f5, this.bootl.rotationPointY * f5, this.bootl.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.bootl.offsetX, -this.bootl.offsetY, -this.bootl.offsetZ);
			GlStateManager.translated(-this.bootl.rotationPointX * f5, -this.bootl.rotationPointY * f5, -this.bootl.rotationPointZ * f5);
			this.bootl.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.field_178722_k.offsetX, this.field_178722_k.offsetY, this.field_178722_k.offsetZ);
			GlStateManager.translated(this.field_178722_k.rotationPointX * f5, this.field_178722_k.rotationPointY * f5,
					this.field_178722_k.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.field_178722_k.offsetX, -this.field_178722_k.offsetY, -this.field_178722_k.offsetZ);
			GlStateManager.translated(-this.field_178722_k.rotationPointX * f5, -this.field_178722_k.rotationPointY * f5,
					-this.field_178722_k.rotationPointZ * f5);
			this.field_178722_k.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.field_178724_i.offsetX, this.field_178724_i.offsetY, this.field_178724_i.offsetZ);
			GlStateManager.translated(this.field_178724_i.rotationPointX * f5, this.field_178724_i.rotationPointY * f5,
					this.field_178724_i.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.field_178724_i.offsetX, -this.field_178724_i.offsetY, -this.field_178724_i.offsetZ);
			GlStateManager.translated(-this.field_178724_i.rotationPointX * f5, -this.field_178724_i.rotationPointY * f5,
					-this.field_178724_i.rotationPointZ * f5);
			this.field_178724_i.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.field_78115_e.offsetX, this.field_78115_e.offsetY, this.field_78115_e.offsetZ);
			GlStateManager.translated(this.field_78115_e.rotationPointX * f5, this.field_78115_e.rotationPointY * f5,
					this.field_78115_e.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.field_78115_e.offsetX, -this.field_78115_e.offsetY, -this.field_78115_e.offsetZ);
			GlStateManager.translated(-this.field_78115_e.rotationPointX * f5, -this.field_78115_e.rotationPointY * f5,
					-this.field_78115_e.rotationPointZ * f5);
			this.field_78115_e.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.field_178723_h.offsetX, this.field_178723_h.offsetY, this.field_178723_h.offsetZ);
			GlStateManager.translated(this.field_178723_h.rotationPointX * f5, this.field_178723_h.rotationPointY * f5,
					this.field_178723_h.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.field_178723_h.offsetX, -this.field_178723_h.offsetY, -this.field_178723_h.offsetZ);
			GlStateManager.translated(-this.field_178723_h.rotationPointX * f5, -this.field_178723_h.rotationPointY * f5,
					-this.field_178723_h.rotationPointZ * f5);
			this.field_178723_h.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.field_178721_j.offsetX, this.field_178721_j.offsetY, this.field_178721_j.offsetZ);
			GlStateManager.translated(this.field_178721_j.rotationPointX * f5, this.field_178721_j.rotationPointY * f5,
					this.field_178721_j.rotationPointZ * f5);
			GlStateManager.scaled(1.01D, 1.01D, 1.01D);
			GlStateManager.translated(-this.field_178721_j.offsetX, -this.field_178721_j.offsetY, -this.field_178721_j.offsetZ);
			GlStateManager.translated(-this.field_178721_j.rotationPointX * f5, -this.field_178721_j.rotationPointY * f5,
					-this.field_178721_j.rotationPointZ * f5);
			this.field_178721_j.render(f5);
			GlStateManager.popMatrix();
		}

		/**
		 * This is a helper function from Tabula to set the rotation of model parts
		 */
		public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
