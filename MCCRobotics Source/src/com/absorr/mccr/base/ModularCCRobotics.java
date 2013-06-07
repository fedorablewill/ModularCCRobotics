package com.absorr.mccr.base;

import com.absorr.mcrr.entity.EntityRobot;
import com.absorr.mcrr.material.ModuleSensorIR;
import com.absorr.mcrr.material.ModuleSensorLight;
import com.absorr.mcrr.material.ModuleSensorSonic;
import com.absorr.mcrr.material.ModuleSensorTouch;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
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
		proxy.registerRenderers();
		EntityRegistry.registerModEntity(EntityRobot.class, "Modular Robot", 1, instance, 40, 3, true);
		LanguageRegistry.instance().addStringLocalization("com.absorr.mccr.entity.EntityRobot.name", "Robot");
		
		servo = new Item(Config.servoID).setUnlocalizedName("servo");
		motor = new Item(Config.motorID).setUnlocalizedName("motor");
		sensorIR = new ModuleSensorIR(Config.irID).setUnlocalizedName("sensorIR");
		sensorTouch = new ModuleSensorTouch(Config.touchID).setUnlocalizedName("sensorTouch");
		sensorLight = new ModuleSensorLight(Config.lightID).setUnlocalizedName("sensorLight");
		sensorSonic = new ModuleSensorSonic(Config.sonicID).setUnlocalizedName("sensorUltrasonic");
		
		loadMaterials();
	}
	
	private static void loadMaterials()
	{
		//Servo
		LanguageRegistry.addName(servo, "Servo");
		GameRegistry.addRecipe(new ItemStack(servo, 1), new Object[] { 
	        "SSO", "RGI", "SSO", Character.valueOf('S'), Block.stone, Character.valueOf('G'), Item.ingotGold, Character.valueOf('R'), 
	        Item.redstone, Character.valueOf('I'), Item.stick}); 
		
		//Motor
		LanguageRegistry.addName(motor, "Motor");
		GameRegistry.addRecipe(new ItemStack(motor, 1), new Object[] { 
	        "SSO", "RGI", "SSO", Character.valueOf('S'), Block.stone, Character.valueOf('G'), Item.ingotGold, Character.valueOf('R'), 
	        Item.redstone, Character.valueOf('I'), Item.blazeRod});
		
		//IR Sensor
		LanguageRegistry.addName(sensorIR, "IR Sensor");
		GameRegistry.addRecipe(new ItemStack(sensorIR, 1), new Object[] { 
	        "ISS", "GBR", "ISS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Block.stone, Character.valueOf('R'),
	        Item.redstone, Character.valueOf('B'), Item.fireballCharge, Character.valueOf('G'), Block.thinGlass});
		
		//Touch Sensor
		LanguageRegistry.addName(sensorTouch, "Touch Sensor");
		GameRegistry.addRecipe(new ItemStack(sensorTouch), new Object[] {
			"ISS", "BRR", "ISS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Block.stone, Character.valueOf('R'),
			Item.redstone, Character.valueOf('B'), Block.woodenButton});
		
		//Light Sensor
		LanguageRegistry.addName(sensorLight, "Light Sensor");
		GameRegistry.addRecipe(new ItemStack(sensorLight), new Object[] {
			"ISS", "PGR", "ISS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Block.stone, Character.valueOf('R'),
	        Item.redstone, Character.valueOf('G'), Item.lightStoneDust, Character.valueOf('P'), Block.thinGlass});
		
		//Ultrasonic Sensor
		LanguageRegistry.addName(sensorSonic, "Ultrasonic Sensor");
		GameRegistry.addRecipe(new ItemStack(sensorSonic), new Object[] {
			"ISS", "PGR", "ISS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Block.stone, Character.valueOf('R'),
	        Item.redstone, Character.valueOf('G'), Block.music, Character.valueOf('P'), Block.thinGlass});
	}
}
