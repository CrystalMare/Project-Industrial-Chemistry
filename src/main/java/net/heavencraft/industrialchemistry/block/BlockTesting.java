package net.heavencraft.industrialchemistry.block;

import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTesting extends BlockPIC implements ITileEntityProvider
{
	public BlockTesting()
	{
		this.setBlockName("TestBlock");
	}

	@Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
	    return new TETestingBlock();
    }
	
}
