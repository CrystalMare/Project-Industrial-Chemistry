package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;

import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipe;
import net.heavencraft.industrialchemistry.item.crafting.recipe.MachineRecipeSimple;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OldRecipeHandler
{
	private static List<MachineRecipe> machineRecipeList = new ArrayList<MachineRecipe>();
	
	public static void init()
	{
		addMachineSimpleRecipe(new ItemStack(Blocks.stone), new ItemStack(Items.diamond, 40), 100);
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
