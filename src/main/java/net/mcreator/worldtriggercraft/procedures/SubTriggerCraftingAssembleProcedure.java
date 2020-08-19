package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.item.TriggerChipRaycastItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.function.Supplier;
import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class SubTriggerCraftingAssembleProcedure extends WorldtriggercraftModElements.ModElement {
	public SubTriggerCraftingAssembleProcedure(WorldtriggercraftModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SubTriggerCraftingAssemble!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (2))).getItem() == new ItemStack(TriggerChipRaycastItem.block, (int) (1)).getItem())) {
			(new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (0))).getOrCreateTag().putDouble("SubtriggerShape", 1);
		}
	}
}
