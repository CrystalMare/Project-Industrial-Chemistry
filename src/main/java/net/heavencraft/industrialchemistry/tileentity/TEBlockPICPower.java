package net.heavencraft.industrialchemistry.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;

public abstract class TEBlockPICPower extends TEBlockPICInventory implements IEnergyHandler
{
	private List<ForgeDirection> recieveSides = new ArrayList<ForgeDirection>();
	private List<ForgeDirection> extractSides = new ArrayList<ForgeDirection>();
	protected EnergyStorage storage = new EnergyStorage(1000);
	protected MachineState state = MachineState.OFF;
	
	public TEBlockPICPower()
	{
		
	}
	
	public void setMachineState(MachineState state)
	{
		this.state = state;
	}
	
	public MachineState getState()
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
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{		
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}
	
}
