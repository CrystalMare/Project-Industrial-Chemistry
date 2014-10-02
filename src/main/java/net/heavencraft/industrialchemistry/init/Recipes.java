package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.handlers.NewRecipeHandler;
import net.heavencraft.industrialchemistry.handlers.RecipeComponent;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void init()
	{
		NewRecipeHandler.registerRecipe(TEMachineChemicalFurnace.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedMalachite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 2), 0, 1.0f) },
				100, null);
		NewRecipeHandler.registerRecipe(TEMachineChemicalFurnace.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedAzurite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalCopperOxide, 3), 0, 1.0f) },
				100, null);
		
		NewRecipeHandler.registerRecipe(TEMachineGrinder.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryBlocks.oreMalachite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedMalachite, 1), 0, 1.0f),
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.crushedAzurite, 1), 0, 0.05f) },
				100, null);
	}
}
