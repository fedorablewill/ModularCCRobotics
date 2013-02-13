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
	
	public static int textureX;
	public static int textureY;

	/**
	 * Creates the module. Use this to create your module
	 * @param par1 Item ID
	 * @param par2 Module Type
	 * @param par3 Texture x
	 * @param par4 Texture y
	 */
	public ItemModule(int par1, int par2, int par3, int par4) 
	{
		super(par1);
		this.maxStackSize = 1;
		this.type = par2;
		this.textureX = par3;
		this.textureY = par4;
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
