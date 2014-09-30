package net.heavencraft.industrialchemistry.reference;

public class Gui
{
	public enum ID
	{
		TestingBlock,
		MachineChemicalFurnace,
		MachineGrinder;
		
		public int getID()
		{
			return this.ordinal();
		}
	}
}
