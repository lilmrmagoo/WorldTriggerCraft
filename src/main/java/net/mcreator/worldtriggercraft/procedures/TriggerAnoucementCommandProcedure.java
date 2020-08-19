package net.mcreator.worldtriggercraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.WorldtriggercraftModVariables;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggerAnoucementCommandProcedure extends WorldtriggercraftModElements.ModElement {
	public TriggerAnoucementCommandProcedure(WorldtriggercraftModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TriggerAnoucementCommand!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure TriggerAnoucementCommand!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TriggerAnoucementCommand!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("true"))) {
			WorldtriggercraftModVariables.MapVariables.get(world).triggerONAnoucement = (boolean) (true);
			WorldtriggercraftModVariables.MapVariables.get(world).syncData(world);
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("false"))) {
			WorldtriggercraftModVariables.MapVariables.get(world).triggerONAnoucement = (boolean) (false);
			WorldtriggercraftModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("\u00A74 \"\u00A7r\u00A7n") + "" + ((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())) + "" + ("\u00A74\" is an invalid option please use either true or false"))), (false));
			}
		}
	}
}
