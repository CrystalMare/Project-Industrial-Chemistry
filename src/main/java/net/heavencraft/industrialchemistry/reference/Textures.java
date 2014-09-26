package net.heavencraft.industrialchemistry.reference;

import net.heavencraft.industrialchemistry.helpers.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
	public static final String RESOURCE_PREFIX = Names.Mod.ID.toLowerCase() + ":";
	
	public static final class GUI
	{
		public static final ResourceLocation BaseGui = ResourceLocationHelper.getGuiLocation("BaseGui.png");
		public static final ResourceLocation LiquidBar = ResourceLocationHelper.getGuiLocation("LiquidBar.png");
		public static final ResourceLocation LiquidBarOverlay = ResourceLocationHelper.getGuiLocation("LiquidBarOverlay.png");
		public static final ResourceLocation Slot = ResourceLocationHelper.getGuiLocation("Slot.png");
	}
	
	
	public static final class Block
	{
		public static final String MalachiteOre = ResourceLocationHelper.getBlockLocation("malachiteOre");
	}
}
