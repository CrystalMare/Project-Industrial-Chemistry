package net.heavencraft.industrialchemistry.tileentity;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TETestingBlock extends TEBlockPIC
{	
	public TETestingBlock()
	{
		this.setName(Names.Block.BLOCKTESTING);
	}
	
	@Override
	public void updateEntity()
	{

	}
	
	@Override
	public void readFromNBT(NBTTagCompound NBTTagCompound)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound NBTTagCompound)
	{
		// TODO Auto-generated method stub
		
	}
	
}
