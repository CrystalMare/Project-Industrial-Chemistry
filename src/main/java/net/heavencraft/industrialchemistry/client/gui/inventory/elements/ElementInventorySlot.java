package net.heavencraft.industrialchemistry.client.gui.inventory.elements;

import org.lwjgl.util.Rectangle;
import org.lwjgl.util.Point;

import net.heavencraft.industrialchemistry.reference.Textures;
import cofh.lib.gui.GuiBase;
import cofh.lib.gui.element.ElementSimple;

public class ElementInventorySlot extends ElementSimple
{

	public ElementInventorySlot(GuiBase gui, int posX, int posY) {
		super(gui, posX, posY);
		texture = Textures.GUI.SpriteSheet.BaseResource;
		Rectangle box = Textures.GUI.SpriteSheet.InventorySlot;
		setTextureOffsets(box.getX(), box.getY());
		setSize(box.getWidth(), box.getHeight());
	}
	
	public ElementInventorySlot(GuiBase gui, Point slotpos)
	{
		this(gui, slotpos.getX(), slotpos.getY());
	}
}
