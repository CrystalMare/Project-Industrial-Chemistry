package net.heavencraft.industrialchemistry.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.heavencraft.industrialchemistry.item.*;
import net.heavencraft.industrialchemistry.reference.Names;


public class Items
{
	
	public static final BaseItem crushedMalachite = CrushedOreType.MALACHITE.createNewInstance();
	public static final BaseItem crushedAzurite = CrushedOreType.AZURITE.createNewInstance();
	
	public static final BaseItem chemicalPotassiumNitrate = ChemicalType.POTASSIUM_NITRATE.createNewInstance();
	public static final BaseItem chemicalSulfurTrioxide = ChemicalType.SULFUR_TRIOXIDE.createNewInstance();
	public static final BaseItem chemicalAmmoniumNitrate = ChemicalType.AMMONIUM_NITRATE.createNewInstance();
	public static final BaseItem chemicalLimestone = ChemicalType.LIMESTONE.createNewInstance();
	public static final BaseItem chemicalVanadiumOxide = ChemicalType.VANADIUM_OXIDE.createNewInstance();
	public static final BaseItem chemicalSulfur = ChemicalType.SULFUR.createNewInstance();
	public static final BaseItem chemicalSaltpeter = ChemicalType.SALTPETER.createNewInstance();
	public static final BaseItem chemicalCopperOxide = ChemicalType.COPPER_OXIDE.createNewInstance();
	
	public static void init()
	{
		GameRegistry.registerItem(crushedMalachite, Names.Item.CrushedMalachite);
		GameRegistry.registerItem(crushedAzurite, Names.Item.CrushedAzurite);
		
		GameRegistry.registerItem(chemicalPotassiumNitrate, Names.Item.ChemicalPotassiumNitrate);
		GameRegistry.registerItem(chemicalSulfurTrioxide, Names.Item.ChemicalSulfurTrioxide);
		GameRegistry.registerItem(chemicalAmmoniumNitrate, Names.Item.ChemicalAmmoniumNitrate);
		GameRegistry.registerItem(chemicalLimestone, Names.Item.ChemicalLimestone);
		GameRegistry.registerItem(chemicalVanadiumOxide, Names.Item.ChemicalVanadiumOxide);
		GameRegistry.registerItem(chemicalSulfur, Names.Item.ChemicalSulfur);
		GameRegistry.registerItem(chemicalSaltpeter, Names.Item.ChemicalSaltpeter);
		GameRegistry.registerItem(chemicalCopperOxide, Names.Item.ChemicalCopperOxide);
	}
}
