package net.heavencraft.industrialchemistry.block.machine;

import java.util.HashMap;
import java.util.Map.Entry;

import net.heavencraft.industrialchemistry.block.BlockPIC;
import net.heavencraft.industrialchemistry.helpers.BlockHelper;
import net.heavencraft.industrialchemistry.tileentity.TEBlockPICPower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockMachinePIC extends BlockPIC
{
	private HashMap<ForgeDirection, IIcon> icons = new HashMap<ForgeDirection, IIcon>();
	private HashMap<ForgeDirection, String> iconsLocations = new HashMap<ForgeDirection, String>();
	
	public BlockMachinePIC()
	{
		
	}
	
	public void addIcon(String string, ForgeDirection dir)
	{
		this.iconsLocations.put(dir, string);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for (Entry location : iconsLocations.entrySet())
		{
			icons.put((ForgeDirection) location.getKey(), iconRegister.registerIcon((String) location.getValue()));
		}
	}
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
		ForgeDirection facingDir = BlockHelper.getOrientation(meta);
		if(tileEntity instanceof TEBlockPICPower)
		{
			((TEBlockPICPower) tileEntity).getState();
		}
		return null;
	}
}
