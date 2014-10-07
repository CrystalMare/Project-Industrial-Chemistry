package net.heavencraft.industrialchemistry.client.gui.inventory.elements;

import net.heavencraft.industrialchemistry.reference.Textures;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import cofh.lib.gui.GuiBase;
import cofh.lib.gui.element.ElementSimple;

public class ElementInventorySlotBig extends ElementSimple
{
	public ElementInventorySlotBig(GuiBase gui, int posX, int posY) {
		super(gui, posX, posY);
		texture = Textures.GUI.SpriteSheet.BaseResource;
		Rectangle box = Textures.GUI.SpriteSheet.InventorySlotBig;
		setTextureOffsets(box.getX(), box.getY());
		setSize(box.getWidth(), box.getHeight());
	}
	
	public ElementInventorySlotBig(GuiBase gui, Point slotpos)
	{
		this(gui, slotpos.getX(), slotpos.getY());
	}
}
