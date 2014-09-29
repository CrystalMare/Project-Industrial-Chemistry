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
			public static String Direction = "direction";
			public static String CustomName = "customname";
			public static String Owner = "owner";
			public static String Items = "items";
			
			public static String State = "state";
		}
	}
	
	public static final class Block
	{
		public static final class Machine
		{
			public static String MachineChemicalFurnace = "machineChemicalFurnace";
		}
		
		public static String BLOCKTESTING = "blockTesting";
		public static String OreMalachite = "oreMalachite";
		
	}
	
	public static final class Item
	{
		public static String CrushedMalachite = "crushedMalachite";
		
		public static String ChemicalPotassiumNitrate = "chemicalPotassiumNitrate";
		public static String ChemicalSulfurTrioxide = "chemicalSulfurTrioxide";
		public static String ChemicalAmmoniumNitrate = "chemicalAmmoniumNitrate";
		public static String ChemicalLimestone = "chemicalLimestone";
		public static String ChemicalVanadiumOxide = "chemicalVanadiumOxide";
		public static String ChemicalSulfur = "chemicalSulfur";
		public static String ChemicalSaltpeter = "chemicalSaltpeter";
	}
	
	public static final class Fluids
	{
		public static final String Oxygen = "oxygen";
	}
}
