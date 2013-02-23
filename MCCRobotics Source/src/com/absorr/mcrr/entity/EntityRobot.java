package com.absorr.mcrr.entity;

import java.util.HashMap;
import java.util.Map;

import com.absorr.mcrr.material.ItemModule;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class EntityRobot extends Entity
{

	public static Map idData = new HashMap();
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
	//TODO: Create separate data file for ID data keeping
	//TODO: Create NBT saving for individual robot contents (add-ons, dimensions, etc)
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) 
	{
		super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("IDMap");

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            String var5 = var4.getString(var3 + "");

            if (var5 != null && !idData.containsKey(var3))
            {
            	idData.put(var3, var5);
            }
        }
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		super.writeToNBT(var1);
        NBTTagList var2 = new NBTTagList();
        
        for (int var3 = 0; var3 < this.idData.keySet().toArray().length; ++var3)
        {
            if (this.idData.get(var3) != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setString(var3 + "", (String) idData.get(var3));
                var2.appendTag(var4);
            }
        }

        var1.setTag("IDMap", var2);
	}

}
