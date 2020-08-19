package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.item.TraineeSuitItem;
import net.mcreator.worldtriggercraft.item.ScorpionKazamaItem;
import net.mcreator.worldtriggercraft.item.ScorpionDefaultItem;
import net.mcreator.worldtriggercraft.item.RaycastItem;
import net.mcreator.worldtriggercraft.item.KogetsuItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class ClearAllTriggersProcedure extends WorldtriggercraftModElements.ModElement {
	public ClearAllTriggersProcedure(WorldtriggercraftModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ClearAllTriggers!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(RaycastItem.block, (int) (1)).getItem() == p.getItem(), (int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(KogetsuItem.block, (int) (1)).getItem() == p.getItem(), (int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(ScorpionDefaultItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(ScorpionKazamaItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(TraineeSuitItem.body, (int) (1)).getItem() == p.getItem(),
					(int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(TraineeSuitItem.legs, (int) (1)).getItem() == p.getItem(),
					(int) 64);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(TraineeSuitItem.boots, (int) (1)).getItem() == p.getItem(),
					(int) 64);
	}
}
