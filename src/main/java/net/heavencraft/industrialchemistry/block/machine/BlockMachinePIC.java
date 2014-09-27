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

public abstract class BlockMachinePIC extends BlockPIC implements ITileEntityProvider
{
	IIcon[] frontIcons = new IIcon[3];
	IIcon[] topIcons = new IIcon[3];
	IIcon[] sideIcons = new IIcon[3];
	IIcon[] backIcons = new IIcon[3];
	IIcon[] bottomIcons = new IIcon[3];
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
	
		if (!(tileEntity instanceof TEBlockPICPower)) return null;
		
		MachineState state = ((TEBlockPICPower)tileEntity).getState();
		ForgeDirection front = BlockHelper.getOrientation(meta);
		
		
		if (side == front.ordinal())
		{
			if (this.frontIcons[state.getID()] != null)
			{
				return this.frontIcons[state.getID()];
			}
			else
			{
				return this.getIcon(ForgeDirection.SOUTH.ordinal(), meta);
			}
		}
		else if (side == front.getOpposite().ordinal())
		{
			if (this.backIcons[state.getID()] != null)
			{
				return this.backIcons[state.getID()];
			}
			else
			{
				return this.getIcon(ForgeDirection.NORTH.ordinal(), meta);
			}
		}
		else if (side == ForgeDirection.UP.ordinal())
		{
			if (this.topIcons[state.getID()] != null)
			{
				return this.topIcons[state.getID()];
			}
			else
			{
				return this.getIcon(ForgeDirection.UP.ordinal(), meta);
			}
		}
		else if (side == ForgeDirection.DOWN.ordinal())
		{
			if (this.bottomIcons[state.getID()] != null)
			{
				return this.bottomIcons[state.getID()];
			}
			else
			{
				return this.getIcon(ForgeDirection.DOWN.ordinal(), meta);
			}
		}
		else if (this.sideIcons[state.getID()] != null)
		{
			return this.sideIcons[state.getID()];
		}
		else
		{
			return this.getIcon(ForgeDirection.UNKNOWN.ordinal(), meta);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == ForgeDirection.SOUTH.ordinal())
		{
			return this.frontIcons[MachineState.OFF.getID()];
		}
		else if (side == ForgeDirection.NORTH.ordinal())
		{
			return this.backIcons[MachineState.OFF.getID()];
		}
		else if (side == ForgeDirection.UP.ordinal())
		{
			return this.topIcons[MachineState.OFF.getID()];
		}
		else if (side == ForgeDirection.DOWN.ordinal())
		{
			return this.bottomIcons[MachineState.OFF.getID()];
		}
		else
		{
			return this.sideIcons[MachineState.OFF.getID()];
		}
	}
}
