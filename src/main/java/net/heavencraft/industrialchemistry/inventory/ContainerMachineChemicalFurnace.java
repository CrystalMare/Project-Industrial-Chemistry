package net.heavencraft.industrialchemistry.inventory;

import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMachineChemicalFurnace extends ContainerPIC
{
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	public ContainerMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		this.machineChemicalFurnaceTE = tile;
		this.drawInv(player);
	}
}
