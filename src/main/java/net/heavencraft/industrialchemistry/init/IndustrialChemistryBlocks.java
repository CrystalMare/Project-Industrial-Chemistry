package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.block.BaseBlock;
import net.heavencraft.industrialchemistry.block.BlockTesting;
import net.heavencraft.industrialchemistry.block.machine.MachineChemicalFurnace;
import net.heavencraft.industrialchemistry.block.machine.MachineGrinder;
import net.heavencraft.industrialchemistry.block.ores.BlockOreMalachite;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class IndustrialChemistryBlocks
{
	public static final BaseBlock blockTesting = new BlockTesting();
	public static final BaseBlock oreMalachite = new BlockOreMalachite();
	
	public static final BaseBlock machineChemicalFurnace = new MachineChemicalFurnace();
	public static final BaseBlock machineGrinder = new MachineGrinder();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockTesting, Names.Block.BLOCKTESTING);
		GameRegistry.registerBlock(oreMalachite, Names.Block.OreMalachite);
		GameRegistry.registerBlock(machineChemicalFurnace, Names.Block.Machine.MachineChemicalFurnace);
		GameRegistry.registerBlock(machineGrinder, Names.Block.Machine.MachineGrinder);
	}
}
