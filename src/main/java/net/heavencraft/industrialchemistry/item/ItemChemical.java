package net.heavencraft.industrialchemistry.item;

import java.util.List;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemChemical extends BaseItem
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

	public enum ChemicalType
	{
		POTASSIUM_NITRATE	(Names.Item.ChemicalPotassiumNitrate, "KNO3"),
		SULFUR_TRIOXIDE		(Names.Item.ChemicalSulfurTrioxide, "SO3"),
		AMMONIUM_NITRATE	(Names.Item.ChemicalAmmoniumNitrate, "(NH4)(NO3)"),
		LIMESTONE			(Names.Item.ChemicalLimestone, "CaCO3"),
		VANADIUM_OXIDE		(Names.Item.ChemicalVanadiumOxide, "V2O5"),
		SULFUR				(Names.Item.ChemicalSulfur, "S"),
		SALTPETER			(Names.Item.ChemicalSaltpeter, "KNO3"),
		COPPER_OXIDE		(Names.Item.ChemicalCopperOxide, "CuO"),
		MALACHITE			(Names.Item.ChemicalMalachite, "Cu2CO3(OH)2"),
		AZURITE				(Names.Item.ChemicalAzurite, "Cu3(CO3)2(OH)2");
		
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
}
