package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.item.Item;

public class ItemPIC extends Item
{
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}
