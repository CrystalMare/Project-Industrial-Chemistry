package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class PICFluids
{
	public static Fluid Oxygen = new Fluid(Names.Fluids.Oxygen);
	
	public static void init()
	{
		FluidRegistry.registerFluid(Oxygen);
	}
}
