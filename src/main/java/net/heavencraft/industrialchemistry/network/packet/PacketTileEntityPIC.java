package net.heavencraft.industrialchemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.heavencraft.industrialchemistry.tileentity.TEBlockPIC;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketTileEntityPIC implements IMessage, IMessageHandler<PacketTileEntityPIC, IMessage>
{
	
	public int x, y, z;
	//TODO Implement orientation
	public int orientation;
	
	public PacketTileEntityPIC()
	{
		
	}
	
	public PacketTileEntityPIC(TEBlockPIC tile)
	{
        this.x = tile.xCoord;
        this.y = tile.yCoord;
        this.z = tile.zCoord;;
	}
	

	@Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

	@Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

	@Override
    public IMessage onMessage(PacketTileEntityPIC message, MessageContext ctx)
    {
	    return null;
    }
}
