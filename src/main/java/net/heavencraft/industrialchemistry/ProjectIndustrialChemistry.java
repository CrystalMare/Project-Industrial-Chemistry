package net.heavencraft.industrialchemistry;

import net.heavencraft.industrialchemistry.handlers.GUIHandler;
import net.heavencraft.industrialchemistry.init.PICBlocks;
import net.heavencraft.industrialchemistry.proxy.IProxy;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Names.Mod.ID, name = Names.Mod.Name, version = Names.Mod.Version)
public class ProjectIndustrialChemistry
{
	@Instance(Names.Mod.ID)
	public static ProjectIndustrialChemistry instance;
	
	@SidedProxy(clientSide = Names.Proxy.CLIENT_CLASS, serverSide = Names.Proxy.SERVER_CLASS)
	public static IProxy proxy;
	
	
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
		PICBlocks.init();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register Gui Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		// Register Tile Entities
		// Init Custom Rendering and Textures
		// Register EventHandlers
		// Init CraftingHandler
		// Init RecipeHandler
		// Register FuelHandler
	}
}
