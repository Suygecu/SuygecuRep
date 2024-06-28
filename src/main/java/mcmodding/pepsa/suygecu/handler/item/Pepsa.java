package mcmodding.pepsa.suygecu.handler.item;

import mcmodding.pepsa.suygecu.suygecu;
import net.minecraft.item.Item;

public class Pepsa extends Item {
    public Pepsa() {
        setUnlocalizedName("pepsa");
        setTextureName(suygecu.MOD_ID + ":pepsa_items");
        setMaxStackSize(1);
    }
}