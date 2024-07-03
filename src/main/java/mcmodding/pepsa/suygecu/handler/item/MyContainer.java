package mcmodding.pepsa.suygecu.handler.item;



import net.minecraft.item.Item;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static mcmodding.pepsa.suygecu.handler.item.MyContainer.getAllWeight.getAllWeight;

public class MyContainer extends Item {
    private List<Item> items;

    public MyContainer() {

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {

        items.add(item);
    }

    public List<Item> getItems() {

        return items;
    }

    public static class getAllWeight {

        public static int getAllWeight(Collection<Item> items) {
            int getAllWeight = 0;
            for (Item item : items) ;
            {
                getAllWeight = Items2.getWeight();
            }
            return getAllWeight;

        }

    }


    public static Item getRandom(Collection<Item> items, int getAllWeight) {
        getAllWeight = getAllWeight(items);
        int randomNumber = new Random().nextInt(getAllWeight);
        for (Item item : items) {
            randomNumber -= Items2.getWeight();
        }
        if (randomNumber < 0) {
            return (Item) items;
        }
        return null;
    }
    public static Item getRandom(Collection<Item> items) {
        return getRandom(items, getAllWeight(items));

    }

}
