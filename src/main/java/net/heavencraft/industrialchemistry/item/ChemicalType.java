package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Names;

public enum ChemicalType
{
	POTASSIUM_NITRATE	(Names.Item.ItemChemicalPotassiumNitrate),
	SULFUR_TRIOXIDE		(Names.Item.ItemChemicalSulfurTrioxide),
	AMMONIUM_NITRATE	(Names.Item.ItemChemicalPotassiumNitrate),
	LIMESTONE			(Names.Item.ItemChemicalLimestone),
	VANADIUM_OXIDE		(Names.Item.ItemChemicalVanadiumOxide),
	SULFUR				(Names.Item.ItemChemicalSulfur),
	SALTPETER			(Names.Item.ItemChemicalSaltpeter);
	
	private String name;
	
	ChemicalType(String name)
	{
		this.name = name;
	}
	
	public ItemChemical createNewInstance()
	{
		return (ItemChemical) new ItemChemical(this).setItemName(name);
	}
}
