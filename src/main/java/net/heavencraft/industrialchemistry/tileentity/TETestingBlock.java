package net.heavencraft.industrialchemistry.tileentity;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.nbt.NBTTagCompound;

public class TETestingBlock extends BaseTEBlock
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
	}
	
	@Override
	public void writeToNBT(NBTTagCompound NBTTagCompound)
	{
	}
}
