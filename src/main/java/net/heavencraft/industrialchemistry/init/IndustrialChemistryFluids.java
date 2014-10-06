package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.handlers.FluidHandler;
import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraftforge.fluids.Fluid;

public class IndustrialChemistryFluids
{
	public static final Fluid Oxygen = new Fluid(Names.Fluids.Oxygen);
	public static final Fluid CarbonDioxide = new Fluid(Names.Fluids.CarbonDioxide);
	
	public static void init()
	{
		FluidHandler.RegisterFluid(Oxygen, Names.Fluids.Oxygen);
		FluidHandler.RegisterFluid(CarbonDioxide, Names.Fluids.CarbonDioxide);
	}
}
