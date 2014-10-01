package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.reference.Names;

public enum ChemicalType
{
	POTASSIUM_NITRATE	(Names.Item.ChemicalPotassiumNitrate, "KNO3"),
	SULFUR_TRIOXIDE		(Names.Item.ChemicalSulfurTrioxide, "SO3"),
	AMMONIUM_NITRATE	(Names.Item.ChemicalAmmoniumNitrate, "(NH4)(NO3)"),
	LIMESTONE			(Names.Item.ChemicalLimestone, "CaCO3"),
	VANADIUM_OXIDE		(Names.Item.ChemicalVanadiumOxide, "V2O5"),
	SULFUR				(Names.Item.ChemicalSulfur, "S"),
	SALTPETER			(Names.Item.ChemicalSaltpeter, "KNO3"),
	COPPER_OXIDE		(Names.Item.ChemicalCopperOxide, "CuO");
	
	private String name;
	private String formula;
	
	ChemicalType(String name, String formula)
	{
		this.name = name;
		this.formula = formula;
	}
	
	public ItemChemical createNewInstance()
	{
		return (ItemChemical) new ItemChemical(this).setItemName(name);
	}
	
	public String getFormula()
	{
		return formula;
	}
}
