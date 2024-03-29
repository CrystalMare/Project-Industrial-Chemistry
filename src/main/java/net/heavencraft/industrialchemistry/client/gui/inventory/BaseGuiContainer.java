package net.heavencraft.industrialchemistry.client.gui.inventory;

import java.awt.Color;

import net.heavencraft.industrialchemistry.helpers.BlockHelper;
import net.heavencraft.industrialchemistry.reference.Textures;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public abstract class BaseGuiContainer extends GuiContainer
{
	
	public BaseGuiContainer(Container container)
	{
		super(container);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(Textures.GUI.BaseGui.BaseGuiResource);
		int startX = (width - xSize) / 2;
		int startY = (height - ySize) / 2;
		this.drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
	}
	
	public void drawTitle(String title)
	{
		int fontwitdh = fontRendererObj.getStringWidth(title);
		int startX = (xSize - fontwitdh) / 2;
		int startY = 8;
		fontRendererObj.drawString(StatCollector.translateToLocal(title), startX, startY, Color.darkGray.getRGB());
	}
	
	public void drawLiquidBar(TileEntity tank, int xOffset, int yOffset)
	{
		this.mc.getTextureManager().bindTexture(Textures.GUI.LiquidBar);
		int startX = ((width - xSize) / 2) + xOffset;
		int startY = ((height - ySize) / 2) + yOffset;
		this.drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
		if (tank != null)
		{
			if (tank instanceof IFluidHandler)
			{
				int meta = FMLClientHandler.instance().getClient().theWorld.getBlockMetadata(tank.xCoord, tank.yCoord, tank.zCoord);
				ForgeDirection facingDir = BlockHelper.getOrientation(meta);
				FluidTankInfo[] info = ((IFluidHandler) tank).getTankInfo(facingDir);
				if (info != null && info.length > 0)
				{
					FluidTankInfo tankInfo = info[0];
					int tankCapacity = tankInfo.capacity;
					if (tankInfo.fluid != null && tankInfo.fluid.getFluid() != null)
					{
						Fluid fluid = tankInfo.fluid.getFluid();
						IIcon fluidIcon = fluid.getIcon();
						int amount = tankInfo.fluid.amount;
						int fluidHeight = MathHelper.ceiling_float_int((amount / (float) tankCapacity) * 48);
						this.mc.getTextureManager().bindTexture(this.mc.getTextureManager().getResourceLocation(fluid.getSpriteNumber()));
						this.drawTexturedModelRectFromIcon(startX + 1, startY + 1, fluidIcon, 16, 16);
						this.drawTexturedModelRectFromIcon(startX + 1, startY + 1 + 16, fluidIcon, 16, 16);
						this.drawTexturedModelRectFromIcon(startX + 1, startY + 1 + 32, fluidIcon, 16, 16);
						this.mc.getTextureManager().bindTexture(Textures.GUI.LiquidBar);
						this.drawTexturedModalRect(startX, startY, 0, 0, 18, 49 - fluidHeight);
					}
				}
			}
		}
		this.mc.getTextureManager().bindTexture(Textures.GUI.LiquidBarOverlay);
		this.drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
	}
	
	public void drawSlot(int xOffset, int yOffset)
	{
		this.mc.getTextureManager().bindTexture(Textures.GUI.Slot);
		int startX = ((width - xSize) / 2) - 1 + xOffset;
		int startY = ((height - ySize) / 2) - 1 + yOffset;
		this.drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
	}
}