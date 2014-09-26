package net.heavencraft.industrialchemistry.helpers;

import net.heavencraft.industrialchemistry.reference.Names;
import net.minecraft.util.ResourceLocation;


/**
 * 
 * @author Chase
 *
 */
public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Names.Mod.ID.toLowerCase(), path);
    }
    
    public static ResourceLocation getGuiLocation(String path)
    {
    	String GuisLocation = "/textures/gui/";
    	return getResourceLocation(GuisLocation + path);
    }
    
    public static String getBlockLocation(String path)
    {
    	return Names.Mod.ID + ":" + path;
    }
    
    public static String getItemLocation(String path)
    {
    	return Names.Mod.ID + ":" + path;
    }
}
