package net.heavencraft.industrialchemistry.block;

import net.heavencraft.industrialchemistry.ProjectIndustrialChemistry;
import net.heavencraft.industrialchemistry.reference.GUIs;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTesting extends BlockPIC implements ITileEntityProvider
{
	public BlockTesting()
	{
		this.setBlockName("TestBlock");
		this.setGUIID(GUIs.ID.TestingBlock);
	}

	@Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
	    return new TETestingBlock();
    }	
}
