package net.heavencraft.industrialchemistry.tileentity;

import net.heavencraft.industrialchemistry.reference.Names;

public class TEMachineChemicalFurnace extends TEBlockPICPower
{
	
	public TEMachineChemicalFurnace()
	{
		createInventory(2);
		setName(Names.Block.Machine.MachineChemicalFurnace);
	}
	
	@Override
	public void updateEntity()
	{
		if(this.getWorldObj().getBlockPowerInput(this.xCoord, this.yCoord, this.zCoord) > 0)
		{
			this.setMachineState(MachineState.ON);
		}
		else
		{
			this.setMachineState(MachineState.OFF);
		}
	}
	
}
