package com.absorr.mcrr.entity;

import com.absorr.mcrr.material.ItemModule;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityRobot extends Entity
{

	public float width;
	public float length;
	public float height;
	public ItemModule sensor1;
	public ItemModule sensor2;
	public ItemModule sensor3;
	public ItemModule sensor4;
	public ItemModule motor1;
	public ItemModule motor2;
	public ItemModule servo1;
	public ItemModule servo2;
	public ItemModule invModule;
	public ItemStack[] inventory;

	public EntityRobot(World par1World, float par2, float par3) 
	{
		super(par1World);
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		// TODO Auto-generated method stub
		
	}

}
