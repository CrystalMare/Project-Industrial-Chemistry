package net.heavencraft.industrialchemistry.client.gui.inventory;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import net.heavencraft.industrialchemistry.inventory.ContainerMachineChemicalFurnace;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GUIMachineChemicalFurnace extends GuiPIC
{
	TEMachineChemicalFurnace machineChemicalFurnaceTE;
	
	public GUIMachineChemicalFurnace(InventoryPlayer player, TEMachineChemicalFurnace tile)
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
		drawTitle(String.valueOf(machineChemicalFurnaceTE.getProgress()));
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
		double scale = machineChemicalFurnaceTE.getProgress();
		mc.getTextureManager().bindTexture(Textures.GUI.ChemicalFurnace.GuiResource);
		Rectangle gui = Textures.GUI.ChemicalFurnace.Gui;
		int startX = (width - gui.getWidth()) / 2;
		int startY = (height - gui.getHeight()) / 2;
		Rectangle arrow = Textures.GUI.ChemicalFurnace.ProgressArrow;
		this.drawTexturedModalRect(startX, (int) (startY  * scale), arrow.getX(),(int) (arrow.getY()), arrow.getWidth(), (int) (arrow.getHeight()));
	}
	
}
