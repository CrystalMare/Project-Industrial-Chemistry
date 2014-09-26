package net.heavencraft.industrialchemistry.tileentity;

public enum MachineState
{
	On("_on"), Off("_off"), Paused("_paused");
	
	private String textureSuffix;
	
	MachineState(String textureSuffix)
	{
		this.textureSuffix = textureSuffix;
	}
	
	public String getTextureSuffix()
	{
		return this.textureSuffix;
	}
	
	public int getID()
	{
		return this.ordinal();
	}
}
