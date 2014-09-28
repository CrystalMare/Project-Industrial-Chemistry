package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.heavencraft.industrialchemistry.tileentity.TEBlockPICPower;
import net.minecraft.item.ItemStack;

public class MachineRecipeSimple extends MachineRecipePIC
{
	
	public MachineRecipeSimple(Class<? extends TEBlockPICPower> machine, ItemStack itemIn, ItemStack itemOut, int timeTicks)
	{
		super(machine, timeTicks);
		this.itemsIn = new ItemStack[] { itemIn };
		this.itemsOut = new ItemStack[] { itemOut };
	}
	
	@Override
	public boolean canProduce()
	{
		return true;
	}
	
	public ItemStack getSimpleInput(Class<? extends TEBlockPICPower> machine)
	{
		return machine == this.TileEntity ? itemsIn[0] : null;
	}
	
	
	public ItemStack getSimpleOutput(Class<? extends TEBlockPICPower> machine)
	{
		return machine == this.TileEntity ? itemsOut[0] : null;
	}
	
}
