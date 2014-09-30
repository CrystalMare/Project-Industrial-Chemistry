package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.network.PacketHandler;
import net.heavencraft.industrialchemistry.network.packet.PacketGrinder;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.util.Point;

public class ContainerMachineGrinder extends BaseContainer
{
	private TEMachineGrinder machineGrinder;
	
	private static Point offset = Textures.GUI.ChemicalFurnace.InventoryOffset;
	private static Point inputSlot = Textures.GUI.ChemicalFurnace.InputSlot;
	private static Point outputSlot = Textures.GUI.ChemicalFurnace.OutputSlot;
	
	private int lastInteralEnergy = 0;
	private int lastTimeLeftToProgress = 0;
		
	public ContainerMachineGrinder(InventoryPlayer player, TEMachineGrinder tile)
	{
		this.machineGrinder = tile;
		this.drawInv(player, 0, 78);
		addSlot(tile, 0, inputSlot.getX(), inputSlot.getY());
		addSlot(tile, 1, outputSlot.getX(), outputSlot.getY());
	}

	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
	    return null;
    }
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		boolean send = false;
		if(machineGrinder != null)
		{
			if(lastInteralEnergy != machineGrinder.getInternalEnergy())
			{
				lastInteralEnergy = machineGrinder.getInternalEnergy();
				send = true;
			}
			if(lastTimeLeftToProgress != machineGrinder.getTimeLeftToProcess())
			{
				lastTimeLeftToProgress = machineGrinder.getTimeLeftToProcess();
				send = true;
			}
		}
		
		if(send)
		{
			for (int i = 0; i < this.crafters.size(); ++i)
			{				
				if (this.crafters.get(i) instanceof EntityPlayerMP)
				{
					PacketHandler.INSTANCE.sendTo(new PacketGrinder(machineGrinder), (EntityPlayerMP) this.crafters.get(i));
				}
			}
		}
		
	}
	
}
