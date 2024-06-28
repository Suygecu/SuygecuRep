package mcmodding.pepsa.suygecu;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import mcmodding.pepsa.suygecu.handler.GuiHandler;
import mcmodding.pepsa.suygecu.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = suygecu.MOD_ID, version = suygecu.VERSION)
public class suygecu {
    public static final String MOD_ID = "suygecu";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static suygecu INSTANCE;

    @SidedProxy(clientSide = "mcmodding.pepsa.suygecu.proxy.ClientProxy", serverSide = "mcmodding.pepsa.suygecu.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        // Предварительная инициализация: настройки, регистрация элементов и т.д.
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}