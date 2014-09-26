package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public abstract class MachineRecipePIC
{
	/**
	 * time in Ticks from proccessing
	 */
	int proccessTime;
	
	ItemStack[] itemsIn;
	ItemStack[] itemsOut;
	
	FluidStack[] fluidsIn;
	FluidStack[] fluidOut;
	
	public MachineRecipePIC()
	{
		
	}
	public MachineRecipePIC(int proccessTime)
	{
		this.proccessTime = proccessTime;
	}
	
	public ItemStack[] getItemsOut()
	{
		return this.itemsOut;
	}
	
	public ItemStack[] getItemsIn()
	{
		return this.itemsIn;
	}
	
	public FluidStack[] getFluidsOut()
	{
		return this.fluidOut;
	}
	
	public FluidStack[] getFluidsIn()
	{
		return this.fluidsIn;
	}
	
	public Object[] getOutput()
	{
		return new Object[] { this.itemsOut, this.fluidOut };
	}
	
	public Object[] getInput()
	{
		return new Object[] { this.itemsIn, this.fluidsIn };
	}
	
	
	
	/**
	 * Placeholder for research mechanic
	 */
	public abstract boolean canProduce();
}
