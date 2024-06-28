package mcmodding.pepsa.suygecu.handler;

import mcmodding.pepsa.suygecu.handler.item.ChlenItem;
import cpw.mods.fml.common.registry.GameRegistry;
import mcmodding.pepsa.suygecu.handler.item.LootBoxItem;
import mcmodding.pepsa.suygecu.handler.item.Pepsa;


public class RegItems {
        public static final ChlenItem CHLEN = new ChlenItem();
        public static final LootBoxItem LOOTBOX = new LootBoxItem();
        public static final Pepsa PEPSA = new Pepsa();

        public static void register() {
            System.out.println("Registering items...");
            GameRegistry.registerItem(CHLEN, "chlen");
            GameRegistry.registerItem(LOOTBOX, "lootbox");
            GameRegistry.registerItem(PEPSA, "pepsa");
        }
}