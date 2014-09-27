package net.heavencraft.industrialchemistry.block.machine;

import java.util.EnumSet;
import java.util.HashMap;

import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Sven
 *
 */
public class TextureSet extends HashMap<ForgeDirection, IIcon>
{
	private final MachineState state;
	private final TextureSet parrent;
	private HashMap<MachineState, TextureSet> children;
	
	
	/**
	 * Constructs a new TextureSet for a Machine
	 * If parrent is null, then all textures must be set.
	 * If you register a parrent
	 * @param iconRegister IIconRegister to register blocktextures
	 * @param state The state this texture set will provide for
	 * @param parrent The parrent (default) texture set
	 * @param front The front of the machine
	 * @param back The back of the machine
	 * @param left The left of the machine
	 * @param right The right of the machine
	 * @param top The top of the machine
	 * @param bottom The bottom of the machine
	 */
	public TextureSet(IIconRegister iconRegister, MachineState state, TextureSet parrent, 
			String front, String back, String left, String right, String top, String bottom)
	{
		this.state = state;
		this.parrent = parrent;
		children = new HashMap<MachineState, TextureSet>();
		
		//Front
		if (front != null)
			put(ForgeDirection.SOUTH, iconRegister.registerIcon(front));
		//Back
		if (back != null)
			put(ForgeDirection.NORTH, iconRegister.registerIcon(back));
		//Top
		if (top != null)
			put(ForgeDirection.UP, iconRegister.registerIcon(top));
		//Bottom
		if (bottom != null)
			put(ForgeDirection.DOWN, iconRegister.registerIcon(bottom));
		//Left
		if (left != null)
			put(ForgeDirection.WEST, iconRegister.registerIcon(left));
		//Right
		if (right != null)
			put(ForgeDirection.EAST, iconRegister.registerIcon(right));
		
		//Sets parrents children
		if (parrent != null)
		{
			parrent.setChild(this);
		}
		
		/*
		//Missing textures get replaced with 'texture errors'
		if (parrent == null && this.size() != 6)
		{
			System.err.println("MISSING TEXTURES");
			for(ForgeDirection side : ForgeDirection.VALID_DIRECTIONS)
			{
				if (getTexture(side) == null)
					put(side, iconRegister.registerIcon(missingTexture));
			}
		}
		*/

	}
	
	
	/**
	 * Sets a parrent's child
	 * @param child
	 */
	public void setChild(TextureSet child)
	{
		if (parrent != null) return;
		
		children.put(child.getState(), child);
	}
	
	/**
	 * @return The state this TextureSet provides for
	 */
	public MachineState getState()
	{
		return state;
	}
	
	/**
	 * Gets the texture for a given side
	 * @param side
	 * @return
	 */
	private IIcon getTexture(ForgeDirection side)
	{
		return get(side);
	}
	
	/**
	 * Gets the texture for a given side and state
	 * @param side
	 * @param state
	 * @return
	 */
	public IIcon getTexture(ForgeDirection side, MachineState state)
	{
		if (state != this.state && parrent == null)
		{
			if (children.get(state).getTexture(side) == null)
				return getTexture(side);
			else 
				return children.get(state).getTexture(side);
		}
		return getTexture(side);
		
	}
	
	
	/**
	 * Gets texture for side based on front side
	 * @param front
	 * @param side
	 * @param state
	 * @return
	 */
	public IIcon getTextureForFacing(ForgeDirection front, ForgeDirection side, MachineState state)
	{
		//Front
		if (side == front)
			return getTexture(ForgeDirection.SOUTH, state);
		//Back
		else if (side == front.getOpposite())
			return getTexture(ForgeDirection.NORTH, state);
		//Right
		else if (side == front.getRotation(ForgeDirection.DOWN))
			return getTexture(ForgeDirection.EAST, state);
		//Left
		else if (side == front.getRotation(ForgeDirection.UP))
			return getTexture(ForgeDirection.WEST, state);
		//Up
		else if (side == ForgeDirection.UP)
			return getTexture(ForgeDirection.UP, state);
		//Down
		else if (side == ForgeDirection.DOWN)
			return getTexture(ForgeDirection.DOWN, state);
		
		else return null;

	}	
}
