package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@WorldtriggercraftModElements.ModElement.Tag
public class BailoutProcedure extends WorldtriggercraftModElements.ModElement {
	public BailoutProcedure(WorldtriggercraftModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Bailout!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Bailout!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPersistentData().getDouble("trion")) <= 0)) {
			if ((entity.getPersistentData().getBoolean("bailoutactive"))) {
				if (((entity.getPersistentData().getDouble("playerspawny")) != 0)) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((entity.getPersistentData().getDouble("playerspawnx")),
								(entity.getPersistentData().getDouble("playerspawny")), (entity.getPersistentData().getDouble("playerspawnz")));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPersistentData().getDouble("playerspawnx")),
									(entity.getPersistentData().getDouble("playerspawny")), (entity.getPersistentData().getDouble("playerspawnz")),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				} else {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((world.getSpawnPoint().getX()), (world.getSpawnPoint().getY()), (world.getSpawnPoint().getZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((world.getSpawnPoint().getX()), (world.getSpawnPoint().getY()),
									(world.getSpawnPoint().getZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				}
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				TriggerOFFProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
