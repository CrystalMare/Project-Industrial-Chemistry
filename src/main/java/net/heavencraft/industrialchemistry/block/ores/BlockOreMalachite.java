package net.heavencraft.industrialchemistry.block.ores;

import net.heavencraft.industrialchemistry.creativetab.CreativeTab;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.reference.Textures;

public class BlockOreMalachite extends BaseBlockOre
{
	public BlockOreMalachite()
	{
		this.setBlockName(Names.Block.OreMalachite);
		this.setTexture(Textures.Block.MalachiteOre);
		this.setCreativeTab(CreativeTab.PIC_TAB);
	}
}
