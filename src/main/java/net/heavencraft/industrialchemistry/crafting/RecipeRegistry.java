package net.heavencraft.industrialchemistry.crafting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.util.CollectionUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class RecipeRegistry
{
	
	private final static Set<Recipe> recipeList;
	
	static
	{
		recipeList = new HashSet<Recipe>();
	}
	
	public static Recipe registerRecipe(Class<? extends BaseTEBlockPower> clazz, RecipeComponent[] input, RecipeComponent[] output, int processTime, Map<String, Object> optionalSettings)
	{
		Recipe recipe = new Recipe(clazz, CollectionUtils.getList(input), CollectionUtils.getList(output), processTime, optionalSettings);
		recipeList.add(recipe);
		return recipe;
	}
	
	public static Recipe getRecipe(Class<? extends BaseTEBlockPower> clazz, List<Object> input)
	{
		for (Recipe r : recipeList)
			if (r.isValid(clazz, input)) return r;
		return null;
	}
	
	public static Recipe getRecipe(Class<? extends BaseTEBlockPower> clazz, Object input)
	{
		List l = new ArrayList<Object>();
		l.add(input);
		for (Recipe r : recipeList)
			if (r.isValid(clazz, l)) return r;
		return null;
	}
	
	public static Recipe addChemicalFurnaceRecipe(Object input, int q1, float chance1, Object output, int q2, float chance2, Fluid outputFluid, int q3, int processTime)
	{
		List<RecipeComponent> inputList = null;
		List<RecipeComponent> outputList = null;
		// Input
		if (input instanceof Item) 
			inputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Item) input, q1), 0, chance1) });
		else
			inputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Block) input, q1), 0, chance1) });
		
		// Output
		if (output instanceof Item) 
			outputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Item) output, q2), 1, chance2) });
		else
			outputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Block) output, q2), 1, chance2) });
		
		// Fluid Output
		outputList.add(new RecipeComponent(new FluidStack(outputFluid, q3), 2, 1.0f));
		
		Recipe recipe = new Recipe(TEMachineChemicalFurnace.class, inputList, outputList, processTime, null);
		recipeList.add(recipe);
		return recipe;
	}
}
