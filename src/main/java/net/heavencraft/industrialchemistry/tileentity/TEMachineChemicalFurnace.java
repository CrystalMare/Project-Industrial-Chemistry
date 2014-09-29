package net.heavencraft.industrialchemistry.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.heavencraft.industrialchemistry.handlers.OldRecipeHandler;
import net.heavencraft.industrialchemistry.init.Blocks;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipe;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TEMachineChemicalFurnace extends BaseTEBlockPower
{
	private int rfPerTick = 10;
	private int timeLeftToProcess = 0;
	
	public TEMachineChemicalFurnace()
	{
		createInventory(2);
		recieveAllSides();
	}
	
	public boolean isProcessing()
	{
		return this.timeLeftToProcess > 0;
	}
	
	private boolean canProccess()
	{
		if (inventory[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack inputStack = inventory[0];
			ItemStack outputStack = inventory[1];
			MachineRecipeSimple recipe = OldRecipeHandler.getSimpleMachineRecipe(getClass(), inputStack);
			if (recipe.getOutput() == null) return false;
			if (outputStack == null) return true;
			ItemStack resultStack = recipe.getSimpleOutput(getClass());
			if (!outputStack.isItemEqual(resultStack)) return false;
			int result = outputStack.stackSize + resultStack.stackSize;
			return result <= getInventoryStackLimit() && result <= outputStack.getMaxStackSize();
		}
	}
	
	@Override
	public void updateEntity()
	{
		boolean save = false;
		if (!this.worldObj.isRemote)
		{
			if (getWorldObj().getBlockPowerInput(xCoord, yCoord, zCoord) > 0)
			{
				setMachineState(MachineState.ON);
			}
			else
			{
				setMachineState(MachineState.OFF);
			}
			
			if (getInternalEnergy() > 0)
			{
				useEnergy(rfPerTick);
			}
			else
			{
				state = MachineState.OFF;
			}
			
			if (state == MachineState.ON)
			{
				ItemStack stackInput = inventory[0];
				if (stackInput != null)
				{
					MachineRecipe recipe = OldRecipeHandler.getSimpleMachineRecipe(getClass(), stackInput);
					if (recipe != null)
					{
						if (isProcessing() && canProccess())
						{
							if (this.timeLeftToProcess <= 1)
							{
								this.timeLeftToProcess = 0;
								this.smeltItem();
								save = true;
							}
							else
							{
								--timeLeftToProcess;
							}
						}
						else
						{
							this.timeLeftToProcess = recipe.getProccessTime();
						}
					}
				}
				else
				{
					timeLeftToProcess = 0;
				}
			}
		}
		if (save)
		{
			this.markDirty();
		}
	}
	
	public void smeltItem()
	{
		if (this.canProccess())
		{
			ItemStack stackInput = inventory[0];
			ItemStack stackOutput = inventory[1];
			MachineRecipeSimple recipe = OldRecipeHandler.getSimpleMachineRecipe(getClass(), stackInput);
			ItemStack resultStack = recipe.getSimpleOutput(getClass());
			if (stackOutput == null)
			{
				setInventorySlotContents(1, resultStack.copy());
			}
			else if (stackOutput.getItem() == resultStack.getItem())
			{
				setInventorySlotContents(1, new ItemStack(resultStack.getItem(), resultStack.stackSize + stackOutput.stackSize));
			}
			
			--stackInput.stackSize;
			
			if (stackInput.stackSize <= 0)
			{
				setInventorySlotContents(0, null);
			}
		}
	}
	
	public int getTimeLeftToProcess()
	{
		return timeLeftToProcess;
	}
	
	public void setTimeLeftToProcess(int value)
	{
		timeLeftToProcess = value;
	}
	
	@SideOnly(Side.CLIENT)
	public double getProgress()
	{
		ItemStack stackInput = inventory[0];
		if (stackInput != null && timeLeftToProcess != 0)
		{
			MachineRecipeSimple recipe = OldRecipeHandler.getSimpleMachineRecipe(getClass(), stackInput);
			return (double)(recipe.getProccessTime() - timeLeftToProcess) / recipe.getProccessTime();
		}
		return 0;
	}
		
}
