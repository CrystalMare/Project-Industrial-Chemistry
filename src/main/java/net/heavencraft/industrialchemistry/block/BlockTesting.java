package net.heavencraft.industrialchemistry.block;

import net.heavencraft.industrialchemistry.reference.Gui;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTesting extends BaseBlock implements ITileEntityProvider
{
	public BlockTesting()
	{
		this.setBlockName("TestBlock");
		this.setTexture(Textures.Block.TestBlock);
		this.setGUIID(Gui.ID.TestingBlock);
	}

	@Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
	    return new TETestingBlock();
    }	
}
