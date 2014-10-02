package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.handlers.NewRecipeHandler;
import net.heavencraft.industrialchemistry.handlers.RecipeComponent;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void init()
	{
		NewRecipeHandler.addChemicalFurnaceRecipe(IndustrialChemistryItems.crushedMalachite, 1, IndustrialChemistryItems.chemicalCopperOxide, 2, 100);
		NewRecipeHandler.addChemicalFurnaceRecipe(IndustrialChemistryItems.crushedAzurite, 1, IndustrialChemistryItems.chemicalCopperOxide, 3, 100);
				
		
		NewRecipeHandler.registerRecipe(TEMachineGrinder.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryBlocks.oreMalachite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedMalachite, 1), 0, 1.0f),
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedAzurite, 1), 0, 0.05f) },
				100, null);
	}
}
