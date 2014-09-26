package net.heavencraft.industrialchemistry.block.machine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.heavencraft.industrialchemistry.reference.Names.Block.Machine;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.heavencraft.industrialchemistry.tileentity.MachineState;
import net.heavencraft.industrialchemistry.tileentity.TEMachineChemicalFurnace;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class MachineChemicalFurnace extends BlockMachinePIC
{
	public MachineChemicalFurnace()
	{
		this.setBlockName(Machine.MachineChemicalFurnace);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for (MachineState state : MachineState.values())
		{
			frontIcons[state.getID()] = iconRegister.registerIcon(Textures.Block.Machine.ChemicalFurnaceFront.concat(state.getTextureSuffix()));
			topIcons[state.getID()] = iconRegister.registerIcon(Textures.Block.Machine.Fan.concat(state.getTextureSuffix()));
			sideIcons[state.getID()] = iconRegister.registerIcon(Textures.Block.Machine.ChemicalFurnaceSide.concat(state.getTextureSuffix()));
			backIcons[state.getID()] = iconRegister.registerIcon(Textures.Block.Machine.ChemicalFurnaceSide.concat(state.getTextureSuffix()));
			bottomIcons[state.getID()] = iconRegister.registerIcon(Textures.Block.Machine.ChemicalFurnaceSide.concat(state.getTextureSuffix()));
		}
	}


	@Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
	    return new TEMachineChemicalFurnace();
    }
}
