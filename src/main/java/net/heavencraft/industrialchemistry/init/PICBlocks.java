package net.heavencraft.industrialchemistry.init;

import net.heavencraft.industrialchemistry.block.BlockPIC;
import net.heavencraft.industrialchemistry.block.BlockTesting;
import net.heavencraft.industrialchemistry.block.machine.MachineChemicalFurnace;
import net.heavencraft.industrialchemistry.block.ores.BlockOreMalachite;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.reference.Names.Block.Machine;
import cpw.mods.fml.common.registry.GameRegistry;

public class PICBlocks
{
	//Declare a public static final BlockPIC here

	public static final BlockPIC blockTesting = new BlockTesting();
	public static final BlockPIC oreMalachite = new BlockOreMalachite();
	
	
	//Machines
	public static final BlockPIC machineChemicalFurnace = new MachineChemicalFurnace();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockTesting, Names.Block.BLOCKTESTING);
		GameRegistry.registerBlock(oreMalachite, Names.Block.OreMalachite);
		GameRegistry.registerBlock(machineChemicalFurnace, Names.Block.Machine.MachineChemicalFurnace);
	}
}
