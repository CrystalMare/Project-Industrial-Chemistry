package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.network.PacketHandler;
import net.heavencraft.industrialchemistry.network.packet.PacketGrinder;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.util.Point;

public class ContainerMachineGrinder extends BaseContainer
{
	private TEMachineGrinder machineGrinder;
	
	private static Point offset = Textures.GUI.Grinder.InventoryOffset;
	private static Point inputSlot = Textures.GUI.Grinder.InputSlot;
	private static Point outputSlot = Textures.GUI.Grinder.OutputSlot;
	private static Point outputSlot2 = Textures.GUI.Grinder.OutputSlot2;
	private static Point powerSlot = Textures.GUI.Grinder.PowerSlot;
	
	private int lastInteralEnergy = 0;
	private int lastTimeLeftToProgress = 0;
		
	public ContainerMachineGrinder(InventoryPlayer player, TEMachineGrinder tile)
	{
		drawInv(player, offset.getX(), offset.getY());
		addSlot(machineGrinder, 0, inputSlot.getX(), inputSlot.getY());
		addBigSlot(machineGrinder, 1, outputSlot.getX(), outputSlot.getY());
		addSlot(machineGrinder, 2, outputSlot2.getX(), outputSlot2.getY());
		addSlot(machineGrinder, 3, powerSlot.getX(), powerSlot.getY());
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
		
		if(!send)
			return;
		
		for(Object obj : crafters)
		{
			if (obj instanceof EntityPlayerMP)
				PacketHandler.INSTANCE.sendTo(new PacketGrinder(machineGrinder),  (EntityPlayerMP) obj);
		}
	}
}
