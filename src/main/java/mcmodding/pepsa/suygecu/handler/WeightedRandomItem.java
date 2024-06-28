package mcmodding.pepsa.suygecu.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
public class WeightedRandomItem extends WeightedRandom.Item {
    public final ItemStack stack;

    public WeightedRandomItem(ItemStack stack, int weight) {
        super(weight);
        this.stack = stack;
    }
}
