package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModVariables;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggerONAnoucementProcedure extends WorldtriggercraftModElements.ModElement {
	public TriggerONAnoucementProcedure(WorldtriggercraftModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TriggerONAnoucement!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TriggerONAnoucement!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((WorldtriggercraftModVariables.MapVariables.get(world).triggerONAnoucement)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.sendMessage(new StringTextComponent((("<") + "" + ((entity.getDisplayName().getString())) + "" + ("> Trigger ON!"))));
			}
		}
	}
}
