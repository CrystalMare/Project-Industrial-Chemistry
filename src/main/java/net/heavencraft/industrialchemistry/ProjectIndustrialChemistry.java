package net.heavencraft.industrialchemistry;

import net.heavencraft.industrialchemistry.handlers.GuiHandler;
import net.heavencraft.industrialchemistry.handlers.OldRecipeHandler;
import net.heavencraft.industrialchemistry.handlers.WorldGenHandler;
import net.heavencraft.industrialchemistry.init.Blocks;
import net.heavencraft.industrialchemistry.init.Items;
import net.heavencraft.industrialchemistry.network.PacketHandler;
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
import cpw.mods.fml.common.registry.GameRegistry;

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
		PacketHandler.init();
		// Init Items
		Items.init();
		// Init Blocks
		Blocks.init();
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Register Gui Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		//Register WorldGen
		GameRegistry.registerWorldGenerator(new WorldGenHandler(), 1);
		// Register Tile Entities
		proxy.registerTileEntities();
		// Init Custom Rendering and Textures
		// Register EventHandlers
		// Init CraftingHandler
		// Init RecipeHandler
		OldRecipeHandler.init();
		// Register FuelHandler
	}
}
