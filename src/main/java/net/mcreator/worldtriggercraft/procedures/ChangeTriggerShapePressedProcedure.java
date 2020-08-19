package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class ChangeTriggerShapePressedProcedure extends WorldtriggercraftModElements.ModElement {
	public ChangeTriggerShapePressedProcedure(WorldtriggercraftModElements instance) {
		super(instance, 50);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ChangeTriggerShapePressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((ItemTags.getCollection().getOrCreate(new ResourceLocation(("scorpion_triggers").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ScorpionShapeChangeProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
