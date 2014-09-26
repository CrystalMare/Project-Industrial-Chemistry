package net.heavencraft.industrialchemistry.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.heavencraft.industrialchemistry.item.*;
import net.heavencraft.industrialchemistry.reference.Names;


public class PICItems
{
	
	public static final ItemPIC crushedMalachiteOre = CrushedOreType.MALACHITE.createNewInstance();
	
	public static void init()
	{
		GameRegistry.registerItem(crushedMalachiteOre, Names.Item.ItemCrushedMalachite);
	}
}
