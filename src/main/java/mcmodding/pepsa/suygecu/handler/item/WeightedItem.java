package mcmodding.pepsa.suygecu.handler.item;


import net.minecraft.item.Item;


public class WeightedItem {
    private final Item item;
    private final int weight;

    public WeightedItem(Item item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public Item getItem() {
        return item;
    }

    public int getWeight() {
        return weight;
    }
}
