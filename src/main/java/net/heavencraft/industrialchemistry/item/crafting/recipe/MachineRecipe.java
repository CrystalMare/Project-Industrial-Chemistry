package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public abstract class MachineRecipe
{
	/**
	 * time in Ticks from proccessing
	 */
	int proccessTime;
	Class<? extends BaseTEBlockPower>  TileEntity;
	
	ItemStack[] itemsIn;
	ItemStack[] itemsOut;
	
	FluidStack[] fluidsIn;
	FluidStack[] fluidOut;
	
	public MachineRecipe()
	{
		
	}
	
	public MachineRecipe(Class<? extends BaseTEBlockPower> machine, int ProccessTime)
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
