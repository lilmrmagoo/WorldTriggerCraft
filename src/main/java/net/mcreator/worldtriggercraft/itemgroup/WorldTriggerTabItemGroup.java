
package net.mcreator.worldtriggercraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.worldtriggercraft.item.TriggercaseBlackItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

@WorldtriggercraftModElements.ModElement.Tag
public class WorldTriggerTabItemGroup extends WorldtriggercraftModElements.ModElement {
	public WorldTriggerTabItemGroup(WorldtriggercraftModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabworld_trigger_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TriggercaseBlackItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
