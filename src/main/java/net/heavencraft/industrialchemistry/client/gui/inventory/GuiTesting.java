package net.heavencraft.industrialchemistry.client.gui.inventory;

import net.heavencraft.industrialchemistry.inventory.ContainerTesting;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiTesting extends BaseGuiContainer
{
	private TETestingBlock testingTE;
	
	public GuiTesting(InventoryPlayer player, TETestingBlock tile)
	{
		super(new ContainerTesting(player, tile));
		this.testingTE = tile;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.drawTitle(testingTE.getName());
		mc.getTextureManager().bindTexture(Textures.GUI.Sprites);
		//Args: x, y, u, v, width, height
		
		drawTexturedModalRect(50, 20, 0, 0, 32, 64);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

	}
	
}
