package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class IndustrialChemistryFluids
{
	public static final Fluid Oxygen = new Fluid(Names.Fluids.Oxygen);
	public static final Fluid CarbonDioxide = new Fluid(Names.Fluids.CarbonDioxide);
	
	public static void init()
	{
		FluidRegistry.registerFluid(Oxygen);
		FluidRegistry.registerFluid(CarbonDioxide);
	}
}
