package net.heavencraft.industrialchemistry.handlers;

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

public class NewRecipeHandler
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
	
	public static Recipe addChemicalFurnaceRecipe(Object item1, int q1, Object item2, int q2, int processTime)
	{
		List<RecipeComponent> inputList = null;
		List<RecipeComponent> outputList = null;
		if (item1 instanceof Item) inputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Item) item1, q1), 0, 1.0f) });
		else
			inputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Block) item1, q1), 0, 1.0f) });
		
		if (item2 instanceof Item) outputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Item) item2, q2), 0, 1.0f) });
		
		else
			outputList = CollectionUtils.getList(new RecipeComponent[] { new RecipeComponent(new ItemStack((Block) item2, q2), 0, 1.0f) });
		
		Recipe recipe = new Recipe(TEMachineChemicalFurnace.class, inputList, outputList, processTime, null);
		recipeList.add(recipe);
		return recipe;
	}
}
