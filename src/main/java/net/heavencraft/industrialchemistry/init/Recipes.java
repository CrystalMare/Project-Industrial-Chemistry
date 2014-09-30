package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.handlers.NewRecipeHandler;
import net.heavencraft.industrialchemistry.handlers.RecipeComponent;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void init()
	{
		NewRecipeHandler.registerRecipe(TEMachineChemicalFurnace.class, 
				new RecipeComponent[] {
						new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedMalachite, 1), 0) },
				new RecipeComponent[] {
						new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 2), 0) },
				60, null);
	}
}
