package com.absorr.mcrr.material;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.absorr.mcrr.entity.EntityRobot;

public class ModuleSensorSonic extends ItemModule
{

	public ModuleSensorSonic(int par1) 
	{
		super(par1, 0, 0, ModuleSensorSonic.class);
	}

	@Override
	public int getValue(EntityRobot par1Robot, int par2) 
	{
		double var1 = par1Robot.posX;
		double var2 = par1Robot.posY;
		double var3 = par1Robot.posZ;
		float var7 = 0.125F;
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)((float)var1 + var7), (double)var2, (double)((float)var3 + var7), (double)((float)(var1 + 10) - var7), (double)var2 + 3.25D, (double)((float)(var3 + 10) - var7));
		//TODO: Modify AABB based on direction facing
		List var4 = par1Robot.worldObj.getEntitiesWithinAABB(Entity.class, aabb);
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
			double d = Math.sqrt(Math.pow(var9 - var1, 2) + Math.pow(var10 - var2, 2) + Math.pow(var11 - var3, 2));
			if (d < distance)
				distance = d;
		}
		double var12 = this.getClosestBlockInAABB(aabb, par1Robot.worldObj, par1Robot);
		if (var12 < distance)
			distance = var12;
		if (distance > 10)
			return 0;
		else
			return (int) distance;
	}
	
	/**
	 * Gives distance between the entity and the closest block (must be at least 11 blocks away).
	 * Based off Entity.isAABBNonEmpty(AxisAlignedBB)
	 * @param par1AxisAlignedBB
	 * @param world
	 * @param par1Robot
	 * @return
	 */
	public double getClosestBlockInAABB(AxisAlignedBB par1AxisAlignedBB, World world, Entity par1Robot)
    {
        int var2 = MathHelper.floor_double(par1AxisAlignedBB.minX);
        int var3 = MathHelper.floor_double(par1AxisAlignedBB.maxX + 1.0D);
        int var4 = MathHelper.floor_double(par1AxisAlignedBB.minY);
        int var5 = MathHelper.floor_double(par1AxisAlignedBB.maxY + 1.0D);
        int var6 = MathHelper.floor_double(par1AxisAlignedBB.minZ);
        int var7 = MathHelper.floor_double(par1AxisAlignedBB.maxZ + 1.0D);
        double varX = par1Robot.posX;
		double varY = par1Robot.posY;
		double varZ = par1Robot.posZ;

        if (par1AxisAlignedBB.minX < 0.0D)
        {
            --var2;
        }

        if (par1AxisAlignedBB.minY < 0.0D)
        {
            --var4;
        }

        if (par1AxisAlignedBB.minZ < 0.0D)
        {
            --var6;
        }
        
        double distance = 11;

        for (int var8 = var2; var8 < var3; ++var8)
        {
            for (int var9 = var4; var9 < var5; ++var9)
            {
                for (int var10 = var6; var10 < var7; ++var10)
                {
                    Block var11 = Block.blocksList[world.getBlockId(var8, var9, var10)];

                    if (var11 != null)
                    {
                    	double d = Math.sqrt(Math.pow(var8 - varX, 2) + Math.pow(var9 - varY, 2) + Math.pow(var10 - varZ, 2));
                    	if (d < distance)
                    		distance = d;
                    }
                }
            }
        }

        return distance;
    }

	@Override
	public void setValue(EntityRobot par1Robot, int par2, int par3) {}

	@Override
	public String getName() {return "Ultrasonic";}

}
