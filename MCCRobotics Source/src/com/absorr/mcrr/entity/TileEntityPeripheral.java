package com.absorr.mcrr.entity;

import java.util.List;

import com.absorr.mcrr.material.ItemModule;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import dan200.computer.api.IComputerAccess;
import dan200.computer.api.IPeripheral;

public class TileEntityPeripheral extends TileEntity implements IPeripheral {

	public IComputerAccess computer;
	public float id = 0;

	@Override
	public String getType() {
		return "Robot Communicator";
	}

	@Override
	public String[] getMethodNames() {
		String[] var1 = {"getRobot", "getServoValue", "setServoValue", "getServoName", "getSensorValue", 
				"getSensorName", "getMotorPower", "setMotorPower", "getMotorName"};
		return var1;
	}
	
	private EntityRobot getRobotInRangeWithID(float range, float id)
	{
		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(this.xCoord - range, this.yCoord - range, 
				this.zCoord - range, this.xCoord + range, this.yCoord + range, this.zCoord + range);
		List var1 = this.worldObj.getEntitiesWithinAABB(EntityRobot.class, aabb);
		Object[] var2 = var1.toArray();
		EntityRobot var3 = null;
		for (Object var4 : var2)
		{
			EntityRobot var5 = (EntityRobot) var4;
			double d = Math.sqrt(Math.pow(var5.posX - this.xCoord, 2) + Math.pow(var5.posY - this.yCoord, 2) + Math.pow(var5.posZ - this.zCoord, 2));
			if (d < range && var5.id == id)
				var3 = var5;
		}
		return var3;
	}

	@SuppressWarnings("null")
	@Override
	public Object[] callMethod(IComputerAccess computer, int method,
			Object[] arguments) throws Exception {
		Object[] var1 = null;
		
		//getRobot
		if (method == 0)
		{
			if (arguments.length != 1)
			{
				var1[0] = false;
				throw new Exception("Invalid arguments!");
			}
			else
			{
				var1[0] = true;
				this.id = (Float) arguments[0];
			}
		}

		//getServoValue
		if (method == 1)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.servos[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Servo not found in port!");
				else
					var1[0] = var3.getValue(var2, (Integer) arguments[0]);
			}
		}

		//setServoValue
		if (method == 2)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 2)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.servos[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Servo not found in port!");
				else
					var3.setValue(var2, (Integer) arguments[0], (Integer) arguments[1]);
			}
		}

		//getServoName
		if (method == 3)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.servos[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Servo not found in port!");
				else
					var1[0] = var3.getName();
			}
		}

		//getSensorValue
		if (method == 4)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.sensors[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Sensor not found in port!");
				else
					var1[0] = var3.getValue(var2, (Integer) arguments[0]);
			}
		}

		//getSensorName
		if (method == 5)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.sensors[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Sensor not found in port!");
				else
					var1[0] = var3.getName();
			}
		}

		//getMotorValue
		if (method == 6)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.motors[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Motor not found in port!");
				else
					var1[0] = var3.getValue(var2, (Integer) arguments[0]);
			}
		}

		//setMotorValue
		if (method == 7)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 2)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.motors[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Motor not found in port!");
				else
					var3.setValue(var2, (Integer) arguments[0], (Integer) arguments[1]);
			}
		}

		//gerMotorName
		if (method == 8)
		{
			if (this.id == 0)
				throw new Exception("Robot ID not set!");
			else if (arguments.length != 1)
				throw new Exception("Invalid arguments!");
			else
			{
				EntityRobot var2 = getRobotInRangeWithID(50, this.id);
				ItemModule var3 = var2.motors[(Integer) arguments[0]];
				if (var3 == null)
					throw new Exception("Motor not found in port!");
				else
					var1[0] = var3.getName();
			}
		}
		
		return var1;
	}

	@Override
	public boolean canAttachToSide(int side) {
		return true;
	}

	@Override
	public void attach(IComputerAccess computer) {
		this.computer = computer;
	}

	@Override
	public void detach(IComputerAccess computer) {
		this.computer = null;
	}

}
