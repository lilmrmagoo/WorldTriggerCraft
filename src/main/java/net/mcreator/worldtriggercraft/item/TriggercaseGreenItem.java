
package net.mcreator.worldtriggercraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggercaseGreenItem extends WorldtriggercraftModElements.ModElement {
	@ObjectHolder("worldtriggercraft:triggercase_green")
	public static final Item block = null;
	public TriggercaseGreenItem(WorldtriggercraftModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("triggercase_green");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
