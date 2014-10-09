package net.heavencraft.industrialchemistry.tileentity.machines;

import net.heavencraft.industrialchemistry.crafting.Recipe;
import net.heavencraft.industrialchemistry.crafting.RecipeRegistry;
import net.heavencraft.industrialchemistry.init.IndustrialChemistryItems;
import net.heavencraft.industrialchemistry.item.ItemAsh;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEMachineChemicalFurnace extends BaseTEBlockPower
{
	private static final float heatingCoeff = 0.1f;
	private static final float keepCoeff =  0.01f;
	
	private int timeLeftToProcess = 0;
	private float internalTemp = 0;
	private float limitTemp = 1000;
	
	private FluidTank tank = new FluidTank(10000);
	
	public TEMachineChemicalFurnace()
	{
		createInventory(2);
		recieveAllSides();
		storage.setCapacity(16000);
	}
	
	public boolean isProcessing()
	{
		return this.timeLeftToProcess > 0;
	}
	
	private boolean canProcess()
	{
		ItemStack input = inventory[0];
		ItemStack[] outputs = new ItemStack[] { inventory[1] };
		
		if (input == null) return false;
		
		Recipe recipe = RecipeRegistry.getRecipe(getClass(), CollectionUtils.getList(new Object[] { input }));
		
		if (recipe == null) return false;
		if (CollectionUtils.allNull(outputs)) return true;
		
		for (int i = 0; i < outputs.length; i++)
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
					Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
					if (recipe != null)
					{
						if (recipe.hasOptionalSetting("mintemp"))
						{
							if (internalTemp < (Integer) recipe.getOptionalSetting("mintemp"))
							{
								return;
							}
						}
						
						if (isProcessing() && canProcess())
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
		if (this.canProcess())
		{
			ItemStack stackInput = inventory[0];
			ItemStack stackOutput = inventory[1];
			Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
			ItemStack resultStack = recipe.getSimpleOutput(getClass(), stackInput).get(0).getComponentAsItemStack();
			if (recipe.hasOptionalSetting("maxtemp"))
			{
				int maxTemp = (Integer) recipe.getOptionalSetting("maxtemp");
				if (Math.floor(internalTemp) > maxTemp)
				{
					if (stackOutput == null)
					{
						setInventorySlotContents(1, new ItemStack(IndustrialChemistryItems.itemAsh));
					}
					else if (stackOutput.getItem() instanceof ItemAsh)
					{
						setInventorySlotContents(1, new ItemStack(IndustrialChemistryItems.itemAsh, 1 + stackOutput.stackSize));
					}
					else
					{
						float spawnX = xCoord;
						float spawnY = yCoord;
						float spawnZ = zCoord;
						EntityItem toolItem = new EntityItem(getWorldObj(), spawnX, spawnY, spawnZ, new ItemStack(IndustrialChemistryItems.itemAsh));
						float mult = 0.05F;
						toolItem.motionX = (0.5F + getWorldObj().rand.nextFloat()) * mult;
						toolItem.motionY = (4 + getWorldObj().rand.nextFloat()) * mult;
						toolItem.motionZ = (0.5F + getWorldObj().rand.nextFloat()) * mult;
						toolItem.delayBeforeCanPickup = 40;
						getWorldObj().spawnEntityInWorld(toolItem);
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
				//Fluid
				if (recipe.getOutputComponents().length > 1 && recipe.getOutputComponents()[1].isFluidStack())
				{
					FluidStack output = recipe.getOutputComponents()[1].getComponentAsFluidStack();
					if (tank.getFluid() == null)
					{
						tank.setFluid(output.copy());
					}
					else if (tank.getFluid().isFluidEqual(output))
					{
						if (tank.getFluidAmount() + output.amount > tank.getCapacity())
						{
							tank.setFluid(new FluidStack(output.getFluid(), tank.getCapacity()));
						}
						else
						{
							tank.setFluid(new FluidStack(output.getFluid(), tank.getFluidAmount() + output.amount));
						}
					}
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
			Recipe recipe = RecipeRegistry.getRecipe(getClass(), stackInput);
			return (float) (recipe.getProcessTime() - timeLeftToProcess) / recipe.getProcessTime();
		}
		return 0f;
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

	public IFluidTank getTank() {
		return tank;
	}	
}
