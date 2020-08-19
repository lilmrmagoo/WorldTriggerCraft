package net.mcreator.worldtriggercraft.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.worldtriggercraft.item.TriggerCircuitItem;
import net.mcreator.worldtriggercraft.item.TriggerChipRaycastItem;
import net.mcreator.worldtriggercraft.WorldtriggercraftModElements;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@WorldtriggercraftModElements.ModElement.Tag
public class TriggerCraftingAssembleProcedure extends WorldtriggercraftModElements.ModElement {
	public TriggerCraftingAssembleProcedure(WorldtriggercraftModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TriggerCraftingAssemble!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure TriggerCraftingAssemble!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((ItemTags.getCollection().getOrCreate(new ResourceLocation(("worldtriggercraft:triggercase_tag").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (1))).getItem()))) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("assemble case detecded"));
			}
			if (((new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (10))).getItem() == new ItemStack(TriggerCircuitItem.block, (int) (1)).getItem())) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("assemble case and chip detecd"));
				}
				if (((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (2))).getItem() == new ItemStack(TriggerChipRaycastItem.block, (int) (1)).getItem())) {
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new StringTextComponent("assemble raygust triggerd"));
					}
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						CoulouredTriggerCraftingProcedure.executeProcedure($_dependencies);
					}
					(new Object() {
						public ItemStack getItemStack(int sltid) {
							Entity _ent = entity;
							if (_ent instanceof ServerPlayerEntity) {
								Container _current = ((ServerPlayerEntity) _ent).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										return ((Slot) ((Map) invobj).get(sltid)).getStack();
									}
								}
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) (0))).getOrCreateTag().putDouble("triggerShape", 1);
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						SubTriggerCraftingAssembleProcedure.executeProcedure($_dependencies);
					}
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						OptTriggerCraftingAssembleProcedure.executeProcedure($_dependencies);
					}
					((new Object() {
						public ItemStack getItemStack(int sltid) {
							Entity _ent = entity;
							if (_ent instanceof ServerPlayerEntity) {
								Container _current = ((ServerPlayerEntity) _ent).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										return ((Slot) ((Map) invobj).get(sltid)).getStack();
									}
								}
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) (0)))).setDisplayName(new StringTextComponent((new Object() {
						public String getText() {
							TextFieldWidget textField = (TextFieldWidget) guistate.get("text:Name");
							if (textField != null) {
								return textField.getText();
							}
							return "";
						}
					}.getText())));
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						ResourceGuiRemoveProcedure.executeProcedure($_dependencies);
					}
				}
			}
		}
	}
}
