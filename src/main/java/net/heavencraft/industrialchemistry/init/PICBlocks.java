package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.block.BlockPIC;
import net.heavencraft.industrialchemistry.block.BlockTesting;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class PICBlocks
{
	//Declare a public static final BlockPIC here
	
	public static final BlockPIC blockTesting = new BlockTesting();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockTesting, Names.Block.BLOCKTESTING);
	}
}
