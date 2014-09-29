package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class ContainerTesting extends ContainerPIC
{
	private TETestingBlock testingTE;
	
	public ContainerTesting(InventoryPlayer player, TETestingBlock tile)
	{
		this.testingTE = tile;
		this.drawInv(player);
	}

	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
	    return null;
    }
}
