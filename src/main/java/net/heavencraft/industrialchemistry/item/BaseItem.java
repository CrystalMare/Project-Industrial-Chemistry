package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.creativetab.CreativeTab;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseItem extends Item
{
	public BaseItem()
	{
		this.setCreativeTab(CreativeTab.PIC_TAB);
	}
	
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
	
	public BaseItem setItemName(String name)
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
