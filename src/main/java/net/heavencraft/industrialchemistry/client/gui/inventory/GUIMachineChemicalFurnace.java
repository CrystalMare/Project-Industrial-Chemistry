package net.heavencraft.industrialchemistry.client.gui.inventory;

import java.awt.Color;

import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

public class GuiMachineChemicalFurnace extends BaseGuiContainer
{
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	public GuiMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
	{
		super(new ContainerMachineChemicalFurnace(player, tile));
		this.machineChemicalFurnaceTE = tile;
		
	}
	
	@Override
	public void initGui()
	{
		this.mc.thePlayer.openContainer = this.inventorySlots;
		this.xSize = Textures.GUI.ChemicalFurnace.Gui.getWidth();
		this.ySize = Textures.GUI.ChemicalFurnace.Gui.getHeight();
		this.guiLeft = (this.width - xSize) / 2;
		this.guiTop = (this.height - ySize) / 2;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		drawTitle(machineChemicalFurnaceTE.getName());
		fontRendererObj.drawString("Temp: " + machineChemicalFurnaceTE.getTemp(),8 , 24, Color.darkGray.getRGB());
		fontRendererObj.drawString("RF/t: " + machineChemicalFurnaceTE.getEnergyUsage(),8 , 40, Color.darkGray.getRGB());
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(Textures.GUI.ChemicalFurnace.GuiResource);
		Rectangle gui = Textures.GUI.ChemicalFurnace.Gui;
		int startX = (width - gui.getWidth()) / 2;
		int startY = (height - gui.getHeight()) / 2;
		this.drawTexturedModalRect(startX, startY, gui.getX(), gui.getY(), gui.getWidth(), gui.getHeight());
		drawArrow();
	}
	
	public void drawArrow()
	{
		double progress = machineChemicalFurnaceTE.getProgress();
		mc.getTextureManager().bindTexture(Textures.GUI.ChemicalFurnace.GuiResource);
		Rectangle arrow = Textures.GUI.ChemicalFurnace.ProgressArrow;
		Rectangle gui = Textures.GUI.ChemicalFurnace.Gui;
		int offset = (int) (progress * arrow.getHeight());
		int startX = guiLeft + 81;
		int startY = guiTop + 33 + arrow.getHeight() - offset;
		this.drawTexturedModalRect(startX, startY, arrow.getX(), arrow.getY() + arrow.getHeight() - offset, arrow.getWidth(), offset);
	}
	
}
