package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class SetTrionCommandExecutedProcedure extends WorldtriggercraftModElements.ModElement {
	public SetTrionCommandExecutedProcedure(WorldtriggercraftModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SetTrionCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure SetTrionCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		entity.getPersistentData().putDouble("trion", new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())));
	}
}
