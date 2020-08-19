package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@WorldtriggercraftModElements.ModElement.Tag
public class PlayerupdateProcedure extends WorldtriggercraftModElements.ModElement {
	public PlayerupdateProcedure(WorldtriggercraftModElements instance) {
		super(instance, 43);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Playerupdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Playerupdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("trion ") + "" + ((entity.getPersistentData().getDouble("trion")))
					+ "" + (" /") + "" + ((entity.getPersistentData().getDouble("maxtrion"))) + "" + (" ") + ""
					+ (TestDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))))), (true));
		}
		if (((entity.getPersistentData().getDouble("maxtrion")) <= 0)) {
			entity.getPersistentData().putDouble("maxtrion", 100);
		}
		if ((((entity.getPersistentData().getDouble("trionregen")) >= 20)
				&& ((entity.getPersistentData().getDouble("trion")) < (entity.getPersistentData().getDouble("maxtrion"))))) {
			entity.getPersistentData().putDouble("trion", ((entity.getPersistentData().getDouble("trion")) + 1));
			entity.getPersistentData().putDouble("trionregen", 0);
		} else {
			entity.getPersistentData().putDouble("trionregen", ((entity.getPersistentData().getDouble("trionregen")) + 1));
		}
		if ((entity.getPersistentData().getBoolean("trionBody"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				TrionSyncProcedure.executeProcedure($_dependencies);
			}
		}
		if (((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) || (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayerEntity) {
					return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.ADVENTURE;
				} else if (_ent instanceof PlayerEntity && _ent.world.isRemote) {
					NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
							.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
					return _npi != null && _npi.getGameType() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)))) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.disableDamage = (entity.getPersistentData().getBoolean("trionBody"));
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.posX;
			double j = entity.posY;
			double k = entity.posZ;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
