package net.heavencraft.industrialchemistry.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyStorage;

public abstract class BaseTEBlockPower extends BaseTEBlockInventory implements IEnergyHandler
{
	protected List<ForgeDirection> recieveSides = new ArrayList<ForgeDirection>();
	protected List<ForgeDirection> extractSides = new ArrayList<ForgeDirection>();
	protected EnergyStorage storage = new EnergyStorage(1000);
	protected MachineState state = MachineState.OFF;
	protected int rfPerTick = 10;
	protected int energyUsage = 0;
	
	public BaseTEBlockPower()
	{
		
	}
	
	public void extractAllSides()
	{
		
	}
	
	public void recieveAllSides()
	{
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
		{
			recieveSides.add(dir);
		}
	}
	
	public void setMachineState(MachineState state)
	{
		this.state = state;
	}
	
	public MachineState getMachineState()
	{
		return this.state;
	}
	
	public void setPowerCapacity(int capacity)
	{
		this.storage.setCapacity(capacity);
	}
	
	public void addReceiveSide(ForgeDirection dir)
	{
		recieveSides.add(dir);
	}
	
	public void addExtractSide(ForgeDirection dir)
	{
		extractSides.add(dir);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		for (ForgeDirection dir : recieveSides)
		{
			if (dir == from)
			{
				return true;
			}
		}
		
		for (ForgeDirection dir : extractSides)
		{
			if (dir == from)
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate)
	{
		for (ForgeDirection dir : recieveSides)
		{
			if (dir == from)
			{
				return storage.receiveEnergy(maxReceive, simulate);
			}
		}
		return 0;
	}
	
	public int useEnergy()
	{
		return storage.extractEnergy(rfPerTick, false);
	}
	
	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate)
	{
		for (ForgeDirection dir : extractSides)
		{
			if (dir == from)
			{
				return storage.extractEnergy(maxExtract, simulate);
			}
		}
		return 0;
	}
	
	public int getInternalEnergy()
	{
		return storage.getEnergyStored();
	}
	
	public void setInternalEnergy(int value)
	{
		storage.setEnergyStored(value);
	}
	
	@Override
	public int getEnergyStored(ForgeDirection from)
	{
		if (canConnectEnergy(from))
		{
			return storage.getEnergyStored();
		}
		return 0;
	}
	
	@Override
	public int getMaxEnergyStored(ForgeDirection from)
	{
		if (canConnectEnergy(from))
		{
			return storage.getMaxEnergyStored();
		}
		return 0;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
		if (nbt.hasKey(Names.NBT.TileEntity.State))
		{
			this.state = MachineState.values()[nbt.getInteger(Names.NBT.TileEntity.State)];
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
		if (this.state != null) nbt.setInteger(Names.NBT.TileEntity.State, this.state.getID());
	}
	
	protected void takeEnergyFromSlot(int SlotID)
	{
		ItemStack item = getStackInSlot(SlotID);
		if (item != null && item.getItem() instanceof IEnergyContainerItem)
		{
			IEnergyContainerItem capacitor = (IEnergyContainerItem) item.getItem();
			int rft = capacitor.extractEnergy(item, Integer.MAX_VALUE, true);
			capacitor.receiveEnergy(item, rft - storage.receiveEnergy(capacitor.extractEnergy(item, rft, false), false), false);
		}
	}
	
	public int getEnergyUsage()
	{
		return energyUsage;
	}
	
	public void setEnergyUsage(int value)
	{
		energyUsage = value;
	}
	
	public IEnergyStorage getEnergyStorage()
	{
		return storage;
	}
}
