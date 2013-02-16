package com.absorr.mcrr.material;

import java.util.HashMap;
import java.util.Map;
import com.absorr.mcrr.entity.EntityRobot;

import net.minecraft.item.Item;

public abstract class ItemModule extends Item
{

	protected static Map sensorMap = new HashMap();
	protected static Map motorMap = new HashMap();
	protected static Map servoMap = new HashMap();
	protected static Map invMap = new HashMap();
	
	/**
	 * 0 - Sensor
	 * 1 - Motor
	 * 2 - Servo
	 * 3 - Inventory
	 */
	public int type;
	public int id;
	public int textureX;
	public int textureY;

	/**
	 * Creates the module. Use this to create your module
	 * @param par1 Item ID
	 * @param par2 Module Type
	 * @param par3 Module ID
	 * @param par4 Class (Use self!)
	 */
	public ItemModule(int par1, int par2, int par3, Class par4)
	{
		super(par1);
		this.maxStackSize = 1;
		this.type = par2;
		if (type == 0)
			if (sensorMap.containsKey(par3) || par3 > 21 || par3 < 0)
				System.out.println("[SEVERE][ModularCCRobotics]: Sensor ID already exists or is out of bounds!");
			else
				sensorMap.put(par3, par4);
		else if (type == 1)
			if (motorMap.containsKey(par3) || par3 > 21 || par3 < 0)
				System.out.println("[SEVERE][ModularCCRobotics]: Motor ID already exists or is out of bounds!");
			else
				motorMap.put(par3, par4);
		else if (type == 2)
			if (servoMap.containsKey(par3) || par3 > 21 || par3 < 0)
				System.out.println("[SEVERE][ModularCCRobotics]: Servo ID already exists or is out of bounds!");
			else
				servoMap.put(par3, par4);
		else if (type == 3)
			if (invMap.containsKey(par3) || par3 > 21 || par3 < 0)
				System.out.println("[SEVERE][ModularCCRobotics]: Inventory Module ID already exists or is out of bounds!");
			else
				invMap.put(par3, par4);
		else
			System.out.println("[SEVERE][ModularCCRobotics]: Invalid module type!");
		this.id = par3;
		this.getTexturePosition();
	}
	
	protected void getTexturePosition()
	{
		if (type == 0)
		{
			this.textureY = 0;
			this.textureX = this.id * 12;
		}
	}
	
	/**
	 * Called to get the return value of any module
	 * @param par1Robot Robot that called it
	 * @param par2 Sensor port on robot
	 * @return
	 */
	public abstract int getValue(EntityRobot par1Robot, int par2);
	
	/**
	 * Called to set servo or motor value. NOT USED IN SENSORS!
	 * @param par1Robot Robot that called it
	 * @param par2 Sensor port on robot
	 * @param par3 Value to set
	 */
	public abstract void setValue(EntityRobot par1Robot, int par2, int par3);
	
	/**
	 * Name of the module
	 * @return
	 */
	public abstract String getName();

}
