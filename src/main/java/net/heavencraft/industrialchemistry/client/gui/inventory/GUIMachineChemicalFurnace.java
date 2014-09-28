package net.heavencraft.industrialchemistry.client.gui.inventory;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
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
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(Textures.GUI.ChemicalFurnace.GuiResource);
		Rectangle window = Textures.GUI.ChemicalFurnace.Gui;
		int startX = (width - window.getWidth()) / 2;
		int startY = (height - window.getHeight()) / 2;
		this.drawTexturedModalRect(startX, startY, window.getX(), window.getY(), window.getWidth(), window.getHeight());
	}
	
}
