package com.absorr.mcrr.material;

import java.util.List;

import com.absorr.mcrr.entity.EntityRobot;

import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IPeripheral;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityPeripheral extends TileEntity implements IPeripheral
{
	public boolean connected;
	public IComputerAccess attatched;
	public int port = 0;

	@Override
	public void attach(IComputerAccess arg0) 
	{
		this.connected = true;
		this.attatched = arg0;
	}

	@Override
	public Object[] callMethod(IComputerAccess arg0, int arg1, Object[] arg2)
			throws Exception {
		EntityRobot robot = this.getClosestRobot();
		if (!this.connected)
			throw new Exception ("Peripheral not connected to any ports");
		if (robot != null || this.port == 0)
		{
			//getServoValue
			if (arg1 == 1)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.servos[(Integer) arg2[0]].getValue(robot,(Integer) arg2[0])};
			}
			//setServoValue
			if (arg1 == 2)
			{
				if (arg2 == null || arg2.length != 2) throw new Exception("Invalid paramiters!");
					robot.servos[(Integer) arg2[0]].setValue(robot,(Integer) arg2[0],(Integer) arg2[1]);
			}
			// getServoName
			if (arg1 == 3)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.servos[(Integer) arg2[0]].getName()};
			}
			//getMotorValue
			if (arg1 == 4)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.motors[(Integer) arg2[0]].getValue(robot,(Integer) arg2[0])};
			}
			// getMotorName
			if (arg1 == 5)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.motors[(Integer) arg2[0]].getName()};
			}
			//setMotorValue
			if (arg1 == 6)
			{
				if (arg2 == null || arg2.length != 2) throw new Exception("Invalid paramiters!");
					robot.motors[(Integer) arg2[0]].setValue(robot,(Integer) arg2[0],(Integer) arg2[1]);
			}
			//getSensorValue
			if (arg1 == 7)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.sensors[(Integer) arg2[0]].getValue(robot,(Integer) arg2[0])};
			}
			// getSensorName
			if (arg1 == 8)
			{
				if (arg2 == null) throw new Exception("Invalid paramiters!");
				else return new Object[] {robot.sensors[(Integer) arg2[0]].getName()};
			}
		}
		else if (arg1 == 0)
			if (arg2 == null)
				throw new Exception("Invalid paramiters!");
			else
				this.port = (Integer) arg2[0];
		else
			throw new Exception ("No robot found");
		return null;
	}

	@Override
	public boolean canAttachToSide(int arg0) {
		return true;
	}

	@Override
	public void detach(IComputerAccess arg0) 
	{
		this.connected = false;
	}

	@Override
	public String[] getMethodNames() {
		return new String[] {"setPort", "getServoValue", "setServoValue", "getServoName", "getMotorValue", 
				"getMotorName", "setMotorValue", "getSensorValue", "getSensorName"};
	}

	@Override
	public String getType() {
		return "Samantha Relay";
	}

	public EntityRobot getClosestRobot()
	{
		double var1 = this.xCoord;
		double var2 = this.yCoord;
		double var3 = this.zCoord;
		float var7 = 0.125F;
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)((float)(var1 - 50)+ var7), 
				(double)var2 - 25, (double)((float)(var3 - 50)+ var7), (double)((float)(var1 + 50) 
						- var7), ((double)var2 + 25) + 3.25D, (double)((float)(var3 + 50) - var7));
		List var4 = this.worldObj.getEntitiesWithinAABB(EntityRobot.class, aabb);
		if(var4.isEmpty())
			return null;
		double var5 = 21;
		Object[] var6 = var4.toArray();
		EntityRobot robot = null;
		for(Object ent : var6)
		{
			EntityRobot var8 = (EntityRobot) ent;
			double var9 = var8.posX;
			double var10 = var8.posY;
			double var11 = var8.posZ;
			double d = Math.sqrt(Math.pow(var9 - var1, 2) + Math.pow(var10 - var2, 2) + Math.pow(var11 - var3, 2));
			if (d < var5)
			{
				var5 = d;
				robot = var8;
			}
		}
		if (var5 == 21)
			return null;
		else
			return robot;
	}

}
