package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModVariables;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class TrionSyncProcedure extends WorldtriggercraftModElements.ModElement {
	public TrionSyncProcedure(WorldtriggercraftModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TrionSync!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TrionSync!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getWorld().isRemote))) {
			{
				double _setval = (double) (entity.getPersistentData().getDouble("trion"));
				entity.getCapability(WorldtriggercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.trionsync = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (entity.getPersistentData().getDouble("maxtrion"));
				entity.getCapability(WorldtriggercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.maxtrionsync = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
