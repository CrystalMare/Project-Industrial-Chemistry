package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Names;

public enum ChemicalType
{
	POTASSIUM_NITRATE	(Names.Item.ChemicalPotassiumNitrate),
	SULFUR_TRIOXIDE		(Names.Item.ChemicalSulfurTrioxide),
	AMMONIUM_NITRATE	(Names.Item.ChemicalPotassiumNitrate),
	LIMESTONE			(Names.Item.ChemicalLimestone),
	VANADIUM_OXIDE		(Names.Item.ChemicalVanadiumOxide),
	SULFUR				(Names.Item.ChemicalSulfur),
	SALTPETER			(Names.Item.ChemicalSaltpeter);
	
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
