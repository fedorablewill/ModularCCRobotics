package com.absorr.mcrr.material;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

import com.absorr.mcrr.entity.EntityRobot;

public class ModuleSensorTouch extends ItemModule
{

	public ModuleSensorTouch(int par1) 
	{
		super(par1, 0, 1, ModuleSensorTouch.class);
	}

	@Override
	public int getValue(EntityRobot par1Robot, int par2) 
	{
		double var1 = par1Robot.posX;
		double var2 = par1Robot.posY;
		double var3 = par1Robot.posZ;
		float var4 = 0.125F;
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)((float)var1 + var4), (double)var2, (double)((float)var3 + var4), (double)((float)(var1 + 0.75) - var4), (double)var2 + 1D, (double)((float)(var3 + 0.25) - var4));
		List var5 = par1Robot.worldObj.getEntitiesWithinAABB(Entity.class, aabb);
		if (var5.isEmpty())
			return 0;
		else
			return 1;
	}

	@Override
	public void setValue(EntityRobot par1Robot, int par2, int par3) {}

	@Override
	public String getName() {
		return "Touch";
	}

}
