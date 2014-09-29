package net.heavencraft.industrialchemistry.fluids;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidsPIC
{
	public static Fluid Oxygen = new Fluid(Names.Fluids.Oxygen);
	
	public static void init()
	{
		FluidRegistry.registerFluid(Oxygen);
	}
}
