package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Names;

public enum CrushedOreType
{
	
	MALACHITE(Names.Item.CrushedMalachite, "Cu2CO3(OH)2"),
	AZURITE(Names.Item.CrushedAzurite, "Cu3(CO3)2(OH)2");
	
	private String name;
	private String formula;
		
	CrushedOreType(String name, String formula) {
		this.name = name;
		this.formula = formula;
	}
	
	public ItemCrushedOre createNewInstance()
	{
		return (ItemCrushedOre) new ItemCrushedOre(this).setItemName(name);
	}
	
	public String getFormula()
	{
		return formula;
	}
}
