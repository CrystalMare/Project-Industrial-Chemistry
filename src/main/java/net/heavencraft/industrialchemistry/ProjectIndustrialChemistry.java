package net.heavencraft.industrialchemistry;

import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Names.Mod.ID, name = Names.Mod.Name, version = Names.Mod.Version)
public class ProjectIndustrialChemistry
{
	@Instance(Names.Mod.ID)
	public static ProjectIndustrialChemistry instance;
	
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		// Register Commands
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Init Config
		// Init PacketHandler
		// Init Items
		// Init Blocks
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register Gui Handler
		// Register Tile Entities
		// Init Custom Rendering and Textures
		// Register EventHandlers
		// Init CraftingHandler
		// Init RecipeHandler
		// Register FuelHandler
	}
}
