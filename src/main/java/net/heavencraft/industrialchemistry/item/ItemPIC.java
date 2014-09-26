package net.heavencraft.industrialchemistry.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemPIC extends Item
{
	
	private String textureLocation;
	
	public void setTextureLocation(String textureLocation)
	{
		this.textureLocation = textureLocation;
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	public ItemPIC setItemName(String name)
	{
		this.setUnlocalizedName(name);
		return this;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		if (this.textureLocation != null && this.textureLocation != "")
		{
			register.registerIcon(textureLocation);
		}
		else
		{
			itemIcon = register.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		}
	}
}
