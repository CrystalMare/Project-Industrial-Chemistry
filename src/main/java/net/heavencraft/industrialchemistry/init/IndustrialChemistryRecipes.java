package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.crafting.RecipeComponent;
import net.heavencraft.industrialchemistry.crafting.RecipeRegistry;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.item.ItemStack;

public class IndustrialChemistryRecipes
{
	public static void init()
	{
		RecipeRegistry.addChemicalFurnaceRecipe(IndustrialChemistryItems.chemicalMalachite, 1, 1.0f, 
				IndustrialChemistryItems.chemicalCopperOxide, 2, 1.0f,
				IndustrialChemistryFluids.CarbonDioxide, 250, 100).addOptionalKey("maxtemp", 350).addOptionalKey("mintemp", 250);
		RecipeRegistry.addChemicalFurnaceRecipe(IndustrialChemistryItems.chemicalAzurite, 1, 1.0f, 
				IndustrialChemistryItems.chemicalCopperOxide, 3, 1.0f,
				IndustrialChemistryFluids.CarbonDioxide, 500, 100).addOptionalKey("maxtemp", 350).addOptionalKey("mintemp", 300);
		
		RecipeRegistry.registerRecipe(TEMachineGrinder.class, 
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryBlocks.oreMalachite, 1), 0, 1.0f) },
				new RecipeComponent[] {
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalMalachite, 1), 0, 1.0f),
					new RecipeComponent(new ItemStack(IndustrialChemistryItems.chemicalAzurite, 1), 0, 0.20f) },
				100, null);
	}
}
