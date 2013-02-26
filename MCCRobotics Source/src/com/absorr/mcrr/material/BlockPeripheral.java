package com.absorr.mcrr.material;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPeripheral extends BlockContainer
{
	public World worldObj;

	public BlockPeripheral(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		this.worldObj = var1;
		return new TileEntityPeripheral();
	}

}
