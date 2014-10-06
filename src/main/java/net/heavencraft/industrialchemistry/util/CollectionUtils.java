package net.heavencraft.industrialchemistry.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sven
 * Provides various methods for managing Collections
 */
public class CollectionUtils
{
	
	/**
	 * Turns given array into a List using an ArrayList
	 * @param input
	 * @return
	 */
	public static <T> List<T> getList(T[] input)
	{
		List<T> set = new ArrayList<T>();
		for(T e : input)
		{
			set.add(e);
		}
		return set;
	}
	
	
	/**
	 * Returns true if all elements in array are null;
	 * @param array
	 * @return
	 */
	public static <T> boolean allNull(T[] array)
	{
		for(T is : array)
			if (is != null)
				return false;
		return true;
	}
}
