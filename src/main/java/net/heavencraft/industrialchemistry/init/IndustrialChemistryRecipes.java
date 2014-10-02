package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.handlers.RecipeHandler;
import net.heavencraft.industrialchemistry.handlers.RecipeComponent;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.item.ItemStack;

public class IndustrialChemistryRecipes
{
	public static void init()
	{
		RecipeHandler.addChemicalFurnaceRecipe(IndustrialChemistryItems.chemicalMalachite, 1, IndustrialChemistryItems.chemicalCopperOxide, 2, 100).addOptionalKey("maxtemp", 350).addOptionalKey("mintemp", 250);
		RecipeHandler.addChemicalFurnaceRecipe(IndustrialChemistryItems.chemicalAzurite, 1, IndustrialChemistryItems.chemicalCopperOxide, 3, 100).addOptionalKey("maxtemp", 350).addOptionalKey("mintemp", 300);
		
		RecipeHandler.registerRecipe(TEMachineGrinder.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryBlocks.oreMalachite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalMalachite, 1), 0, 1.0f),
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalAzurite, 1), 0, 0.05f) },
				100, null);
	}
}
