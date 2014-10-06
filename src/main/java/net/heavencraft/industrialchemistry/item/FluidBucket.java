package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.fluids.BaseFluidBlock;
import net.heavencraft.industrialchemistry.reference.Names;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBucket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidBucket extends ItemBucket
{
	BaseFluidBlock fluidBlock;
	
	public FluidBucket(Block fluidblock)
	{
		super(fluidblock);
		fluidBlock = (BaseFluidBlock) fluidblock;
		setItemName(Names.Fluids.getBucketName(fluidBlock.getFluidName()));
	}
	
	public void setItemName(String name)
	{
		this.setUnlocalizedName(name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Textures.Block.Fluids.getBucketIconLocation(fluidBlock.getFluidName()));
		super.registerIcons(iconRegister);
	}
}
