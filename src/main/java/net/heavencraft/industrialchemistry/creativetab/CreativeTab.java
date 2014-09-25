package net.heavencraft.industrialchemistry.creativetab;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTab
{
	public static final CreativeTabs PIC_TAB = new CreativeTabs(Names.Mod.ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return Items.clock;
		}
	};
}
