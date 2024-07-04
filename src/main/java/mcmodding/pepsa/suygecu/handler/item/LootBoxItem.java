package mcmodding.pepsa.suygecu.handler.item;

import mcmodding.pepsa.suygecu.handler.GuiHandler;
import mcmodding.pepsa.suygecu.suygecu;
import mcmodding.pepsa.suygecu.handler.RegItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootBoxItem extends Item {

    private final List<WeightedItem> items;

    public LootBoxItem() {
        this.items = new ArrayList<>();
        setUnlocalizedName("lootbox");
        setTextureName(suygecu.MOD_ID + ":lootbox_item");
        setMaxStackSize(1);


        addItem(RegItems.CHLEN, 100);
        addItem(RegItems.PEPSA, 50);
        addItem(RegItems.LOOTBOX, 10);
    }

    public void addItem(Item item, int weight) {
        items.add(new WeightedItem(item, weight));
    }

    public List<WeightedItem> getItems() {
        return items;
    }

    public static class WeightCalculator {
        public static int getAllWeight(List<WeightedItem> items) {
            int totalWeight = 0;
            for (WeightedItem weightedItem : items) {
                totalWeight += weightedItem.getWeight();
            }
            return totalWeight;
        }
    }

    public Item getRandomItem(List<WeightedItem> items) {
        int totalWeight = WeightCalculator.getAllWeight(items);
        int randomNumber = new Random().nextInt(totalWeight);
        for (WeightedItem weightedItem : items) {
            randomNumber -= weightedItem.getWeight();
            if (randomNumber < 0) {
                return weightedItem.getItem();
            }
        }
        return null;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            List<ItemStack> itemsToAdd = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Item randomItem = getRandomItem(this.items);
                if (randomItem != null) {
                    itemsToAdd.add(new ItemStack(randomItem));
                }
            }
            itemStack.stackSize--;

            player.openGui(suygecu.INSTANCE, GuiHandler.LOOT_BOX_GUI_ID, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            for (ItemStack item : itemsToAdd) {
                player.inventory.addItemStackToInventory(item);
            }
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List tooltip, boolean advanced) {
        tooltip.add(StatCollector.translateToLocal("item.lootbox.description"));

        for (WeightedItem weightedItem : items) {
            String itemName = new ItemStack(weightedItem.getItem()).getDisplayName();
            int weight = weightedItem.getWeight();
            String colorCode = getColorForItem(new ItemStack(weightedItem.getItem()));
            tooltip.add(StatCollector.translateToLocalFormatted("tooltip.lootbox.item", itemName, colorCode, weight));
        }
    }

    private String getColorForItem(ItemStack stack) {
        if (stack.getItem() == RegItems.CHLEN) {
            return "§f";
        } else if (stack.getItem() == RegItems.PEPSA) {
            return "§9";
        } else if (stack.getItem() == RegItems.LOOTBOX) {
            return "§c";
        }
        return "§f";
    }

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
}