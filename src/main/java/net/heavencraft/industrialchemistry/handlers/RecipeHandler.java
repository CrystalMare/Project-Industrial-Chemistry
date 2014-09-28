package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipePIC;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.heavencraft.industrialchemistry.tileentity.TEBlockPICPower;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeHandler
{
	private static List<MachineRecipePIC> machineRecipeList = new ArrayList<MachineRecipePIC>();
	
	public static void init()
	{
		addMachineSimpleRecipe(new ItemStack(Blocks.stone), new ItemStack(Items.diamond, 40), 100);
	}
	
	public static void addMachineSimpleRecipe(ItemStack itemIn, ItemStack itemOut, int ticksTime)
	{
		machineRecipeList.add(new MachineRecipeSimple(TEMachineChemicalFurnace.class, itemIn, itemOut, ticksTime));
	}
	
	public static MachineRecipeSimple getSimpleMachineRecipe(Class<? extends TEBlockPICPower> machine, ItemStack itemIn)
	{
		for (MachineRecipePIC recipe : machineRecipeList)
		{
			if (recipe instanceof MachineRecipeSimple && ((MachineRecipeSimple) recipe).getSimpleInput(machine).isItemEqual(itemIn))
			{
				return (MachineRecipeSimple) recipe;
			}
		}
		return null;
	}
}
