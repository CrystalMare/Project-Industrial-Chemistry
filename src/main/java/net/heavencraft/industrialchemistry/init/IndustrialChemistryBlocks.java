package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.block.*;
import net.heavencraft.industrialchemistry.block.machine.*;
import net.heavencraft.industrialchemistry.block.ores.*;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class IndustrialChemistryBlocks
{
	public static final BaseBlock blockTesting = new BlockTesting();
	public static final BaseBlock oreMalachite = new BlockOreMalachite();
	
	public static final BaseBlock machineChemicalFurnace = new MachineChemicalFurnace();
	public static final BaseBlock machineGrinder = new MachineGrinder();
	public static final BaseBlock greenHouseController = new GreenHouseController();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockTesting, Names.Block.BLOCKTESTING);
		GameRegistry.registerBlock(oreMalachite, Names.Block.OreMalachite);
		GameRegistry.registerBlock(machineChemicalFurnace, Names.Block.Machine.MachineChemicalFurnace);
		GameRegistry.registerBlock(machineGrinder, Names.Block.Machine.MachineGrinder);
		GameRegistry.registerBlock(greenHouseController, Names.Block.Machine.GreenHouseController);
	}
}
