package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.item.TriggerItem;
import net.mcreator.worldtriggercraft.item.RedTriggerItem;
import net.mcreator.worldtriggercraft.item.RaycastItem;
import net.mcreator.worldtriggercraft.item.GreenTriggerItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggeractivationProcedure extends WorldtriggercraftModElements.ModElement {
	public TriggeractivationProcedure(WorldtriggercraftModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Triggeractivation!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Triggeractivation!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack slot0 = ItemStack.EMPTY;
		ItemStack slot1 = ItemStack.EMPTY;
		ItemStack slot3 = ItemStack.EMPTY;
		ItemStack slot2 = ItemStack.EMPTY;
		ItemStack triggershapeItem = ItemStack.EMPTY;
		double triggershape = 0;
		double subtriggershape = 0;
		double triggercolor = 0;
		double trioncost = 0;
		String customName = "";
		if ((!(world.getWorld().isRemote))) {
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(TriggerItem.block, (int) (1)).getItem())
					|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(RedTriggerItem.block, (int) (1)).getItem())
							|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getItem() == new ItemStack(GreenTriggerItem.block, (int) (1)).getItem())))) {
				triggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getDouble("triggerShape"));
				subtriggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getDouble("subtriggerShape"));
				triggercolor = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getDouble("triggercolor"));
				customName = (String) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getDisplayName().getString());
				slot0 = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(0) : ItemStack.EMPTY);
				slot1 = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(1) : ItemStack.EMPTY);
				slot2 = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(2) : ItemStack.EMPTY);
				slot3 = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(3) : ItemStack.EMPTY);
				if (((triggershape) == 1)) {
					triggershapeItem = new ItemStack(RaycastItem.block, (int) (1));
					trioncost = (double) 21;
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new StringTextComponent("set triggershape"));
					}
				} else if (((triggershape) == 2)) {
					triggershapeItem = new ItemStack(RaycastItem.block, (int) (1));
					trioncost = (double) 16;
				} else if (((triggershape) == 3)) {
					triggershapeItem = new ItemStack(RaycastItem.block, (int) (1));
					trioncost = (double) 11;
				}
				if (((entity.getPersistentData().getDouble("trion")) >= (trioncost))) {
					entity.getPersistentData().putBoolean("trionBody", (true));
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						$_dependencies.put("world", world);
						TriggerONAnoucementProcedure.executeProcedure($_dependencies);
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (triggershapeItem);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					entity.getPersistentData().putDouble("trion", ((entity.getPersistentData().getDouble("trion")) - ((trioncost) - 1)));
					entity.getPersistentData().putBoolean("bailoutActive", (true));
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.setDisplayName(new StringTextComponent((customName)));
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.putDouble("triggerShape", (triggershape));
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.putDouble("subtriggerShape", (subtriggershape));
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.putDouble("triggercolor", (triggercolor));
					{
						ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						final ItemStack _setstack = (slot0);
						final int _sltid = (int) (0);
						_setstack.setCount((int) 1);
						_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
					{
						ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						final ItemStack _setstack = (slot1);
						final int _sltid = (int) (1);
						_setstack.setCount((int) 1);
						_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
					{
						ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						final ItemStack _setstack = (slot2);
						final int _sltid = (int) (2);
						_setstack.setCount((int) 1);
						_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
					{
						ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						final ItemStack _setstack = (slot3);
						final int _sltid = (int) (3);
						_setstack.setCount((int) 1);
						_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						SubTriggerSummonProcedure.executeProcedure($_dependencies);
					}
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						ArmourSwitchToTrionbodyProcedure.executeProcedure($_dependencies);
					}
				}
			} else if ((ItemTags.getCollection()
					.getOrCreate(new ResourceLocation(("worldtriggercraft:trigger_tag").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					TriggerOFFProcedure.executeProcedure($_dependencies);
				}
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("called triggeroff"));
				}
			}
		}
	}
}
