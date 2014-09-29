package net.heavencraft.industrialchemistry.block.machine;

import net.heavencraft.industrialchemistry.reference.Gui;
import net.heavencraft.industrialchemistry.reference.Names.Block.Machine;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MachineChemicalFurnace extends BaseBlockMachine
{
	public MachineChemicalFurnace()
	{
		this.setBlockName(Machine.MachineChemicalFurnace);
		this.setGUIID(Gui.ID.MachineChemicalFurnace);
	}	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new TextureSet(iconRegister, MachineState.OFF, null,
				Textures.Block.Machine.ChemicalFurnaceFrontOff,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceSide,
				Textures.Block.Machine.ChemicalFurnaceTop,
				Textures.Block.Machine.ChemicalFurnaceSide);
		textures.setChild(new TextureSet(iconRegister, MachineState.ON, textures,
				Textures.Block.Machine.ChemicalFurnaceFrontOn, 
				null, null, null, null, null));
	}


	@Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
	    return new TEMachineChemicalFurnace();
    }
}
