package net.heavencraft.industrialchemistry.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class Recipe
{
	private final Map<String, Object> optionalSettings;
	private final Class<? extends BaseTEBlockPower> machine;
	private final List<RecipeComponent> input;
	private final List<RecipeComponent> output;
	private final int processTime;
	
	public Recipe(Class<? extends BaseTEBlockPower> clazz, 
			List<RecipeComponent> input, 
			List<RecipeComponent> output, 
			int processTime, Map<String, Object> optionalSettings)
	{
		this.optionalSettings = optionalSettings;
		this.input = input;
		this.output = output;
		this.processTime = processTime;
		machine = clazz;
	}
	
	public List<RecipeComponent> getOutput(Class<? extends BaseTEBlockPower> clazz, List<Object> input)
	{
		if (!isValidForMachine(clazz)) return null;
		
		int currentValidInputs = 0;
		
		for(Object obj : input)
		{
			if (obj instanceof ItemStack)
			{
				ItemStack inputItem = (ItemStack)obj;
				
				for(RecipeComponent component : this.input) {
					if (!component.isItemStack()) continue;
					
					ItemStack componentItemStack = (ItemStack)component.getComponent();
					if (inputItem.isItemEqual(componentItemStack) && inputItem.stackSize >= componentItemStack.stackSize)
						currentValidInputs++;
				}
			}
			else if (obj instanceof FluidStack)
			{
				
			}
			else return null;
		}
		
		if (currentValidInputs == this.input.size())
			return this.output;
		else return null;
	}
	
	public List<RecipeComponent> getSimpleOutput(Class<? extends BaseTEBlockPower> clazz, Object input)
	{
		List l = new ArrayList<Object>();
		l.add(input);
		return getOutput(clazz, l);
	}
	
	public List<RecipeComponent> getSimpleOutput()
	{
		return output;
	}
	
	public boolean isValid(Class<? extends BaseTEBlockPower> clazz, List<Object> input)
	{
		return getOutput(clazz, input) != null;
	}
	
	public boolean isValidForMachine(Class<? extends BaseTEBlockPower> clazz)
	{
		return clazz == machine;
	}
	
	public int getProcessTime()
	{
		return processTime;
	}
	
	public Object getOptionalSetting(String key)
	{
		return optionalSettings.get(key);
	}
	
	public boolean hasOptionalSetting(String key)
	{
		return getOptionalSetting(key) != null;
	}
	
	public RecipeComponent[] getInputComponents()
	{
		return input.toArray(new RecipeComponent[0]);
	}
	
	public RecipeComponent[] getOutputComponents()
	{
		return output.toArray(new RecipeComponent[0]);
	}
}
