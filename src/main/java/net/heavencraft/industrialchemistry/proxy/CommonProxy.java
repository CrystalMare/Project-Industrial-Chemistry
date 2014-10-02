package net.heavencraft.industrialchemistry.proxy;

import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy
{
	
	@Override
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TEMachineChemicalFurnace.class, "tile" + Names.Block.Machine.MachineChemicalFurnace);
		GameRegistry.registerTileEntity(TETestingBlock.class, "tile" + Names.Block.BLOCKTESTING);
		GameRegistry.registerTileEntity(TEMachineGrinder.class, "tile" + Names.Block.Machine.MachineGrinder);

	}
	
	@Override
	public void registerEventHandlers()
	{
		// TODO Auto-generated method stub
		
	}
}
