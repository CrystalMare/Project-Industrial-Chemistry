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
		
		public static final ResourceLocation Sprites = ResourceLocationHelper.getGuiLocation("sprites.png");
		
		public static final ResourceLocation LiquidBar = ResourceLocationHelper.getGuiLocation("LiquidBar.png");
		public static final ResourceLocation LiquidBarOverlay = ResourceLocationHelper.getGuiLocation("LiquidBarOverlay.png");
		public static final ResourceLocation Slot = ResourceLocationHelper.getGuiLocation("Slot.png");
		
		// Chemical Furnace
		public static final class ChemicalFurnace
		{
			public static final ResourceLocation GuiResource = ResourceLocationHelper.getGuiLocation("ChemicalFurnaceGUI.png");
			public static final Rectangle Gui = new Rectangle(0, 0, 176, 244);
			public static final Point InventoryOffset = new Point(0, 78);
			public static final Rectangle ProgressArrow = new Rectangle(192, 0, 14, 48);
			public static final Rectangle Gauge = new Rectangle(176, 0, 16, 49);
			public static final Point InputSlot = new Point(26, 88);
			public static final Point OutputSlot = new Point(134, 137);
			
		}
		
		public static final class Grinder
		{
			public static final ResourceLocation GuiResource = ResourceLocationHelper.getGuiLocation("grinder.png");
			public static final Rectangle Gui = new Rectangle(0, 0, 176, 166);
			public static final Point InventoryOffset = new Point(0, 0);
			public static final Rectangle ProgressArrow = new Rectangle(176, 0, 23, 15);
			public static final Point PowerSlot = new Point(8, 62);
			public static final Point InputSlot = new Point(50, 24);
			public static final Point OutputSlot = new Point(110, 25);
			public static final Point OutputSlot2 = new Point(110, 50);
		}
		
	}
	
	public static final class Block
	{
		public static final class Machine
		{
			
			// Chemical Furnace
			public static final String ChemicalFurnaceFrontOff = ResourceLocationHelper.getBlockLocation("chemicalFurnace_front_off");
			public static final String ChemicalFurnaceFrontOn = ResourceLocationHelper.getBlockLocation("chemicalFurnace_front_on");
			public static final String ChemicalFurnaceTop = ResourceLocationHelper.getBlockLocation("chemicalFurnace_top");
			public static final String ChemicalFurnaceTopOn = ResourceLocationHelper.getBlockLocation("fan_on");// Fan
			public static final String ChemicalFurnaceSide = ResourceLocationHelper.getBlockLocation("chemicalFurnace_side");
			
			// Grinder
			public static final String GrinderFrontOff = ResourceLocationHelper.getBlockLocation("grinder_front_off");
			public static final String GrinderFrontOn = ResourceLocationHelper.getBlockLocation("grinder_front_on");
		}
		
		public static final class Fluids
		{
			public static String getStillIconLocation(String name)
			{
				return name.toLowerCase() + "Still";
			}
			
			public static String getFlowingIconLocation(String name)
			{
				return name.toLowerCase() + "Flowing";
			}
			
			public static String getBucketIconLocation(String name)
			{
				return name.toLowerCase() + "_Bucket";
			}
		}
		
		public static final String MalachiteOre = ResourceLocationHelper.getBlockLocation("malachiteOre");
		public static final String TestBlock = ResourceLocationHelper.getBlockLocation("testBlock");
	}
}
