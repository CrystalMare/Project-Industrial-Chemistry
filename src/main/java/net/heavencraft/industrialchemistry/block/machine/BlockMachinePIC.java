package net.heavencraft.industrialchemistry.block.machine;

import java.util.Map.Entry;

import cofh.api.tileentity.ISidedTexture;
import net.heavencraft.industrialchemistry.block.BlockPIC;
import net.heavencraft.industrialchemistry.block.TextureSet;
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
	protected TextureSet textures;
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
	
		if (!(tileEntity instanceof TEBlockPICPower)) return null;
				
		MachineState state = ((TEBlockPICPower)tileEntity).getState();
		ForgeDirection frontFace = BlockHelper.getOrientation(meta);
		ForgeDirection face = ForgeDirection.getOrientation(side);
		
		return textures.getTextureForFacing(frontFace, face, state);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return textures.getTexture(ForgeDirection.getOrientation(side), MachineState.OFF);
	}
}
