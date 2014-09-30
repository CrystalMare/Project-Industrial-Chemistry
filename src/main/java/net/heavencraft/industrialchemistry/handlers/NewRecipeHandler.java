package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.util.CollectionUtils;

public class NewRecipeHandler
{
	
	private final static Set<Recipe> recipeList;
	
	static {
		recipeList = new HashSet<Recipe>();
	}
	
	public static Recipe registerRecipe(Class<? extends BaseTEBlockPower> clazz, RecipeComponent[] input, RecipeComponent[] output, 
			int processTime, Map<String, Object> optionalSettings)
	{
		Recipe recipe = new Recipe(clazz, CollectionUtils.getList(input), CollectionUtils.getList(output), processTime, optionalSettings);
		recipeList.add(recipe);
		return recipe;	
	}
	
	public static Recipe getRecipe(Class<? extends BaseTEBlockPower> clazz, List<Object> input)
	{
		for(Recipe r : recipeList)
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
}
