package mcmodding.pepsa.suygecu.handler;

import mcmodding.pepsa.suygecu.handler.item.ChlenItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
public class WeightedRandomItem extends WeightedRandom.Item {
    public final ItemStack itemStack;

    public WeightedRandomItem(ItemStack itemStack, int weight) {
        super(weight);
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

}
