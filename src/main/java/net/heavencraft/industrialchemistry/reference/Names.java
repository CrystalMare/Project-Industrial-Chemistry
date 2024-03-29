package net.heavencraft.industrialchemistry.reference;

public abstract class Names
{
	public static final class Mod
	{
		public static final String ID = "pic";
		public static final String Name = "Project Industrial Chemistry";
		public static final String Version = "0.1 alpha";
	}
	
	public static final class Proxy
	{
		public static final String CLIENT_CLASS = "net.heavencraft.industrialchemistry.proxy.ClientProxy";
		public static final String SERVER_CLASS = "net.heavencraft.industrialchemistry.proxy.ServerProxy";
	}
	
	public static final class NBT
	{
		public static final class TileEntity
		{
			public static final String Direction = "direction";
			public static final String CustomName = "customname";
			public static final String Owner = "owner";
			public static final String Items = "items";
			
			public static final String State = "state";
			
			public static final String Temp = "temperature";
		}
	}
	
	public static final class Block
	{
		public static final class Machine
		{
			public static String MachineChemicalFurnace = "machineChemicalFurnace";
			public static String MachineGrinder = "machineGrinder";
			public static String GreenHouseController = "greenHouseController";
		}
		
		public static final String BLOCKTESTING = "blockTesting";
		public static final String OreMalachite = "oreMalachite";
		
	}
	
	public static final class Item
	{
		
		public static final String ChemicalMalachite = "chemicalMalachite";
		public static final String ChemicalAzurite = "chemicalAzurite";
		
		public static final String ChemicalPotassiumNitrate = "chemicalPotassiumNitrate";
		public static final String ChemicalSulfurTrioxide = "chemicalSulfurTrioxide";
		public static final String ChemicalAmmoniumNitrate = "chemicalAmmoniumNitrate";
		public static final String ChemicalLimestone = "chemicalLimestone";
		public static final String ChemicalVanadiumOxide = "chemicalVanadiumOxide";
		public static final String ChemicalSulfur = "chemicalSulfur";
		public static final String ChemicalSaltpeter = "chemicalSaltpeter";
		public static final String ChemicalCopperOxide = "chemicalCopperOxide";
		
		public static final String Ash = "itemAsh";
		
		public static final String FireExtinquisher = "toolFireExtinquisher";
	}
	
	public static final class Fluids
	{
		public static final String Oxygen = "oxygen";
		public static final String CarbonDioxide = "carbondioxide";
		
		public static String getBucketName(String name)
		{
			return name + "_Bucket";
		}
	}
}
