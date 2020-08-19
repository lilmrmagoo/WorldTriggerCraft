
package net.mcreator.worldtriggercraft.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.worldtriggercraft.procedures.TestDisplayOverlayIngameProcedure;
import net.mcreator.worldtriggercraft.WorldtriggercraftModVariables;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import com.google.common.collect.ImmutableMap;

@WorldtriggercraftModElements.ModElement.Tag
public class TrionDisplayOverlay extends WorldtriggercraftModElements.ModElement {
	public TrionDisplayOverlay(WorldtriggercraftModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.posX;
			double y = entity.posY;
			double z = entity.posZ;
			if (TestDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString(""
						+ (int) ((entity.getCapability(WorldtriggercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new WorldtriggercraftModVariables.PlayerVariables())).trionsync)
						+ "/" + (int) ((entity.getCapability(WorldtriggercraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new WorldtriggercraftModVariables.PlayerVariables())).maxtrionsync)
						+ "", posX + -136, posY + -33, -1);
				Minecraft.getInstance().fontRenderer.drawString(
						"" + (entity.getPersistentData().getDouble("trion")) + "/" + (entity.getPersistentData().getDouble("maxtrion")) + "",
						posX + -119, posY + -15, -1);
			}
		}
	}
}
