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
	public float id;

	public EntityRobot(World par1World) 
	{
		super(par1World);
		this.setSize(0.25F, 0.25F);
	}
	
	public EntityRobot(World par1World, double par2, double par4, double par6) 
	{
		this(par1World);
        this.setSize(this.width, this.height);
        this.setPosition(par2, par4, par6);
        this.yOffset = 0.0F;
	}

	@Override
	protected void entityInit() {}

	@Override
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) 
	{
		super.readFromNBT(par1NBTTagCompound);
        this.height = par1NBTTagCompound.getFloat("Height");
        this.width = par1NBTTagCompound.getFloat("Width");
        this.length = par1NBTTagCompound.getFloat("Length");
        this.id = par1NBTTagCompound.getFloat("ID");
        
        this.sensors = (ItemModule[]) this.getItemArrayFromNBT(par1NBTTagCompound, "Sensors");
        this.motors = (ItemModule[]) this.getItemArrayFromNBT(par1NBTTagCompound, "Motors");
        this.servos = (ItemModule[]) this.getItemArrayFromNBT(par1NBTTagCompound, "Servos");
        this.upgrades = (ItemModule[]) this.getItemArrayFromNBT(par1NBTTagCompound, "Upgrades");
	}
	
	@SuppressWarnings("null")
	private Item[] getItemArrayFromNBT(NBTTagCompound par1NBTTagCompound, String par2)
	{
		NBTTagList var2 = par1NBTTagCompound.getTagList(par2);
		
		Item[] a = null;

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 255;

            if (var5 >= 0 && var5 < a.length)
            {
                a[var3] = (ItemModule) Item.itemsList[256 + var5];
            }
        }
        
        return a;
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) 
	{
		super.writeToNBT(var1);
        var1.setFloat("Height", this.height);
        var1.setFloat("Width", this.width);
        var1.setFloat("Length", this.length);
        var1.setFloat("ID", this.id);
        
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
