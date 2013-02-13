package com.absorr.mcrr.material;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;

import com.absorr.mcrr.entity.EntityRobot;

public class ModuleSensorSonic extends ItemModule
{

	public ModuleSensorSonic(int par1) 
	{
		super(par1, 0, 10, 7);
	}

	@Override
	public int getValue(EntityRobot par1Robot, int par2) 
	{
		double var1 = par1Robot.posX;
		double var2 = par1Robot.posY;
		double var3 = par1Robot.posZ;
		float var7 = 0.125F;
		List var4 = par1Robot.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox((double)((float)var1 + var7), (double)var2, (double)((float)var3 + var7), (double)((float)(var1 + 10) - var7), (double)var2 + 3.25D, (double)((float)(var3 + 10) - var7)));
		if(var4.isEmpty())
			return 0;
		EntityLiving var5;
		Object[] var6 = var4.toArray();
		double distance = 0;
		int entry = 0;
		for(Object ent : var6)
		{
			Entity var8 = (EntityLiving) ent;
			double var9 = var8.posX;
			double var10 = var8.posY;
			double var11 = var8.posZ;
			distance = Math.sqrt(Math.pow(var9 - var1, 2) + Math.pow(var10 - var2, 2) + Math.pow(var11 - var3, 2));
		}
		if (distance > 10)
			return 0;
		else
			return (int) distance;
	}

	@Override
	public void setValue(EntityRobot par1Robot, int par2, int par3) {}

}
