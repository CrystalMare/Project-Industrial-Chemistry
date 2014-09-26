package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Names;

public enum CrushedOreType
{
	
	MALACHITE(Names.Item.ItemCrushedMalachite);
	
	private String name;
	
	CrushedOreType(String name) {
		this.name = name;
	}
	
	public ItemCrushedOre createNewInstance()
	{
		return (ItemCrushedOre) new ItemCrushedOre(this).setItemName(name);
	}
}
