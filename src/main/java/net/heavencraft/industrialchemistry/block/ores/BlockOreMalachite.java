package net.heavencraft.industrialchemistry.block.ores;

import net.heavencraft.industrialchemistry.block.BaseBlock;
import net.heavencraft.industrialchemistry.creativetab.CreativeTab;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.reference.Textures;

public class BlockOreMalachite extends BaseBlock
{
	public BlockOreMalachite()
	{
		setBlockName(Names.Block.OreMalachite);
		setTexture(Textures.Block.MalachiteOre);
		setCreativeTab(CreativeTab.PIC_TAB);
		setHardness(3.0F);
		setResistance(5.0F);
	}
}
