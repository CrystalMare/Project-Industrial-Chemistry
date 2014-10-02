package net.heavencraft.industrialchemistry.tileentity.machines;

import net.heavencraft.industrialchemistry.handlers.Recipe;
import net.heavencraft.industrialchemistry.handlers.RecipeHandler;
import net.heavencraft.industrialchemistry.init.IndustrialChemistryItems;
import net.heavencraft.industrialchemistry.item.ItemAsh;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEMachineChemicalFurnace extends BaseTEBlockPower
{
	private static final float heatingCoeff = (float) 0.1;
	private static final float keepCoeff = (float) 0.01;
	
	private int timeLeftToProcess = 0;
	private int energyUsage = 0;
	private float internalTemp = 0;
	private float limitTemp = 1000;
	
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
		if (inventory[0] == null) return false;
		ItemStack inputStack = inventory[0];
		ItemStack outputStack = inventory[1];
		
		Recipe recipe = RecipeHandler.getRecipe(getClass(), CollectionUtils.getList(new Object[] { inventory[0] }));
		if (recipe == null) return false;
		if (outputStack == null) return true;
		if (outputStack.getItem() instanceof ItemAsh) return true;

		
		ItemStack resultStack = recipe.getSimpleOutput().get(0).getComponentAsItemStack();
		if (!outputStack.isItemEqual(resultStack)) return false;
		int result = outputStack.stackSize + resultStack.stackSize;
		return result <= getInventoryStackLimit() && result <= outputStack.getMaxStackSize();
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
			if (internalTemp > 0)
			{
				internalTemp -= (float) 2 / 3;
			}
			setMachineState(MachineState.OFF);
			timeLeftToProcess = 0;
		}
		
		if (!this.worldObj.isRemote)
		{
			if (getInternalEnergy() > 0)
			{
				energyUsage = useEnergy();
			}
			else
			{
				state = MachineState.OFF;
				timeLeftToProcess = 0;
			}
			
			if (state == MachineState.ON)
			{
				ItemStack stackInput = inventory[0];
				if (stackInput != null)
				{
					Recipe recipe = RecipeHandler.getRecipe(getClass(), stackInput);
					if (recipe != null)
					{
						if (recipe.hasOptionalSetting("mintemp"))
						{
							if (internalTemp < (Integer) recipe.getOptionalSetting("mintemp"))
							{
								return;
							}
						}
						
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
	
	public void smeltItem()
	{
		if (this.canProccess())
		{
			ItemStack stackInput = inventory[0];
			ItemStack stackOutput = inventory[1];
			Recipe recipe = RecipeHandler.getRecipe(getClass(), stackInput);
			ItemStack resultStack = recipe.getSimpleOutput(getClass(), stackInput).get(0).getComponentAsItemStack();
			if (recipe.hasOptionalSetting("maxtemp"))
			{
				int maxTemp = (Integer) recipe.getOptionalSetting("maxtemp");
				if (internalTemp > maxTemp)
				{
					if (stackOutput == null)
					{
						setInventorySlotContents(1, new ItemStack(IndustrialChemistryItems.ash));
					}
					else if (stackOutput.getItem() instanceof ItemAsh)
					{
						setInventorySlotContents(1, new ItemStack(IndustrialChemistryItems.ash, 1 + stackOutput.stackSize));
					}
					else
					{
						float spawnX = xCoord;
						float spawnY = yCoord;
						float spawnZ = zCoord;
						EntityItem toolItem = new EntityItem(getWorldObj(), spawnX, spawnY, spawnZ, new ItemStack(IndustrialChemistryItems.ash));
						float mult = 0.05F;
						toolItem.motionX = (0.5F + getWorldObj().rand.nextFloat()) * mult;
						toolItem.motionY = (4 + getWorldObj().rand.nextFloat()) * mult;
						toolItem.motionZ = (0.5F + getWorldObj().rand.nextFloat()) * mult;
						toolItem.delayBeforeCanPickup = 40;
						getWorldObj().spawnEntityInWorld(toolItem);
					}
					return;
				}
				else
				{
					if (stackOutput == null)
					{
						setInventorySlotContents(1, resultStack.copy());
					}
					else if (stackOutput.getItem() == resultStack.getItem())
					{
						setInventorySlotContents(1, new ItemStack(resultStack.getItem(), resultStack.stackSize + stackOutput.stackSize));
					}
				}
			}
			else
			{
				if (stackOutput == null)
				{
					setInventorySlotContents(1, resultStack.copy());
				}
				else if (stackOutput.getItem() == resultStack.getItem())
				{
					setInventorySlotContents(1, new ItemStack(resultStack.getItem(), resultStack.stackSize + stackOutput.stackSize));
				}
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
	
	@Override
	public int useEnergy()
	{
		if (state == MachineState.ON)
		{
			float rfHeating = 0;
			limitTemp = 360;
			if (isHeating())
			{
				rfHeating = heatingCoeff * internalTemp;
				internalTemp += (float) 1 / 3;
			}
			if (shouldCool())
			{
				internalTemp -= (float) 1 / 3;
			}
			float rfKeep = keepCoeff * internalTemp;
			float rfItem = 0;
			if (isProcessing())
			{
				rfItem = 10;
			}
			
			if (isHeating() && isProcessing())
			{
				internalTemp -= (float) 1 / 6;
			}
			
			int total = Math.round(rfHeating + rfKeep + rfItem);
			return storage.extractEnergy(total, false);
		}
		return 0;
	}
	
	public void setTimeLeftToProcess(int value)
	{
		timeLeftToProcess = value;
	}
	
	public boolean shouldCool()
	{
		return internalTemp > limitTemp + 1;
	}
	
	public boolean isHeating()
	{
		return internalTemp <= limitTemp && state == MachineState.ON;
	}
	
	@SideOnly(Side.CLIENT)
	public float getProgress()
	{
		ItemStack stackInput = inventory[0];
		if (stackInput != null && timeLeftToProcess != 0)
		{
			Recipe recipe = RecipeHandler.getRecipe(getClass(), stackInput);
			return (float) (recipe.getProcessTime() - timeLeftToProcess) / recipe.getProcessTime();
		}
		return 0f;
	}
	
	public int getEnergyUsage()
	{
		return energyUsage;
	}
	
	public void setEnergyUsage(int value)
	{
		energyUsage = value;
	}
	
	public int getTemp()
	{
		return (int) internalTemp;
	}
	
	public void setTemp(int value)
	{
		internalTemp = value;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
		if (nbt.hasKey(Names.NBT.TileEntity.Temp))
		{
			internalTemp = nbt.getFloat(Names.NBT.TileEntity.Temp);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
		if (this.internalTemp != 0) nbt.setFloat(Names.NBT.TileEntity.Temp, internalTemp);
	}
	
}
