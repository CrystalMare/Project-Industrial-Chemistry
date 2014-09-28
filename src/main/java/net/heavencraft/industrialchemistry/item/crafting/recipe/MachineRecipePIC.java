package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.heavencraft.industrialchemistry.tileentity.TEBlockPICPower;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public abstract class MachineRecipePIC
{
	/**
	 * time in Ticks from proccessing
	 */
	int proccessTime;
	Class<? extends TEBlockPICPower>  TileEntity;
	
	ItemStack[] itemsIn;
	ItemStack[] itemsOut;
	
	FluidStack[] fluidsIn;
	FluidStack[] fluidOut;
	
	public MachineRecipePIC()
	{
		
	}
	
	public MachineRecipePIC(Class<? extends TEBlockPICPower> machine, int ProccessTime)
	{
		this.TileEntity = machine;
		proccessTime = ProccessTime;
	}
	
	public ItemStack[] getItemsOut()
	{
		return itemsOut;
	}
	
	public ItemStack[] getItemsIn()
	{
		return itemsIn;
	}
	
	public FluidStack[] getFluidsOut()
	{
		return fluidOut;
	}
	
	public FluidStack[] getFluidsIn()
	{
		return fluidsIn;
	}
	
	public Object[] getOutput()
	{
		return new Object[] { itemsOut, fluidOut };
	}
	
	public Object[] getInput()
	{
		return new Object[] { itemsIn, fluidsIn };
	}
	

	
	public int getProccessTime()
	{
		return proccessTime;
	}
	
	/**
	 * Placeholder for research mechanic
	 */
	public abstract boolean canProduce();
}
