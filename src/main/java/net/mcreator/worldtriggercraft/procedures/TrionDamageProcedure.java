package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class TrionDamageProcedure extends WorldtriggercraftModElements.ModElement {
	public TrionDamageProcedure(WorldtriggercraftModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TrionDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double damage = 0;
		damage = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
		if (((entity.getPersistentData().getBoolean("trionBody")) && (((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getHealth()
				: -1) < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)))) {
			entity.getPersistentData().putDouble("trion", ((entity.getPersistentData().getDouble("trion")) - ((damage) * 2.5)));
		}
	}
}
