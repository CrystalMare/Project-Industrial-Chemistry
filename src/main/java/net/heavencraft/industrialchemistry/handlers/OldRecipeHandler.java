package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.init.IndustrialChemistryItems;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipe;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.item.ItemStack;

public class OldRecipeHandler
{
	private static List<MachineRecipe> machineRecipeList = new ArrayList<MachineRecipe>();
	
	public static void init()
	{
		addMachineSimpleRecipe(new ItemStack(IndustrialChemistryItems.crushedMalachite), new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 2), 100);
		addMachineSimpleRecipe(new ItemStack(IndustrialChemistryItems.crushedAzurite), new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 3), 100);
	}
	
	
	public static void addMachineSimpleRecipe(ItemStack itemIn, ItemStack itemOut, int ticksTime)
	{
		machineRecipeList.add(new MachineRecipeSimple(TEMachineChemicalFurnace.class, itemIn, itemOut, ticksTime));
	}
	
	public static MachineRecipeSimple getSimpleMachineRecipe(Class<? extends BaseTEBlockPower> machine, ItemStack itemIn)
	{
		for (MachineRecipe recipe : machineRecipeList)
		{
			if (recipe instanceof MachineRecipeSimple && ((MachineRecipeSimple) recipe).getSimpleInput(machine).isItemEqual(itemIn))
			{
				return (MachineRecipeSimple) recipe;
			}
		}
		return null;
	}
}
