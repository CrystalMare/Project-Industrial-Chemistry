package net.heavencraft.industrialchemistry.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemChemical extends ItemPIC
{
	
	private ChemicalType type;
	
	public ItemChemical(ChemicalType type)
	{
		this.type = type;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advancedTooltips)
	{
		list.add(type.getFormula());
	}
	
}
