package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.item.BaseItem;
import net.heavencraft.industrialchemistry.item.FireExtinguisher;
import net.heavencraft.industrialchemistry.item.ItemAsh;
import net.heavencraft.industrialchemistry.item.ItemChemical;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;


public class IndustrialChemistryItems
{
	
	public static final BaseItem chemicalMalachite = ItemChemical.ChemicalType.MALACHITE.createNewInstance();
	public static final BaseItem chemicalAzurite = ItemChemical.ChemicalType.AZURITE.createNewInstance();
	
	public static final BaseItem chemicalPotassiumNitrate = ItemChemical.ChemicalType.POTASSIUM_NITRATE.createNewInstance();
	public static final BaseItem chemicalSulfurTrioxide = ItemChemical.ChemicalType.SULFUR_TRIOXIDE.createNewInstance();
	public static final BaseItem chemicalAmmoniumNitrate = ItemChemical.ChemicalType.AMMONIUM_NITRATE.createNewInstance();
	public static final BaseItem chemicalLimestone = ItemChemical.ChemicalType.LIMESTONE.createNewInstance();
	public static final BaseItem chemicalVanadiumOxide = ItemChemical.ChemicalType.VANADIUM_OXIDE.createNewInstance();
	public static final BaseItem chemicalSulfur = ItemChemical.ChemicalType.SULFUR.createNewInstance();
	public static final BaseItem chemicalSaltpeter = ItemChemical.ChemicalType.SALTPETER.createNewInstance();
	public static final BaseItem chemicalCopperOxide = ItemChemical.ChemicalType.COPPER_OXIDE.createNewInstance();
	
	public static final BaseItem toolFireExtinguisher = new FireExtinguisher();
	
	
	public static final BaseItem itemAsh = new ItemAsh();
	
	public static void init()
	{
		GameRegistry.registerItem(chemicalMalachite, Names.Item.ChemicalMalachite);
		GameRegistry.registerItem(chemicalAzurite, Names.Item.ChemicalAzurite);
		
		GameRegistry.registerItem(chemicalPotassiumNitrate, Names.Item.ChemicalPotassiumNitrate);
		GameRegistry.registerItem(chemicalSulfurTrioxide, Names.Item.ChemicalSulfurTrioxide);
		GameRegistry.registerItem(chemicalAmmoniumNitrate, Names.Item.ChemicalAmmoniumNitrate);
		GameRegistry.registerItem(chemicalLimestone, Names.Item.ChemicalLimestone);
		GameRegistry.registerItem(chemicalVanadiumOxide, Names.Item.ChemicalVanadiumOxide);
		GameRegistry.registerItem(chemicalSulfur, Names.Item.ChemicalSulfur);
		GameRegistry.registerItem(chemicalSaltpeter, Names.Item.ChemicalSaltpeter);
		GameRegistry.registerItem(chemicalCopperOxide, Names.Item.ChemicalCopperOxide);
		GameRegistry.registerItem(itemAsh, Names.Item.Ash);
		GameRegistry.registerItem(toolFireExtinguisher, Names.Item.FireExtinquisher);
	}
}
