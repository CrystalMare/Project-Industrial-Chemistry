package net.heavencraft.industrialchemistry.block.machine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.heavencraft.industrialchemistry.reference.Gui;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.reference.Names.Block.Machine;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.machines.TEMachineGrinder;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MachineGrinder extends BaseBlockMachine
{
	public MachineGrinder()
	{
		this.setBlockName(Machine.MachineGrinder);
		this.setGUIID(Gui.ID.MachineGrinder);
	}	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new TextureSet(iconRegister, MachineState.OFF, null,
				Textures.Block.Machine.GrinderFrontOff,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide);
		textures.setChild(new TextureSet(iconRegister, MachineState.ON, textures,
				Textures.Block.Machine.GrinderFrontOn, 
				null, null, null, null, null));
	}

	@Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
	    return new TEMachineGrinder();
    }
	
}
