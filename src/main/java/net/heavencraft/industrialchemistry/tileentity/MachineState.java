package net.heavencraft.industrialchemistry.tileentity;

public enum MachineState
{
	OFF, ON, PAUSED;
	
	public int getID()
	{
		return this.ordinal();
	}
}
