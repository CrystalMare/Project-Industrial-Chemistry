package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.handlers.NewRecipeHandler;
import net.heavencraft.industrialchemistry.handlers.Recipe;
import net.heavencraft.industrialchemistry.network.PacketHandler;
import net.heavencraft.industrialchemistry.network.packet.PacketChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
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
	private int lastEnergyUsage = 0;
	private int lastTemp = 0;
	
	public ContainerMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		this.machineChemicalFurnaceTE = tile;
		addSlot(tile, 0, inputSlot.getX(), inputSlot.getY());
		addSlot(tile, 1, outputSlot.getX(), outputSlot.getY());
		this.drawInv(player, 0, 78);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
	{
		//WILL CLEAN IT UP SOON!
		ItemStack stackToTrans;
		stackToTrans = getSlot(slotIndex).getStack();
		ItemStack inputSlot = getSlot(0).getStack();
		Recipe recipe = NewRecipeHandler.getRecipe(TEMachineChemicalFurnace.class, CollectionUtils.getList(new Object[] { stackToTrans }));
		if (slotIndex == 1)
		{
			for (int i = 0; i < 35; i++)
			{
				stackToTrans = getSlot(slotIndex).getStack();
				inputSlot = getSlot(0).getStack();
				if (player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).isItemEqual(stackToTrans))
				{
					int maxsize = stackToTrans.getMaxStackSize();
					int stacksizeone = player.inventory.getStackInSlot(i).stackSize;
					int stacksizetwo = stackToTrans.stackSize;
					if (stackToTrans.getMaxStackSize() < player.inventory.getStackInSlot(i).stackSize + stackToTrans.stackSize)
					{
						int stackSizeBefore = player.inventory.getStackInSlot(i).stackSize;
						player.inventory.setInventorySlotContents(i, new ItemStack(player.inventory.getStackInSlot(i).getItem(), player.inventory.getStackInSlot(i).getMaxStackSize()));
						getSlot(1).putStack(new ItemStack(player.inventory.getStackInSlot(i).getItem(), stackSizeBefore));
					}
					else
					{
						player.inventory
						        .setInventorySlotContents(i, new ItemStack(player.inventory.getStackInSlot(i).getItem(), player.inventory.getStackInSlot(i).stackSize + stackToTrans.stackSize));
						getSlot(1).putStack(null);
						return null;
					}
				}
			}
			for (int i = 0; i < player.inventory.getSizeInventory(); i++)
			{
				if (player.inventory.getStackInSlot(i) == null)
				{
					player.inventory.setInventorySlotContents(i, stackToTrans);
					getSlot(1).putStack(null);
					return null;
				}
			}
			
			return null;
		}
		
		if (recipe != null && inputSlot != null)
		{
			if (inputSlot.isItemEqual(stackToTrans))
			{
				if (inputSlot.getMaxStackSize() < inputSlot.stackSize + stackToTrans.stackSize)
				{
					int stackSizeBefore = inputSlot.stackSize;
					getSlot(0).putStack(new ItemStack(inputSlot.getItem(), inputSlot.getMaxStackSize()));
					getSlot(slotIndex).putStack(new ItemStack(inputSlot.getItem(), stackSizeBefore));
					return null;
				}
				else
				{
					getSlot(0).putStack(new ItemStack(inputSlot.getItem(), inputSlot.stackSize + stackToTrans.stackSize));
					getSlot(slotIndex).putStack(null);
					
				}
			}
			else
			{
				return null;
			}
		}
		else if (recipe != null && inputSlot == null)
		{
			getSlot(0).putStack(stackToTrans.copy());
			getSlot(slotIndex).putStack(null);
		}
		return null;
	}
	
	@Override
	public ItemStack slotClick(int slotID, int p_75144_2_, int mode, EntityPlayer player)
	{
		if(player.inventory.getItemStack() != null && slotID == 1)
		{
			return null;
		}
	    return super.slotClick(slotID, p_75144_2_, mode, player);
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		boolean send = false;
		if (machineChemicalFurnaceTE != null)
		{
			if (lastInteralEnergy != machineChemicalFurnaceTE.getInternalEnergy())
			{
				lastInteralEnergy = machineChemicalFurnaceTE.getInternalEnergy();
				send = true;
			}
			if (lastTimeLeftToProgress != machineChemicalFurnaceTE.getTimeLeftToProcess())
			{
				lastTimeLeftToProgress = machineChemicalFurnaceTE.getTimeLeftToProcess();
				send = true;
			}
			if (lastEnergyUsage != machineChemicalFurnaceTE.getEnergyUsage())
			{
				lastEnergyUsage = machineChemicalFurnaceTE.getEnergyUsage();
				send = true;
			}
			if (lastTemp != machineChemicalFurnaceTE.getTemp())
			{
				lastTemp = machineChemicalFurnaceTE.getTemp();
				send = true;
			}
		}
		
		if (send)
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
