package net.heavencraft.industrialchemistry.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BaseFluidBlock extends BlockFluidClassic
{
	private String FluidName;
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	
	public BaseFluidBlock(Fluid fluid, Material material, String Name)
	{
		super(fluid, material);
		this.setBlockName(Name);
		FluidName = Name;
	}
	
	public String getFluidName()
	{
		return FluidName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		stillIcon = iconRegister.registerIcon(Textures.Block.Fluids.getStillIconLocation(FluidName));
		flowingIcon = iconRegister.registerIcon(Textures.Block.Fluids.getFlowingIconLocation(FluidName));
		super.registerBlockIcons(iconRegister);
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}
	
}
