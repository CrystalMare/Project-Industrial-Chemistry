package net.heavencraft.industrialchemistry.network;

import net.heavencraft.industrialchemistry.network.packet.PacketChemicalFurnace;
import net.heavencraft.industrialchemistry.network.packet.PacketTileEntityPIC;
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

    public static void init()
    {
       //Register Packets Here!
    	INSTANCE.registerMessage(PacketChemicalFurnace.class, PacketChemicalFurnace.class, 0, Side.CLIENT);
    }
}