package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.minecraft.item.ItemStack;

public class MachineRecipeSimple extends MachineRecipe
{
	
	public MachineRecipeSimple(Class<? extends BaseTEBlockPower> machine, ItemStack itemIn, ItemStack itemOut, int timeTicks)
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
	
	public ItemStack getSimpleInput(Class<? extends BaseTEBlockPower> machine)
	{
		return machine == this.TileEntity ? itemsIn[0] : null;
	}
	
	
	public ItemStack getSimpleOutput(Class<? extends BaseTEBlockPower> machine)
	{
		return machine == this.TileEntity ? itemsOut[0] : null;
	}
	
}
