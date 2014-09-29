package net.heavencraft.industrialchemistry.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCrushedOre extends BaseItem
{
	
	private CrushedOreType type;
	
	public ItemCrushedOre(CrushedOreType type)
	{
		this.type = type;	
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(type.getFormula());
	}

}
