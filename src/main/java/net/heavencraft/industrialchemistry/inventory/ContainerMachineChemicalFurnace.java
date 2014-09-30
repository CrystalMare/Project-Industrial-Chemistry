package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.network.PacketHandler;
import net.heavencraft.industrialchemistry.network.packet.PacketChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.util.Point;

public class ContainerMachineChemicalFurnace extends BaseContainer
{
	private TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	private static Point offset = Textures.GUI.ChemicalFurnace.InventoryOffset;
	private static Point inputSlot = Textures.GUI.ChemicalFurnace.InputSlot;
	private static Point outputSlot = Textures.GUI.ChemicalFurnace.OutputSlot;	
	
	private int lastInteralEnergy = 0;
	private int lastTimeLeftToProgress = 0;
	
	public ContainerMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		this.machineChemicalFurnaceTE = tile;
		this.drawInv(player, 0, 78);
		addSlot(tile, 0, inputSlot.getX(), inputSlot.getY());
		addSlot(tile, 1, outputSlot.getX(), outputSlot.getY());
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
	{
		ItemStack inputSlot = machineChemicalFurnaceTE.getStackInSlot(0);
		return null;
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		boolean send = false;
		if(machineChemicalFurnaceTE != null)
		{
			if(lastInteralEnergy != machineChemicalFurnaceTE.getInternalEnergy())
			{
				lastInteralEnergy = machineChemicalFurnaceTE.getInternalEnergy();
				send = true;
			}
			if(lastTimeLeftToProgress != machineChemicalFurnaceTE.getTimeLeftToProcess())
			{
				lastTimeLeftToProgress = machineChemicalFurnaceTE.getTimeLeftToProcess();
				send = true;
			}
		}
		
		if(send)
		{
			for (int i = 0; i < this.crafters.size(); ++i)
			{				
				if (this.crafters.get(i) instanceof EntityPlayerMP)
				{
					PacketHandler.INSTANCE.sendTo(new PacketChemicalFurnace(machineChemicalFurnaceTE), (EntityPlayerMP) this.crafters.get(i));
				}
			}
		}
		
	}
}
