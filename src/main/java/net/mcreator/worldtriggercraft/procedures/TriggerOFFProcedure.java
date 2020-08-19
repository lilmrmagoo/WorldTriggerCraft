package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.worldtriggercraft.item.TriggerItem;
import net.mcreator.worldtriggercraft.item.RedTriggerItem;
import net.mcreator.worldtriggercraft.item.GreenTriggerItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggerOFFProcedure extends WorldtriggercraftModElements.ModElement {
	public TriggerOFFProcedure(WorldtriggercraftModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TriggerOFF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double triggershape = 0;
		double subtriggershape = 0;
		double triggercolor = 0;
		ItemStack slot0 = ItemStack.EMPTY;
		ItemStack slot1 = ItemStack.EMPTY;
		ItemStack slot2 = ItemStack.EMPTY;
		ItemStack slot3 = ItemStack.EMPTY;
		String name = "";
		triggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getDouble("triggerShape"));
		subtriggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getOrCreateTag().getDouble("subtriggerShape"));
		triggercolor = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.getDouble("triggercolor"));
		name = (String) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getDisplayName()
				.getString());
		slot0 = (new Object() {
			public ItemStack getItemStack(int sltid, ItemStack _isc) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (0), ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)));
		slot1 = (new Object() {
			public ItemStack getItemStack(int sltid, ItemStack _isc) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (1), ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)));
		slot2 = (new Object() {
			public ItemStack getItemStack(int sltid, ItemStack _isc) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (2), ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)));
		slot3 = (new Object() {
			public ItemStack getItemStack(int sltid, ItemStack _isc) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (3), ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)));
		if (((triggercolor) == 0)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(TriggerItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		} else if (((triggercolor) == 2)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(GreenTriggerItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		} else if (((triggercolor) == 3)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(RedTriggerItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
		if ((ItemTags.getCollection().getOrCreate(new ResourceLocation(("worldtriggercraft:trigger_tag").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			ClearAllTriggersProcedure.executeProcedure($_dependencies);
		}
		entity.getPersistentData().putBoolean("trionBody", (false));
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
				.setDisplayName(new StringTextComponent((name)));
		entity.getPersistentData().putBoolean("bailoutActive", (false));
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putDouble("triggerShape", (triggershape));
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putDouble("subtriggerShape", (subtriggershape));
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putDouble("triggercolor", (triggercolor));
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(0, (slot0));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(1, (slot1));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(2, (slot2));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).inventory.armorInventory.set(3, (slot3));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		/* @ItemStack */ {
			ItemStack _isc = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
			final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
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
			final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
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
			final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
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
			final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
			final int _sltid = (int) (3);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
