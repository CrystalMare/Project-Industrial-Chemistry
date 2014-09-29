package net.heavencraft.industrialchemistry.handlers;

import net.heavencraft.industrialchemistry.client.gui.inventory.GUIMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.client.gui.inventory.GUITesting;
import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.inventory.ContainerTesting;
import net.heavencraft.industrialchemistry.reference.Gui;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		
		if (ID == Gui.ID.TestingBlock.getID())
		{
			TETestingBlock tile = (TETestingBlock) world.getTileEntity(x, y, z);
			return new ContainerTesting(player.inventory, tile);
		}
		if (ID == Gui.ID.MachineChemicalFurnace.getID())
		{
			TEMachineChemicalFurnace tile = (TEMachineChemicalFurnace) world.getTileEntity(x, y, z);
			return new ContainerMachineChemicalFurnace(player.inventory, tile);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Gui.ID.TestingBlock.ordinal())
		{
			TETestingBlock tile = (TETestingBlock) world.getTileEntity(x, y, z);
			return new GUITesting(player.inventory, tile);
		}
		if (ID == Gui.ID.MachineChemicalFurnace.getID())
		{
			TEMachineChemicalFurnace tile = (TEMachineChemicalFurnace) world.getTileEntity(x, y, z);
			return new GUIMachineChemicalFurnace(player.inventory, tile);
		}
		return null;
	}
	
}
