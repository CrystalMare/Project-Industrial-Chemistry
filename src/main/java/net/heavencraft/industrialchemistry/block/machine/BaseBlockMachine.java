package net.heavencraft.industrialchemistry.block.machine;

import net.heavencraft.industrialchemistry.block.BaseBlock;
import net.heavencraft.industrialchemistry.helpers.BlockHelper;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BaseBlockMachine extends BaseBlock implements ITileEntityProvider
{
	protected TextureSet textures;
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
		int meta = blockAccess.getBlockMetadata(x, y, z);
	
		if (!(tileEntity instanceof BaseTEBlockPower)) return null;
				
		MachineState state = ((BaseTEBlockPower)tileEntity).getMachineState();
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
