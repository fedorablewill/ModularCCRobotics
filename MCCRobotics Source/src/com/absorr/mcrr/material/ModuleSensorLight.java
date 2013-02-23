package com.absorr.mcrr.material;

import com.absorr.mcrr.entity.EntityRobot;

public class ModuleSensorLight extends ItemModule
{

	public ModuleSensorLight(int par1) 
	{
		super(par1, 0, 3, ModuleSensorLight.class);
	}

	@Override
	public int getValue(EntityRobot par1Robot, int par2) 
	{
		return par1Robot.worldObj.getBlockLightValue((int)par1Robot.posX, (int)par1Robot.posY, (int)par1Robot.posZ);
	}

	@Override
	public void setValue(EntityRobot par1Robot, int par2, int par3) {}

	@Override
	public String getName() {return "Light";}

}
