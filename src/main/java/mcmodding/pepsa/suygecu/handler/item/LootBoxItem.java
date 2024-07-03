package mcmodding.pepsa.suygecu.handler.item;

import mcmodding.pepsa.suygecu.handler.GuiHandler;
import mcmodding.pepsa.suygecu.handler.WeightedRandomItem;
import mcmodding.pepsa.suygecu.suygecu;
import mcmodding.pepsa.suygecu.handler.RegItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootBoxItem extends Item {

    public LootBoxItem() {
        setUnlocalizedName("lootbox");
        setTextureName(suygecu.MOD_ID + ":lootbox_item");
        setMaxStackSize(1);

    }


    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            List<ItemStack> items = new ArrayList<>();
            List<WeightedRandomItem> weightedItems = getLootItems();
            for (int i = 0; i < 3; i++) {
                ItemStack randomItem = getRandomItem(weightedItems);
                if (randomItem != null) {
                    items.add(randomItem);
                }
            }
            itemStack.stackSize--;

            player.openGui(suygecu.INSTANCE, GuiHandler.LOOT_BOX_GUI_ID, world, (int) player.posX, (int) player.posY, (int) player.posZ);
            for (ItemStack item : items) {
                player.inventory.addItemStackToInventory(item);
            }
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List tooltip, boolean advanced) {

        List<WeightedRandomItem> items = getLootItems();
        tooltip.add(StatCollector.translateToLocal("item.lootbox.description"));

        for (WeightedRandomItem item : items) {
            ItemStack stack = item.getItemStack();
            String itemName = stack.getDisplayName();
            int weight = item.itemWeight;
            String colorCode = getColorForItem(stack);
            tooltip.add(StatCollector.translateToLocalFormatted("tooltip.lootbox.item",itemName, colorCode, weight));


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



//    private List<WeightedRandomItem> getLootItems() {
//        List<WeightedRandomItem> items = new ArrayList<>();
//        items.add(new WeightedRandomItem(new ItemStack(RegItems.CHLEN), 100));
//        items.add(new WeightedRandomItem(new ItemStack(RegItems.PEPSA), 50));
//        items.add(new WeightedRandomItem(new ItemStack(RegItems.LOOTBOX), 10));
//        return items;
//    }



    private ItemStack getRandomItem(List<WeightedRandomItem> items) {
        WeightedRandomItem randomItem = (WeightedRandomItem) WeightedRandom.getRandomItem(new Random(), items);
        return randomItem != null ? randomItem.itemStack : null;
    }
}