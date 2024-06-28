package mcmodding.pepsa.suygecu.proxy;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import mcmodding.pepsa.suygecu.handler.RegItems;
import mcmodding.pepsa.suygecu.suygecu;
import mcmodding.pepsa.suygecu.handler.GuiHandler;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        FMLLog.info("ClientProxy pretInit");
        RegItems.register();

    }

    public void init(FMLInitializationEvent event) {
        FMLLog.info("ClientProxy init");
        NetworkRegistry.INSTANCE.registerGuiHandler(suygecu.INSTANCE, new GuiHandler());

    }

    public void postInit(FMLPostInitializationEvent event) {
        FMLLog.info("ClientProxy postInit");

    }
}