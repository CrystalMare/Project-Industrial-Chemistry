package net.heavencraft.industrialchemistry.inventory;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class BaseContainer extends Container
{
	public int InventoryRowsPlayer = 3;
	public int InventoryColumnsPlayer = 9;
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
	public void drawInv(InventoryPlayer player)
	{
		drawInv(player, 0, 0);
	}
	
	public void drawInv(InventoryPlayer inventory, int xOffset, int yOffset)
	{
		for (int row = 0; row < InventoryRowsPlayer; ++row)
		{
			for (int column = 0; column < InventoryColumnsPlayer; ++column)
			{
				addSlotToContainer(new Slot(inventory, column + row * 9 + 9, 8 + xOffset + column * 18, 84 + yOffset + row * 18));
			}
		}
		
		for (int slot = 0; slot < InventoryColumnsPlayer; ++slot)
		{
			addSlotToContainer(new Slot(inventory, slot, 8 + slot * 18 + xOffset, 142 + yOffset));
		}
	}
	
	public void addSlot(IInventory stack, int slotIndex, int x, int y)
	{
		addSlotToContainer(new Slot(stack, slotIndex, x, y));
	}
	
	@Override
    public abstract ItemStack transferStackInSlot(EntityPlayer player, int slotIndex);
	
	protected boolean mergeItemStack(ItemStack itemStack, int slotMin, int slotMax, boolean ascending)
	{
		boolean slotFound = false;
		int slotIndex = ascending ? slotMax - 1 : slotMin;
		
		Slot slot;
		ItemStack slotStack;
		
		if (itemStack.isStackable())
		{
			while (itemStack.stackSize > 0 && (!ascending && slotIndex < slotMax || ascending && slotIndex >= slotMin))
			{
				slot = (Slot) this.inventorySlots.get(slotIndex);
				slotStack = slot.getStack();
				
				if (slot.isItemValid(itemStack) && itemStack.getItem() == slotStack.getItem())
				{
					int combinedStackSize = slotStack.stackSize + itemStack.stackSize;
					int slotStackSizeLimit = Math.min(slotStack.getMaxStackSize(), slot.getSlotStackLimit());
					
					if (combinedStackSize <= slotStackSizeLimit)
					{
						itemStack.stackSize = 0;
						slotStack.stackSize = combinedStackSize;
						slot.onSlotChanged();
						slotFound = true;
					}
					else if (slotStack.stackSize < slotStackSizeLimit)
					{
						itemStack.stackSize -= slotStackSizeLimit - slotStack.stackSize;
						slotStack.stackSize = slotStackSizeLimit;
						slot.onSlotChanged();
						slotFound = true;
					}
				}
				
				slotIndex += ascending ? -1 : 1;
			}
		}
		
		if (itemStack.stackSize > 0)
		{
			slotIndex = ascending ? slotMax - 1 : slotMin;
			
			while (!ascending && slotIndex < slotMax || ascending && slotIndex >= slotMin)
			{
				slot = (Slot) this.inventorySlots.get(slotIndex);
				slotStack = slot.getStack();
				
				if (slot.isItemValid(itemStack) && slotStack == null)
				{
					slot.putStack(itemStack.copy());
					slot.onSlotChanged();
					
					if (slot.getStack() != null)
					{
						itemStack.stackSize -= slot.getStack().stackSize;
						slotFound = true;
					}
					
					break;
				}
				
				slotIndex += ascending ? -1 : 1;
			}
		}
		
		return slotFound;
	}
}