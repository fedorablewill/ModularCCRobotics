package com.absorr.mccr.base;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers() 
	{
		MinecraftForgeClient.preloadTexture(itemPic); 
    	MinecraftForgeClient.preloadTexture(blockPic);
	}
}
