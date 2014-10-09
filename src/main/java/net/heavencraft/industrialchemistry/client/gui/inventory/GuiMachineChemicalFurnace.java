package net.heavencraft.industrialchemistry.client.gui.inventory;

import java.awt.Color;

import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import cofh.lib.gui.GuiBase;
import cofh.lib.gui.element.ElementBase;
import cofh.lib.gui.element.ElementFluidTank;

public class GuiMachineChemicalFurnace extends GuiBase
{
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	private ElementBase elementTank;
	
	public GuiMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		super(new ContainerMachineChemicalFurnace(player, tile), Textures.GUI.ChemicalFurnace.GuiResource);
		this.machineChemicalFurnaceTE = tile;
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		elementTank = addElement(new ElementFluidTank(this, 40, 40, machineChemicalFurnaceTE.getTank()));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		fontRendererObj.drawString("Temp: " + machineChemicalFurnaceTE.getTemp(), 8, 24, Color.darkGray.getRGB());
		fontRendererObj.drawString("RF/t: " + machineChemicalFurnaceTE.getEnergyUsage(), 8, 40, Color.darkGray.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		drawArrow();
	}
	
	public void drawArrow()
	{
		double progress = machineChemicalFurnaceTE.getProgress();
		mc.getTextureManager().bindTexture(Textures.GUI.ChemicalFurnace.GuiResource);
		Rectangle arrow = Textures.GUI.ChemicalFurnace.ProgressIndicator;
		Rectangle gui = Textures.GUI.ChemicalFurnace.Gui;
		int offset = (int) (progress * arrow.getHeight());
		int startX = guiLeft + 81;
		int startY = guiTop + 33 + arrow.getHeight() - offset;
		this.drawTexturedModalRect(startX, startY, arrow.getX(), arrow.getY() + arrow.getHeight() - offset, arrow.getWidth(), offset);
	}
	
}
