package com.absorr.mccr.base;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class Config 
{
	static Configuration configuration = new Configuration(new File(new File(".").getAbsolutePath(), "config/MCCR.cfg"));
	
	public static int servoID;
	public static int motorID;
	public static int irID;
	public static int sonicID;
	public static int lightID;
	public static int touchID;
	
	public static void loadConfig()
	{
		configuration.load();
		servoID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "servo", 12560).value);
		motorID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "motor", 12561).value);
		irID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "sensorIR", 12562).value);
		sonicID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "sensorSonic", 12563).value);
		lightID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "sensorLight", 12564).value);
		touchID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "sensorTouch", 12565).value);
		configuration.save();
	}
}
