package net.heavencraft.industrialchemistry.block.machine;

import net.heavencraft.industrialchemistry.creativetab.CreativeTab;
import net.heavencraft.industrialchemistry.reference.Gui;
import net.heavencraft.industrialchemistry.reference.Names.Block.Machine;
import net.heavencraft.industrialchemistry.tileentity.machines.TEGreenHouseController;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GreenHouseController extends BaseBlockMachine
{
	public GreenHouseController()
	{
		this.setBlockName(Machine.GreenHouseController);
		this.setGUIID(Gui.ID.GreenHouseController);
		this.setCreativeTab(CreativeTab.PIC_TAB);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TEGreenHouseController();
	}
	
}
