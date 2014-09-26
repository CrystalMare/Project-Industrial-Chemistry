package net.heavencraft.industrialchemistry.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.heavencraft.industrialchemistry.item.*;
import net.heavencraft.industrialchemistry.reference.Names;


public class PICItems
{
	
	public static final ItemPIC crushedMalachiteOre = CrushedOreType.MALACHITE.createNewInstance();
	
	public static final ItemPIC chemicalPotassiumNitrate = ChemicalType.POTASSIUM_NITRATE.createNewInstance();
	public static final ItemPIC chemicalSulfurTrioxide = ChemicalType.SULFUR_TRIOXIDE.createNewInstance();
	public static final ItemPIC chemicalAmmoniumNitrate = ChemicalType.AMMONIUM_NITRATE.createNewInstance();
	public static final ItemPIC chemicalLimestone = ChemicalType.LIMESTONE.createNewInstance();
	public static final ItemPIC chemicalVanadiumOxide = ChemicalType.VANADIUM_OXIDE.createNewInstance();
	public static final ItemPIC chemicalSulfur = ChemicalType.SULFUR.createNewInstance();
	public static final ItemPIC chemicalSaltpeter = ChemicalType.SALTPETER.createNewInstance();
	
	public static void init()
	{
		GameRegistry.registerItem(crushedMalachiteOre, Names.Item.ItemCrushedMalachite);
		
		GameRegistry.registerItem(chemicalPotassiumNitrate, Names.Item.ItemChemicalPotassiumNitrate);
		GameRegistry.registerItem(chemicalSulfurTrioxide, Names.Item.ItemChemicalSulfurTrioxide);
		GameRegistry.registerItem(chemicalAmmoniumNitrate, Names.Item.ItemChemicalAmmoniumNitrate);
		GameRegistry.registerItem(chemicalLimestone, Names.Item.ItemChemicalLimestone);
		GameRegistry.registerItem(chemicalVanadiumOxide, Names.Item.ItemChemicalVanadiumOxide);
		GameRegistry.registerItem(chemicalSulfur, Names.Item.ItemChemicalSulfur);
		GameRegistry.registerItem(chemicalSaltpeter, Names.Item.ItemChemicalSaltpeter);
	}
}
