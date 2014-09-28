package net.heavencraft.industrialchemistry.network.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketChemicalFurnace implements IMessage, IMessageHandler<PacketTileEntityPIC, IMessage>
{

	@Override
    public void fromBytes(ByteBuf buf)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void toBytes(ByteBuf buf)
    {
	    // TODO Auto-generated method stub
	    
    }
	

	@Override
    public IMessage onMessage(PacketTileEntityPIC message, MessageContext ctx)
    {
	    // TODO Auto-generated method stub
	    return null;
    }
	
}
