package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.worldtriggercraft.item.RaycastItem;
import net.mcreator.worldtriggercraft.item.KogetsuItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.Map;

@WorldtriggercraftModElements.ModElement.Tag
public class SubTriggerSummonProcedure extends WorldtriggercraftModElements.ModElement {
	public SubTriggerSummonProcedure(WorldtriggercraftModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SubTriggerSummon!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack subtriggershapeitem = ItemStack.EMPTY;
		double trioncost = 0;
		double subtriggershape = 0;
		subtriggershape = (double) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getOrCreateTag().getDouble("subtriggershape"));
		if (((subtriggershape) == 1)) {
			subtriggershapeitem = new ItemStack(RaycastItem.block, (int) (1));
			trioncost = (double) 11;
		} else if (((subtriggershape) == 2)) {
			subtriggershapeitem = new ItemStack(KogetsuItem.block, (int) (1));
			trioncost = (double) 6;
		} else if (((subtriggershape) == 3)) {
			subtriggershapeitem = new ItemStack(RaycastItem.block, (int) (1));
			trioncost = (double) 4;
		}
		entity.getPersistentData().putDouble("trion", ((entity.getPersistentData().getDouble("trion")) - ((trioncost) - 1)));
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
			_setstack.setCount(
					(int) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount()));
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = (subtriggershapeitem);
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}
