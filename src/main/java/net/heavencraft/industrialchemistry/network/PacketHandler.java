package net.heavencraft.industrialchemistry.network;

import net.heavencraft.industrialchemistry.network.packet.PacketChemicalFurnace;
import net.heavencraft.industrialchemistry.network.packet.PacketGrinder;
import net.heavencraft.industrialchemistry.reference.Names;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * 
 * @author Chase
 *
 */
public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Names.Mod.ID.toLowerCase());

    public static int discriminator = 0;
    
    public static void init()
    {
       //Register Packets Here!
    	INSTANCE.registerMessage(PacketChemicalFurnace.class, PacketChemicalFurnace.class, nextDisc(), Side.CLIENT);
    	INSTANCE.registerMessage(PacketGrinder.class, PacketGrinder.class, nextDisc(), Side.CLIENT);
    }
    
    
    public static int nextDisc()
    {
    	return discriminator++;
    }
}