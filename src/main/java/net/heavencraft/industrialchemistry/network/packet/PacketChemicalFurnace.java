package net.heavencraft.industrialchemistry.network.packet;

import io.netty.buffer.ByteBuf;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketChemicalFurnace implements IMessage, IMessageHandler<PacketChemicalFurnace, IMessage>
{
	int x;
	int y;
	int z;
	int internalEnergy;
	int timeLeftToProccess;
	int state;
	int energyUsage;
	int temp;
	
	public PacketChemicalFurnace()
	{
	}
	
	public PacketChemicalFurnace(TEMachineChemicalFurnace tile)
	{
		x = tile.xCoord;
		y = tile.yCoord;
		z = tile.zCoord;
		internalEnergy = tile.getInternalEnergy();
		timeLeftToProccess = tile.getTimeLeftToProcess();
		state = tile.getMachineState().getID();
		energyUsage = tile.getEnergyUsage();
		temp = tile.getTemp();
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
		energyUsage = buf.readInt();
		temp = buf.readInt();
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
		buf.writeInt(energyUsage);
		buf.writeInt(temp);
	}
	
	@Override
	public IMessage onMessage(PacketChemicalFurnace message, MessageContext ctx)
	{
		if (FMLClientHandler.instance().getClient().theWorld.isRemote)
		{
			TileEntity tile = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);
			if (tile instanceof TEMachineChemicalFurnace)
			{
				TEMachineChemicalFurnace chemFurnace = (TEMachineChemicalFurnace) tile;
				chemFurnace.setInternalEnergy(message.internalEnergy);
				chemFurnace.setTimeLeftToProcess(message.timeLeftToProccess);
				chemFurnace.setMachineState(MachineState.values()[message.state]);
				chemFurnace.setEnergyUsage(message.energyUsage);
				chemFurnace.setTemp(message.temp);
			}
		}
		return null;
	}
}
