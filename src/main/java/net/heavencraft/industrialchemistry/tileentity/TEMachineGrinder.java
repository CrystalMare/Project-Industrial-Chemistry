package net.heavencraft.industrialchemistry.tileentity;

import java.util.List;

import net.heavencraft.industrialchemistry.crafting.Recipe;
import net.heavencraft.industrialchemistry.crafting.RecipeComponent;
import net.heavencraft.industrialchemistry.crafting.RecipeRegistry;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEMachineGrinder extends BaseTEBlockPower
{
	private int timeLeftToProcess = 0;
	
	public TEMachineGrinder()
	{
		createInventory(2);
		this.rfPerTick = 10;
		recieveAllSides();
	}
	
	public boolean isProcessing()
	{
		return this.timeLeftToProcess > 0;
	}
	
	private boolean canProcess()
	{
		ItemStack input = inventory[0];
		ItemStack[] outputs = new ItemStack[] { inventory[1], inventory[2] };
		
		if (input == null) return false;
				
		Recipe recipe = RecipeRegistry.getRecipe(getClass(), CollectionUtils.getList(new Object[] { input }));
		
		if (recipe == null) return false;
		if (CollectionUtils.allNull(outputs)) return true;
		
		for(int i = 0; i < outputs.length; i++)
		{
			ItemStack recipeOut = recipe.getOutputComponents()[i].getComponentAsItemStack();
			if (outputs[i] != null)
			{
				if (!outputs[i].isItemEqual(recipeOut)) return false;
				if (outputs[i].stackSize + recipeOut.stackSize > outputs[i].getMaxStackSize()) return false;
			}
		}
		return true;
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
		if (!canProcess())
			return;
		
		ItemStack input = inventory[0];
		ItemStack output = inventory[1];
		ItemStack output2 = inventory[2];
		
		Recipe recipe = RecipeRegistry.getRecipe(getClass(), input);
		
		List<RecipeComponent> resultList = recipe.getSimpleOutput(getClass(), input);
		
		//Output Slot 1
		if (resultList.get(0).getDrop()) {
			if (output == null)				
				setInventorySlotContents(1, resultList.get(0).getComponentAsItemStack().copy());
			else
				output.stackSize += resultList.get(0).getComponentAsItemStack().stackSize;
		}
		//Output Slot 2
		if (resultList.get(1).getDrop())
		{
			if (output2 == null)
				setInventorySlotContents(2, resultList.get(1).getComponentAsItemStack().copy());
			else
				output.stackSize += resultList.get(1).getComponentAsItemStack().stackSize;
		}
		
		--input.stackSize;
		
		if (input.stackSize <= 0)
			setInventorySlotContents(0, null);
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
