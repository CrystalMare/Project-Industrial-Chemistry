package net.heavencraft.industrialchemistry.tileentity.machines;

import net.heavencraft.industrialchemistry.helpers.BlockHelper;
import net.heavencraft.industrialchemistry.tileentity.BaseTEBlockPower;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockGlass;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidTank;

public class TEGreenHouseController extends BaseTEBlockPower
{
	private IFluidTank water;
	private IFluidTank oxygen;
	private IFluidTank co2;
	
	private Block[][][] multiBlock;
	
	private int height = 0;
	private int length = 0;
	private int width = 0;
	
	public TEGreenHouseController()
	{
	}
	
	public Block[][][] getMultiBlock()
	{
		return multiBlock;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getLength()
	{
		return length;
	}
	
	@Override
	public void updateEntity()
	{
		isMultiBlock();
	}
	
	public boolean isMultiBlock()
	{
		if (!worldObj.isRemote)
		{
			ForgeDirection dir = BlockHelper.getOrientation(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
			int left = ForgeDirection.ROTATION_MATRIX[ForgeDirection.UP.ordinal()][dir.ordinal()];
			ForgeDirection dirLeft = ForgeDirection.getOrientation(left);
			int right = ForgeDirection.ROTATION_MATRIX[ForgeDirection.DOWN.ordinal()][dir.ordinal()];
			ForgeDirection dirRight = ForgeDirection.getOrientation(right);
			
			if (dir == ForgeDirection.UP || dir == ForgeDirection.DOWN) return false;
			
			int x = (int) (Math.floor(xCoord) + (2 * dirLeft.offsetX));
			int y = yCoord;
			int z = (int) (Math.floor(zCoord) + (2 * dirLeft.offsetZ));
			ForgeDirection doorDir = ForgeDirection.UNKNOWN;
			ForgeDirection otherDir = ForgeDirection.UNKNOWN;
			if (worldObj.getBlock(x, y, z) instanceof BlockDoor)
			{
				doorDir = dirLeft;
				otherDir = dirRight;
			}
			else
			{
				x = xCoord + (2 * dirRight.offsetX);
				z = zCoord + (2 * dirRight.offsetZ);
				if (worldObj.getBlock(x, y, z) instanceof BlockDoor)
				{
					doorDir = dirRight;
					otherDir = dirLeft;
				}
				else
				{
					return false;
				}
			}
			
			if (doorDir != ForgeDirection.UNKNOWN)
			{
				int n = 2;
				int nextGlassY = y + n;
				while (worldObj.getBlock(x, nextGlassY, z) instanceof BlockGlass)
				{
					n++;
					nextGlassY = y + n;
				}
				
				height = n + 1;
				System.out.println("height: " + height);
				
				n = 1;
				int nextGlassX = x + (doorDir.offsetX * n);
				int nextGlassZ = z + (doorDir.offsetZ * n);
				nextGlassY = yCoord - 1;
				while (worldObj.getBlock(nextGlassX, nextGlassY, nextGlassZ) instanceof BlockGlass)
				{
					n++;
					nextGlassX = x + (doorDir.offsetX * n);
					nextGlassZ = z + (doorDir.offsetZ * n);
				}
				if (n != height - 2) return false;
				length = (n * 2) - 1;
				
				n = 1;
				x = nextGlassX - (doorDir.offsetX);
				z = nextGlassZ - (doorDir.offsetZ);
				ForgeDirection widthDirection = ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[dir.ordinal()]);
				nextGlassX = x + (widthDirection.offsetX * n);
				nextGlassZ = z + (widthDirection.offsetZ * n);
				while (worldObj.getBlock(nextGlassX, nextGlassY, nextGlassZ) instanceof BlockGlass)
				{
					n++;
					nextGlassX = x + (widthDirection.offsetX * n);
					nextGlassZ = z + (widthDirection.offsetZ * n);
				}
				
				width = n;
				System.out.println("Width: " + width);
				System.out.println("Length: " + length);
				if (width % 2 != 1) return false;
				
				int startX = xCoord + (2 * otherDir.offsetX);
				int startY = yCoord - 1;
				int startZ = zCoord + (2 * otherDir.offsetZ);
				
				System.out.println("startX: " + startX);
				System.out.println("startZ: " + startZ);
				
				multiBlock = new Block[height][length][width];
				
				if (width < 7) return false;
				
				for (int h = 0; h < height; h++)
				{
					for (int l = 0; l < length; l++)
					{
						for (int w = 0; w < width; w++)
						{
							multiBlock[h][l][w] = worldObj.getBlock(startX + (l * otherDir.offsetX), startY + h, startZ + (w * otherDir.offsetZ));
						}
					}
				}
				
				for (int h = 0; h < height; h++)
				{
					for (int l = 0; l < length; l++)
					{
						for (int w = 0; w < width; w++)
						{
							if (h < 3 && l == 0)
							{
								if (!(multiBlock[h][l][w] instanceof BlockGlass))
								{
									System.out.println("length: " + l + " width: " + w + " height: " + h + " : FAILED MULTIBLOCK!");
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
