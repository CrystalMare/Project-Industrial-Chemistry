package net.heavencraft.industrialchemistry.tileentity;

public class TEMachineChemicalFurnace extends TEBlockPICPower
{
	
	public TEMachineChemicalFurnace()
	{
		this.createInventory(2);
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
