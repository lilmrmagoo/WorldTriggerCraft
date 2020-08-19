package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class TestDisplayOverlayIngameProcedure extends WorldtriggercraftModElements.ModElement {
	public TestDisplayOverlayIngameProcedure(WorldtriggercraftModElements instance) {
		super(instance, 44);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TestDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean bodyactive = false;
		return ((entity.getPersistentData().getBoolean("trionBody")) == (true));
	}
}
