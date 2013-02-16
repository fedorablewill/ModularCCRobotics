package com.absorr.mccr.base;

import com.absorr.mcrr.entity.EntityRobot;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ModCCRobot", name="Modular CC Robotics", version="Build 008")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ModularCCRobotics 
{
	@SidedProxy(clientSide = "com.absorr.mccr.base.ClientProxy", serverSide = "com.absorr.mccr.base.CommonProxy", bukkitSide = "absorr.morered.base.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static ModularCCRobotics instance;
	
	//Blocks
	public static Block assembler;
	public static Block peripheral;
	
	//Base Parts
	public static Item robot;
	public static Item core;
	public static Item structure;
	public static Item limb;
	
	//Other Modules
	public static Item motor;
	public static Item servo;
	public static Item sensorIR;
	public static Item sensorTouch;
	public static Item sensorLight;
	public static Item sensorSonic;
	public static Item sensorEntity;
	public static Item sensorInventory;
	public static Item sensorCrop;
	public static Item inventory;
	
	@Init
	public static void load(FMLInitializationEvent event)
	{
		EntityRegistry.registerModEntity(EntityRobot.class, "Modular Robot", 1, instance, 40, 3, true);
		LanguageRegistry.instance().addStringLocalization("com.absorr.mccr.entity.EntityRobot.name", "Robot");
	}
}
