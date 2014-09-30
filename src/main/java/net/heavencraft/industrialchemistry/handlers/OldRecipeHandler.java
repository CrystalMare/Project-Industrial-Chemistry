package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.init.IndustrialChemistryBlocks;
import net.heavencraft.industrialchemistry.init.IndustrialChemistryItems;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipe;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.tileentity.TEMachineGrinder;
import net.minecraft.item.ItemStack;

public class OldRecipeHandler
{
	private static List<MachineRecipe> machineRecipeList = new ArrayList<MachineRecipe>(0);
	
	public static void init()
	{
		addMachineSimpleRecipe(TEMachineChemicalFurnace.class, new ItemStack(IndustrialChemistryItems.crushedMalachite), new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 2), 100);
		addMachineSimpleRecipe(TEMachineChemicalFurnace.class, new ItemStack(IndustrialChemistryItems.crushedAzurite), new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 3), 100);
		addMachineSimpleRecipe(TEMachineGrinder.class, new ItemStack(IndustrialChemistryBlocks.oreMalachite), new ItemStack(IndustrialChemistryItems.crushedMalachite, 2), 100);
	}
	
	
	public static void addMachineSimpleRecipe(Class<? extends BaseTEBlockPower> machine,ItemStack itemIn, ItemStack itemOut, int ticksTime)
	{
		machineRecipeList.add(new MachineRecipeSimple(machine, itemIn, itemOut, ticksTime));
	}
	
	public static MachineRecipeSimple getSimpleMachineRecipe(Class<? extends BaseTEBlockPower> machine, ItemStack itemIn)
	{
		for (MachineRecipe recipe : machineRecipeList)
		{
			if (recipe instanceof MachineRecipeSimple && ((MachineRecipeSimple) recipe).getSimpleInput(machine) != null && ((MachineRecipeSimple) recipe).getSimpleInput(machine).isItemEqual(itemIn))
			{
				return (MachineRecipeSimple) recipe;
			}
		}
		return null;
	}
}
