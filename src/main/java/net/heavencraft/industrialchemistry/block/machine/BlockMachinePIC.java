package net.heavencraft.industrialchemistry.block.machine;

import java.util.Map.Entry;

import cofh.api.tileentity.ISidedTexture;

import net.heavencraft.industrialchemistry.block.BlockPIC;
import net.heavencraft.industrialchemistry.helpers.BlockHelper;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.TEBlockPICPower;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockMachinePIC extends BlockPIC implements ITileEntityProvider, ISidedTexture
{
	IIcon[] frontIcons = new IIcon[3];
	IIcon[] topIcons = new IIcon[3];
	IIcon[] sideIcons = new IIcon[3];
	IIcon[] backIcons = new IIcon[3];
	IIcon[] bottomIcons = new IIcon[3];
	
	public BlockMachinePIC()
	{
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		
	}
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
		ForgeDirection facingDir = BlockHelper.getOrientation(meta);
		if (tileEntity instanceof TEBlockPICPower)
		{
			if (side == facingDir.ordinal())
			{
				if (this.frontIcons[((TEBlockPICPower) tileEntity).getState().getID()] != null)
				{
					return this.frontIcons[((TEBlockPICPower) tileEntity).getState().getID()];
				}
				else
				{
					return this.getIcon(ForgeDirection.SOUTH.ordinal(), meta);
				}
			}
			if (side == facingDir.getOpposite().ordinal())
			{
				if (this.backIcons[((TEBlockPICPower) tileEntity).getState().getID()] != null)
				{
					return this.backIcons[((TEBlockPICPower) tileEntity).getState().getID()];
				}
				else
				{
					return this.getIcon(ForgeDirection.NORTH.ordinal(), meta);
				}
			}
			if (side == ForgeDirection.UP.ordinal())
			{
				if (this.topIcons[((TEBlockPICPower) tileEntity).getState().getID()] != null)
				{
					return this.topIcons[((TEBlockPICPower) tileEntity).getState().getID()];
				}
				else
				{
					return this.getIcon(ForgeDirection.UP.ordinal(), meta);
				}
			}
			if (side == ForgeDirection.DOWN.ordinal())
			{
				if (this.bottomIcons[((TEBlockPICPower) tileEntity).getState().getID()] != null)
				{
					return this.bottomIcons[((TEBlockPICPower) tileEntity).getState().getID()];
				}
				else
				{
					return this.getIcon(ForgeDirection.DOWN.ordinal(), meta);
				}
			}
			if (this.sideIcons[((TEBlockPICPower) tileEntity).getState().getID()] != null)
			{
				return this.sideIcons[((TEBlockPICPower) tileEntity).getState().getID()];
			}
			else
			{
				return this.getIcon(ForgeDirection.UNKNOWN.ordinal(), meta);
			}
		}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == ForgeDirection.SOUTH.ordinal())
		{
			return this.frontIcons[MachineState.Off.getID()];
		}
		if (side == ForgeDirection.NORTH.ordinal())
		{
			return this.backIcons[MachineState.Off.getID()];
		}
		if (side == ForgeDirection.UP.ordinal())
		{
			return this.topIcons[MachineState.Off.getID()];
		}
		if (side == ForgeDirection.DOWN.ordinal())
		{
			return this.bottomIcons[MachineState.Off.getID()];
		}
		if (side == ForgeDirection.UNKNOWN.ordinal())
		{
			return this.sideIcons[MachineState.Off.getID()];
		}
		return this.sideIcons[MachineState.Off.getID()];
	}
}
