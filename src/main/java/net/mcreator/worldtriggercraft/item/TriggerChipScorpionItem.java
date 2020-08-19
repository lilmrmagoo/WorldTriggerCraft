
package net.mcreator.worldtriggercraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.worldtriggercraft.itemgroup.WorldTriggerTabItemGroup;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggerChipScorpionItem extends WorldtriggercraftModElements.ModElement {
	@ObjectHolder("worldtriggercraft:trigger_chip_scorpion")
	public static final Item block = null;
	public TriggerChipScorpionItem(WorldtriggercraftModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WorldTriggerTabItemGroup.tab).maxStackSize(64));
			setRegistryName("trigger_chip_scorpion");
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
