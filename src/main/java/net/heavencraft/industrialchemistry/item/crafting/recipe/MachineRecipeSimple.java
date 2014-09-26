package net.heavencraft.industrialchemistry.item.crafting.recipe;

import net.minecraft.item.ItemStack;

public class MachineRecipeSimple extends MachineRecipePIC
{
	
	public MachineRecipeSimple(ItemStack itemIn, ItemStack itemOut)
	{
		this.itemsIn = new ItemStack[] { itemIn };
		this.itemsOut = new ItemStack[] { itemOut };
	}
	
	@Override
	public boolean canProduce()
	{
		return true;
	}
	
}
