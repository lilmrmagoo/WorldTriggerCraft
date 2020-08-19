package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.item.ScorpionKazamaItem;
import net.mcreator.worldtriggercraft.item.ScorpionDefaultItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class ScorpionShapeChangeProcedure extends WorldtriggercraftModElements.ModElement {
	public ScorpionShapeChangeProcedure(WorldtriggercraftModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ScorpionShapeChange!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack slot0 = ItemStack.EMPTY;
		ItemStack slot1 = ItemStack.EMPTY;
		ItemStack slot2 = ItemStack.EMPTY;
		ItemStack slot3 = ItemStack.EMPTY;
		double triggershape = 0;
		double subtriggershape = 0;
		double triggercolor = 0;
		String customname = "";
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ScorpionDefaultItem.block, (int) (1)).getItem())) {
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
			subtriggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getOrCreateTag().getDouble("subtriggerShape"));
			triggercolor = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getOrCreateTag().getDouble("triggercolor"));
			customname = (String) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getDisplayName().getString());
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(ScorpionKazamaItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
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
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("triggerShape", 4);
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("triggercolor", (triggercolor));
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.setDisplayName(new StringTextComponent((customname)));
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ScorpionKazamaItem.block, (int) (1)).getItem())) {
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
			subtriggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getOrCreateTag().getDouble("subtriggerShape"));
			triggercolor = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getOrCreateTag().getDouble("triggercolor"));
			customname = (String) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getDisplayName().getString());
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(ScorpionDefaultItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
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
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("triggerShape", 3);
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("triggercolor", (triggercolor));
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.setDisplayName(new StringTextComponent((customname)));
		}
	}
}
