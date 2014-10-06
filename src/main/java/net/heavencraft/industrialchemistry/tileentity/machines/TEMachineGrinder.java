package net.heavencraft.industrialchemistry.tileentity.machines;

import java.util.List;

import net.heavencraft.industrialchemistry.crafting.Recipe;
import net.heavencraft.industrialchemistry.crafting.RecipeComponent;
import net.heavencraft.industrialchemistry.crafting.RecipeRegistry;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEMachineGrinder extends BaseTEBlockPower
{
	private int timeLeftToProcess = 0;
	
	public TEMachineGrinder()
	{
		createInventory(4);
		this.rfPerTick = 10;
		recieveAllSides();
	}
	
	public boolean isProcessing()
	{
		return this.timeLeftToProcess > 0;
	}
	
	private boolean canProcess()
	{
		if (inventory[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack inputStack = inventory[0];
			ItemStack outputStack = inventory[1];
			
			Recipe recipe = RecipeRegistry.getRecipe(getClass(), CollectionUtils.getList(new Object[] { inventory[0] }));
			if (recipe == null) return false;
			if (outputStack == null) return true;
			
			ItemStack resultStack = recipe.getSimpleOutput().get(0).getComponentAsItemStack();
			if (!outputStack.isItemEqual(resultStack)) return false;
			int result = outputStack.stackSize + resultStack.stackSize;
			return result <= getInventoryStackLimit() && result <= outputStack.getMaxStackSize();
		}
	}
	
	@Override
	public void updateEntity()
	{
		boolean save = false;
		
		if (getWorldObj().getBlockPowerInput(xCoord, yCoord, zCoord) > 0)
		{
			setMachineState(MachineState.ON);
		}
		else
		{
			setMachineState(MachineState.OFF);
		}
		
		if (!this.worldObj.isRemote)
		{
			if (getInternalEnergy() > 0)
			{
				useEnergy();
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
					Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
					if (recipe != null)
					{
						if (isProcessing() && canProcess())
						{
							if (this.timeLeftToProcess <= 1)
							{
								this.timeLeftToProcess = 0;
								this.grindItem();
								save = true;
							}
							else
							{
								--timeLeftToProcess;
							}
						}
						else
						{
							this.timeLeftToProcess = recipe.getProcessTime();
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
	
	public void grindItem()
	{
		if (this.canProcess())
		{
			ItemStack stackInput = inventory[0];
			ItemStack stackOutput = inventory[1];
			Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
			List<RecipeComponent> resultList = recipe.getSimpleOutput(getClass(), stackInput);
			ItemStack resultStack = resultList.get(0).getComponentAsItemStack();
			System.out.println("Gotten Azurite Drop?:" + resultList.get(1).getDrop());
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
	public float getProgress()
	{
		ItemStack stackInput = inventory[0];
		if (stackInput != null && timeLeftToProcess != 0)
		{
			Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
			return (float) (recipe.getProcessTime() - timeLeftToProcess) / recipe.getProcessTime();
		}
		return 0f;
	}
	
}
