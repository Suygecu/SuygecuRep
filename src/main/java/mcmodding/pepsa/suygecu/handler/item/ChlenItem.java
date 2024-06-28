package mcmodding.pepsa.suygecu.handler.item;

import mcmodding.pepsa.suygecu.suygecu;
import net.minecraft.item.Item;

public class ChlenItem extends Item {
    public ChlenItem() {
        setUnlocalizedName("chlen");
        setTextureName(suygecu.MOD_ID + ":chlen_items");
        setMaxStackSize(1);
    }
}