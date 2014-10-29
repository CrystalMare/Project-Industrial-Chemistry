package net.heavencraft.industrialchemistry.item;

import net.heavencraft.industrialchemistry.tileentity.machines.TEGreenHouseController;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TestItem extends BaseItem
{
	TEGreenHouseController controller;
	
	public TestItem()
	{
		this.setItemName("testitemPIC");
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if (!world.isRemote)
		{
			if (controller == null)
			{
				TileEntity tile = world.getTileEntity(x, y, z);
				if (tile instanceof TEGreenHouseController)
				{
					controller = (TEGreenHouseController) tile;
					player.addChatMessage(new ChatComponentText("Test item binded to " + controller.getName() + " at x: " + controller.xCoord + " y: " + controller.yCoord + " z: " + controller.zCoord));
				}
				else
				{
					player.addChatMessage(new ChatComponentText("Failed to bind to controlling block"));
				}
			}
			else
			{
				Block[][][] multiBlock = controller.getMultiBlock();
				for (int h = 0; h < controller.getHeight(); h++)
				{
					for (int l = 0; l < controller.getLength(); l++)
					{
						for (int w = 0; w < controller.getWidth(); w++)
						{
							world.setBlock(x + l, y + h, z + w, multiBlock[h][l][w]);
						}
					}
				}
			}
		}
		
		return super.onItemUse(item, player, world, x, y, z, side, p_77648_8_, p_77648_9_, p_77648_10_);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer player)
	{
		if (controller != null && player.isSneaking())
		{
			controller = null;
			player.addChatMessage(new ChatComponentText("Removed to bind to controlling block"));
			
		}
		return super.onItemRightClick(p_77659_1_, p_77659_2_, player);
	}
}
