package net.heavencraft.industrialchemistry.reference;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

import net.heavencraft.industrialchemistry.helpers.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
	public static final String RESOURCE_PREFIX = Names.Mod.ID.toLowerCase() + ":";
	
	public static final class GUI
	{
		public static final class BaseGui
		{
			public static final ResourceLocation BaseGuiResource = ResourceLocationHelper.getGuiLocation("BaseGui.png");
			public static final Rectangle Gui = new Rectangle(0, 0, 176, 166);
		}
		
		public static final ResourceLocation LiquidBar = ResourceLocationHelper.getGuiLocation("LiquidBar.png");
		public static final ResourceLocation LiquidBarOverlay = ResourceLocationHelper.getGuiLocation("LiquidBarOverlay.png");
		public static final ResourceLocation Slot = ResourceLocationHelper.getGuiLocation("Slot.png");
		
		// Chemical Furnace
		public static final class ChemicalFurnace
		{
			public static final ResourceLocation GuiResource = ResourceLocationHelper.getGuiLocation("ChemicalFurnaceGUI.png");
			public static final Rectangle Gui = new Rectangle(0, 0, 176, 244);
			public static final Point InventoryOffset = new Point(0, 0);
			public static final Rectangle ProgressArrow = new Rectangle(192, 0, 14, 48);
			public static final Rectangle Gauge = new Rectangle(176, 0, 16, 49);
			public static final Point InputSlot = new Point(26, 88);
			public static final Point OutputSlot = new Point(134, 137);
			
		}
		
	}
	
	public static final class Block
	{
		public static final class Machine
		{
			
			// Chemical Furnace
			public static final String ChemicalFurnaceFrontOff = ResourceLocationHelper.getBlockLocation("chemicalFurnace_front_off");
			public static final String ChemicalFurnaceFrontOn = ResourceLocationHelper.getBlockLocation("chemicalFurnace_front_on");
			public static final String ChemicalFurnaceTop = ResourceLocationHelper.getBlockLocation("chemicalFurnace_top"); // Fan
			public static final String ChemicalFurnaceSide = ResourceLocationHelper.getBlockLocation("chemicalFurnace_side");
		}
		
		public static final class Fluids
		{
			public static final String OxygenStill = "oxygenStill";
			public static final String OxygenFlowing = "oxygenFlowing";
		}
		
		public static final String MalachiteOre = ResourceLocationHelper.getBlockLocation("malachiteOre");
		public static final String TestBlock = ResourceLocationHelper.getBlockLocation("testBlock");
	}
	
	public static final class Item
	{
		public static final String CrushedMalachite = ResourceLocationHelper.getItemLocation("crushedMalachite");
	}
}
