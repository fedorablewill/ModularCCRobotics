package com.absorr.mcrr.entity;

import java.util.HashMap;
import java.util.Map;

import com.absorr.mcrr.material.ItemModule;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class EntityRobot extends Entity
{
	public float width;
	public float length;
	public float height;
	public ItemModule[] sensors;
	public ItemModule[] motors;
	public ItemModule[] servos;
	public ItemModule[] upgrades;
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
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) 
	{
		super.readFromNBT(par1NBTTagCompound);
        this.height = par1NBTTagCompound.getFloat("Height");
        this.width = par1NBTTagCompound.getFloat("Width");
        this.length = par1NBTTagCompound.getFloat("Length");
        
        NBTTagList var2 = par1NBTTagCompound.getTagList("Sensors");

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 255;

            if (var5 >= 0 && var5 < this.sensors.length)
            {
                this.sensors[var3] = (ItemModule) Item.itemsList[256 + var5];
            }
        }
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) 
	{
		super.writeToNBT(var1);
        var1.setFloat("Height", this.height);
        var1.setFloat("Width", this.width);
        var1.setFloat("Length", this.length);
        
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.sensors.length; ++var3)
        {
            if (this.sensors[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setInteger("Slot", this.sensors[var3].id);
                var2.appendTag(var4);
            }
        }

        var1.setTag("Sensors", var2);
        
        NBTTagList var5 = new NBTTagList();

        for (int var3 = 0; var3 < this.servos.length; ++var3)
        {
            if (this.servos[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setInteger("Slot", this.servos[var3].id);
                var5.appendTag(var4);
            }
        }

        var1.setTag("Servos", var5);
        
        NBTTagList var6 = new NBTTagList();

        for (int var3 = 0; var3 < this.motors.length; ++var3)
        {
            if (this.motors[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setInteger("Slot", this.motors[var3].id);
                var5.appendTag(var4);
            }
        }
        
        var1.setTag("Motors", var6);
        
        NBTTagList var7 = new NBTTagList();

        for (int var3 = 0; var3 < this.upgrades.length; ++var3)
        {
            if (this.upgrades[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setInteger("Slot", this.upgrades[var3].id);
                var5.appendTag(var4);
            }
        }
        
        var1.setTag("Upgrades", var7);
	}

}
