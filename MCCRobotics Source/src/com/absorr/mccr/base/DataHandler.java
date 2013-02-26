package com.absorr.mccr.base;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class DataHandler 
{

	public static Map idData = new HashMap();

	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) 
	{
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

	protected void writeEntityToNBT(NBTTagCompound var1) 
	{
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
