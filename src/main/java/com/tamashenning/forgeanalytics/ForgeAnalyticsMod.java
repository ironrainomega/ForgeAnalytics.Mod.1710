package com.tamashenning.forgeanalytics;

import com.tamashenning.forgeanalytics.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ForgeAnalyticsMod.MODID, name = ForgeAnalyticsMod.MODNAME, version = ForgeAnalyticsMod.VERSION)
public class ForgeAnalyticsMod {

	public static final String MODID = "forgeanalytics";
	public static final String MODNAME = "Forge Analytics";
	public static final String VERSION = "0.0.4";

	@SidedProxy(clientSide = "com.tamashenning.forgeanalytics.proxies.ClientProxy", serverSide = "com.tamashenning.forgeanalytics.proxies.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent e) {

	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent e) {
		AnalyticsClient ac = new AnalyticsClient();
		try {
			ac.UploadModel(ac.CreateServerStartupPing(), false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@EventHandler
	public void serverStopped(FMLServerStoppedEvent e) {
		AnalyticsClient ac = new AnalyticsClient();
		try {
			ac.UploadModel(ac.CreateServerStoppedPing(), false);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
