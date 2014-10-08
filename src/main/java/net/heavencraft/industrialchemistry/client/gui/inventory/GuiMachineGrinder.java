package net.heavencraft.industrialchemistry.client.gui.inventory;

import net.heavencraft.industrialchemistry.client.gui.inventory.elements.ElementInventorySlot;
import net.heavencraft.industrialchemistry.client.gui.inventory.elements.ElementInventorySlotBig;
import net.heavencraft.industrialchemistry.inventory.ContainerMachineGrinder;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.util.Rectangle;

import cofh.lib.gui.GuiBase;
import cofh.lib.gui.element.ElementBase;
import cofh.lib.gui.element.ElementEnergyStored;

public class GuiMachineGrinder extends GuiBase
{
	private TEMachineGrinder machineGrinder;
	
	private ElementBase energyGauge;
	private ElementBase inputSlot;
	private ElementBase outputSlot;
	private ElementBase outputSlot2;
	private ElementBase inputPowerSlot;
	
	public GuiMachineGrinder(InventoryPlayer player, TEMachineGrinder tile) {
		super(new ContainerMachineGrinder(player, tile), Textures.GUI.Grinder.GuiResource);
		machineGrinder = tile;		
	}
	
	@Override
	public void initGui() {
		super.initGui();
		energyGauge = addElement(new ElementEnergyStored(this, 8, 8, machineGrinder.getEnergyStorage()));
		inputSlot =  addElement(new ElementInventorySlot(this, Textures.GUI.Grinder.InputSlot));
		outputSlot = addElement(new ElementInventorySlotBig(this, Textures.GUI.Grinder.OutputSlot));
		outputSlot2 = addElement(new ElementInventorySlot(this, Textures.GUI.Grinder.OutputSlot2));
		inputPowerSlot = addElement(new ElementInventorySlot(this, Textures.GUI.Grinder.PowerSlot));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		drawArrow();
	}
	
	private void drawArrow()
	{
		
		mc.getTextureManager().bindTexture(Textures.GUI.Grinder.GuiResource);
		Rectangle arrow = Textures.GUI.Grinder.ProgressArrow;
		Rectangle arrowbg = Textures.GUI.Grinder.PogresssArrowBG;
		int offset = (int) (machineGrinder.getProgress() * arrow.getWidth());
		int startX = guiLeft + 74;
		int startY = guiTop + 33;
		drawTexturedModalRect(startX, startY, arrowbg.getX(), arrowbg.getY(), arrowbg.getWidth(), arrowbg.getHeight());
		drawTexturedModalRect(startX, startY, arrow.getX(), arrow.getY(), offset, arrow.getHeight());
	}
}
