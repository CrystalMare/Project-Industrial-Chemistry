package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipePIC;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.minecraft.item.ItemStack;

public class RecipeHandler
{
	private static List<MachineRecipePIC> machineRecipeList = new ArrayList<MachineRecipePIC>();
	
	public static void init()
	{
		
	}
	
	public static void addMachineSimpleRecipe(ItemStack itemIn, ItemStack itemOut, int ticksTime)
	{
		
	}
	
	public static ItemStack getSimpleMachineRecipeResult(ItemStack itemIn)
	{
		for(MachineRecipePIC recipe : machineRecipeList)
		{
			if(recipe instanceof MachineRecipeSimple)
			{
				return recipe.getItemsOut()[0];	
			}
		}
		return null;
	}
}
