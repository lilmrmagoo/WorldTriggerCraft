package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.worldtriggercraft.item.TraineeSuitItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class ArmourSwitchToTrionbodyProcedure extends WorldtriggercraftModElements.ModElement {
	public ArmourSwitchToTrionbodyProcedure(WorldtriggercraftModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ArmourSwitchToTrionbody!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(3, new ItemStack(Blocks.AIR, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(2, new ItemStack(TraineeSuitItem.body, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(1, new ItemStack(TraineeSuitItem.legs, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(0, new ItemStack(TraineeSuitItem.boots, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */
	}
}
