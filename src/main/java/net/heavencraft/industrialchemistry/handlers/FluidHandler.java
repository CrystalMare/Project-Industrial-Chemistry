package net.heavencraft.industrialchemistry.handlers;

import net.heavencraft.industrialchemistry.fluids.BaseFluidBlock;
import net.heavencraft.industrialchemistry.item.FluidBucket;
import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class FluidHandler
{
	public static void RegisterFluid(Fluid fluid, String FluidName)
	{
		FluidRegistry.registerFluid(fluid);
		BaseFluidBlock fluidBlock = new BaseFluidBlock(fluid, Material.water, FluidName);
		GameRegistry.registerBlock(fluidBlock, FluidName);
		FluidBucket bucket = new FluidBucket(fluidBlock);
		BucketHandler.INSTANCE.buckets.put(fluidBlock, bucket);
		GameRegistry.registerItem(bucket, Names.Fluids.getBucketName(FluidName));
	}
}
