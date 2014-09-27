package net.heavencraft.industrialchemistry.tileentity;

public class TEMachineChemicalFurnace extends TEBlockPICPower
{

	public TEMachineChemicalFurnace()
	{
		this.createInventory(2);
		this.setMachineState(MachineState.ON);
	}
	
	@Override
    public void updateEntity()
    {
		this.setMachineState(MachineState.ON);
    }
	
}
