package net.heavencraft.industrialchemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlock;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class BaseTileEntity implements IMessage, IMessageHandler<BaseTileEntity, IMessage>
{
	
	public int x, y, z;
	//TODO Implement orientation
	public int orientation;
	
	public BaseTileEntity()
	{
		
	}
	
	public BaseTileEntity(BaseTEBlock tile)
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
    public IMessage onMessage(BaseTileEntity message, MessageContext ctx)
    {
	    return null;
    }
}
