package com.absorr.mcrr.material;

import java.awt.Polygon;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;

import com.absorr.mcrr.entity.EntityRobot;

public class ModuleSensorIR extends ItemModule
{

	public ModuleSensorIR(int par1) 
	{
		super(par1, 0, 2, ModuleSensorIR.class);
	}

	@Override
	public int getValue(EntityRobot par1Robot, int par2) 
	{
		double var1 = par1Robot.posX;
		double var2 = par1Robot.posY;
		double var3 = par1Robot.posZ;
		double angle = par1Robot.rotationYaw;
		float var7 = 0.125F;
		int x2 = (int) (var1+((var1 + 9)-var1)*Math.cos(angle)-((var3 + 10)-var3)*Math.sin(angle));
		int y2 = (int) (var3+((var1 + 9)-var1)*Math.sin(angle)+((var3 + 10)-var3)*Math.cos(angle));
		int x3 = (int) (var1+((var1 + 0)-var1)*Math.cos(angle)-((var3 + 20)-var3)*Math.sin(angle));
		int y3 = (int) (var3+((var1 + 0)-var1)*Math.sin(angle)+((var3 + 20)-var3)*Math.cos(angle));
		int x4 = (int) (var1+((var1 - 9)-var1)*Math.cos(angle)-((var3 + 10)-var3)*Math.sin(angle));
		int y4 = (int) (var3+((var1 - 9)-var1)*Math.sin(angle)+((var3 + 10)-var3)*Math.cos(angle));
		int[] polyX = {(int) var1, x2, x3, x4};
		int[] polyY = {(int) var3, y2, y3, y4};
		Polygon poly = new Polygon(polyX,polyY,4);
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)((float)(var1 - 20)+ var7), (double)var2, (double)((float)(var3 - 20)+ var7), (double)((float)(var1 + 20) - var7), (double)var2 + 3.25D, (double)((float)(var3 + 20) - var7));
		List var4 = par1Robot.worldObj.getEntitiesWithinAABB(Entity.class, aabb);
		if(var4.isEmpty())
			return 0;
		EntityLiving var5;
		Object[] var6 = var4.toArray();
		double distance = 13;
		double angle2 = 0;
		int entry = 0;
		for(Object ent : var6)
		{
			Entity var8 = (EntityLiving) ent;
			double var9 = var8.posX;
			double var10 = var8.posY;
			double var11 = var8.posZ;
			double d = Math.sqrt(Math.pow(var9 - var1, 2) + Math.pow(var10 - var2, 2) + Math.pow(var11 - var3, 2));
			if (d < distance && poly.contains(var9,var11))
			{
				distance = d;
				double a = getAngleOfCoords(var9, var11, var1, var3, x3, y3);
				angle2 = a;
				//TODO: Get 1-9 of the angle that it is in. Need to test the angle overall first.
			}
		}
		if (distance > 12)
			return 0;
		else
			return (int) angle2;
	}
	
	/**
	 * Returns the angle given the 3 coordinates that make it
	 * @param x1 Outward point 1 x
	 * @param y1 Outward point 1 y
	 * @param x2 Center point x
	 * @param y2 Center point y
	 * @param x3 Outward point 2 x
	 * @param y3 Outward point 2 y
	 * @return
	 */
	public static double getAngleOfCoords(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		double m1 = (x1-x2)/(y1-y2);
		double m2 = (x3-x2)/(y3-y2);
		return Math.atan((m1-m2)/(1+m1*m2))*(180/Math.PI);
	}

	@Override
	public void setValue(EntityRobot par1Robot, int par2, int par3) {}

	@Override
	public String getName() {return "Infrared";}

}
