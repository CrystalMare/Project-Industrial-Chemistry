package net.heavencraft.industrialchemistry.client.gui.inventory;

import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GUIMachineChemicalFurnace extends GUIPIC
{
	TEMachineChemicalFurnace machineChemicalFurnaceTE;

	public GUIMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
    {
	    super(new ContainerMachineChemicalFurnace(player, tile));
	    this.machineChemicalFurnaceTE = tile;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.drawTitle(machineChemicalFurnaceTE.getName());
	}
	
}
