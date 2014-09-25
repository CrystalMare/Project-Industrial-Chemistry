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
		public static String Direction = "direction";
		public static String CustomName = "customname";
		public static String Owner = "owner";
		public static String Items = "items";
	}
}
