package net.heavencraft.industrialchemistry.crafting;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeComponent
{
	private final Object part;
	private final boolean type;
	private final int slotId;
	private final float dropchance;
	
	public RecipeComponent(ItemStack is, int slotId, float dropchance)
	{
		this.slotId = slotId;
		this.dropchance = dropchance;
		part = is;
		type = true;
	}
	
	public RecipeComponent(FluidStack fs, int slotId, float dropchance)
	{
		this.slotId = slotId;
		this.dropchance = dropchance;
		part = fs;
		type = false;
	}
	
	public float getDropChance()
	{
		return dropchance;
	}
	
	public boolean getDrop()
	{
		  return new Random().nextFloat() <= getDropChance();
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
