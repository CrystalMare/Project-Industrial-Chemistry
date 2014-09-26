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
	    this.setMachineState(MachineState.On);
    }
	
}
