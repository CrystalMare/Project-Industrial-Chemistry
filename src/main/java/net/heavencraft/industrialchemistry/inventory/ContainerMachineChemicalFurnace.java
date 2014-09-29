package net.heavencraft.industrialchemistry.inventory;

import org.lwjgl.util.Point;

import cpw.mods.fml.common.FMLCommonHandler;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMachineChemicalFurnace extends ContainerPIC
{
	private static Point offset = Textures.GUI.ChemicalFurnace.InventoryOffset;
	private static Point inputSlot = Textures.GUI.ChemicalFurnace.InputSlot;
	private static Point outputSlot = Textures.GUI.ChemicalFurnace.OutputSlot;
	
	
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	public ContainerMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		
		this.machineChemicalFurnaceTE = tile;
		this.drawInv(player, 0, 78);
		addSlot(tile, 0, inputSlot.getX(), inputSlot.getY());
		addSlot(tile, 1, outputSlot.getX(), outputSlot.getY());
		System.out.println("Container open on " + FMLCommonHandler.instance().getEffectiveSide());
	}
}
