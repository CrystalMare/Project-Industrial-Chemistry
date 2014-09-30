package net.heavencraft.industrialchemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.TEMachineGrinder;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketGrinder implements IMessage, IMessageHandler<PacketGrinder, IMessage>
{
	int x;
	int y;
	int z;
	int internalEnergy;
	int timeLeftToProccess;
	int state;
	
	public PacketGrinder()
	{
	}
	
	public PacketGrinder(TEMachineGrinder tile)
	{
		x = tile.xCoord;
		y = tile.yCoord;
		z = tile.zCoord;
		internalEnergy = tile.getInternalEnergy();
		timeLeftToProccess = tile.getTimeLeftToProcess();
		state = tile.getMachineState().getID();
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		internalEnergy = buf.readInt();
		timeLeftToProccess = buf.readInt();
		state = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(internalEnergy);
		buf.writeInt(timeLeftToProccess);
		buf.writeInt(state);
	}
	
	@Override
	public IMessage onMessage(PacketGrinder message, MessageContext ctx)
	{
		if (FMLClientHandler.instance().getClient().theWorld.isRemote)
		{
			TileEntity tile = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);
			if(tile instanceof TEMachineGrinder)
			{
				TEMachineGrinder machine = (TEMachineGrinder) tile;
				machine.setInternalEnergy(message.internalEnergy);
				machine.setTimeLeftToProcess(message.timeLeftToProccess);
				machine.setMachineState(MachineState.values()[message.state]);
			}				
		}		
		return null;
	}
}
