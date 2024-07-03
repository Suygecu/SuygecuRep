package mcmodding.pepsa.suygecu.proxy;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        FMLLog.info("ClientProxy preInit");
        FMLLog.info("ClientProxy preInit");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        FMLLog.info("ClientProxy init");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        FMLLog.info("ClientProxy postInit");
    }
}
