package net.heavencraft.industrialchemistry.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeComponent
{
	private final Object part;
	private final boolean type;
	private final int slotId;
	
	public RecipeComponent(ItemStack is, int slotId)
	{
		this.slotId = slotId;
		part = is;
		type = true;
	}
	
	public RecipeComponent(FluidStack fs, int slotId)
	{
		this.slotId = slotId;
		part = fs;
		type = false;
	}
	
	public boolean isItemStack()
	{
		return type;
	}
	
	public boolean isFluidStack()
	{
		return !type;
	}
	
	public int getSlotId()
	{
		return slotId;
	}
	
	public Object getComponent()
	{
		return part;
	}
	
	public ItemStack getComponentAsItemStack()
	{
		if (part instanceof ItemStack)
			return (ItemStack) part;
		else return null;
	}
	
	public FluidStack getComponentAsFluidStack()
	{
		if (part instanceof FluidStack)
			return (FluidStack) part;
		else return null;
	}
}
