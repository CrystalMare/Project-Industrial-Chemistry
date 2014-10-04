package net.heavencraft.industrialchemistry.block.machine;

import java.util.HashMap;
import java.util.Map;

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
	private final Map textures = new HashMap<ForgeDirection, IIcon>();
	private final MachineState state;
	private final TextureSet parent;
	private HashMap<MachineState, TextureSet> children;
	
	
	/**
	 * Constructs a new TextureSet for a Machine
	 * If parent is null, then all textures must be set.
	 * If you register a parent
	 * @param iconRegister IIconRegister to register blocktextures
	 * @param state The state this texture set will provide for
	 * @param parent The parent (default) texture set
	 * @param front The front of the machine
	 * @param back The back of the machine
	 * @param left The left of the machine
	 * @param right The right of the machine
	 * @param top The top of the machine
	 * @param bottom The bottom of the machine
	 */
	public TextureSet(IIconRegister iconRegister, MachineState state, TextureSet parent, 
			String front, String back, String left, String right, String top, String bottom)
	{
		this.state = state;
		this.parent = parent;
		children = new HashMap<MachineState, TextureSet>();
		
		if (front != null)
			put(ForgeDirection.SOUTH, iconRegister.registerIcon(front));
		if (back != null)
			put(ForgeDirection.NORTH, iconRegister.registerIcon(back));
		if (top != null)
			put(ForgeDirection.UP, iconRegister.registerIcon(top));
		if (bottom != null)
			put(ForgeDirection.DOWN, iconRegister.registerIcon(bottom));
		if (left != null)
			put(ForgeDirection.WEST, iconRegister.registerIcon(left));
		if (right != null)
			put(ForgeDirection.EAST, iconRegister.registerIcon(right));
		
		if (parent != null) parent.setChild(this);
	}
	
	
	/**
	 * Sets a parent's child
	 * @param child
	 */
	public void setChild(TextureSet child)
	{
		if (parent != null) return;
		
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
		if (state != this.state && parent == null)
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
