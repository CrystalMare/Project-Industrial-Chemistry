package net.heavencraft.industrialchemistry.client.gui.inventory;

import net.heavencraft.industrialchemistry.inventory.ContainerTesting;
import net.heavencraft.industrialchemistry.tileentity.TETestingBlock;
import net.minecraft.entity.player.InventoryPlayer;

public class GUITesting extends BaseGuiContainer
{
	private TETestingBlock testingTE;
	
	public GUITesting(InventoryPlayer player, TETestingBlock tile)
	{
		super(new ContainerTesting(player, tile));
		this.testingTE = tile;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.drawTitle(testingTE.getName());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
	}
	
}
