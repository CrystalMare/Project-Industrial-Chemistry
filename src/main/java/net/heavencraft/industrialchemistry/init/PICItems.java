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
		GameRegistry.registerItem(crushedMalachiteOre, Names.Item.CrushedMalachite);
		
		GameRegistry.registerItem(chemicalPotassiumNitrate, Names.Item.ChemicalPotassiumNitrate);
		GameRegistry.registerItem(chemicalSulfurTrioxide, Names.Item.ChemicalSulfurTrioxide);
		GameRegistry.registerItem(chemicalAmmoniumNitrate, Names.Item.ChemicalAmmoniumNitrate);
		GameRegistry.registerItem(chemicalLimestone, Names.Item.ChemicalLimestone);
		GameRegistry.registerItem(chemicalVanadiumOxide, Names.Item.ChemicalVanadiumOxide);
		GameRegistry.registerItem(chemicalSulfur, Names.Item.ChemicalSulfur);
		GameRegistry.registerItem(chemicalSaltpeter, Names.Item.ChemicalSaltpeter);
	}
}
