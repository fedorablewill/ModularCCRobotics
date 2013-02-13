package com.absorr.mcrr.material;

import com.absorr.mcrr.entity.EntityRobot;

import net.minecraft.item.Item;

public abstract class ItemModule extends Item
{

	/**
	 * 0 - Sensor
	 * 1 - Motor
	 * 2 - Servo
	 * 3 - Inventory
	 */
	public static int type;

	public ItemModule(int par1, int par2) 
	{
		super(par1);
		this.maxStackSize = 1;
		this.type = par2;
	}
	
	/**
	 * Called to get the return value of any module
	 * @param par1Robot Robot that called it
	 * @param par2 Sensor port on robot
	 * @return
	 */
	public abstract int getValue(EntityRobot par1Robot, int par2);
	
	/**
	 * Called to set servo or motor value
	 * @param par1Robot Robot that called it
	 * @param par2 Sensor port on robot
	 * @param par3 Value to set
	 */
	public abstract void setValue(EntityRobot par1Robot, int par2, int par3);

}
