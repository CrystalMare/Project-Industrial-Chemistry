package net.heavencraft.industrialchemistry.inventory;

import org.lwjgl.util.Point;

import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMachineChemicalFurnace extends ContainerPIC
{
	private static Point offset = Textures.GUI.ChemicalFurnace.InventoryOffset;
	
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	public ContainerMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		this.machineChemicalFurnaceTE = tile;
		this.drawInv(player, offset.getX(), offset.getY() + 20);
	}
}
