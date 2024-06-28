package mcmodding.pepsa.suygecu.handler.item;

import mcmodding.pepsa.suygecu.handler.GuiHandler;
import mcmodding.pepsa.suygecu.handler.WeightedRandomItem;
import mcmodding.pepsa.suygecu.suygecu;
import mcmodding.pepsa.suygecu.handler.RegItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
            List<ItemStack> items = new ArrayList<ItemStack>();
            List<WeightedRandomItem> weightedItems = getLootItems();
            for (int i = 0; i < 3; i++) {
                ItemStack randomItem = getRandomItem(weightedItems);
                if (randomItem != null) {
                    items.add(randomItem);
                }
            }
            itemStack.stackSize--;

            player.openGui(suygecu.INSTANCE, GuiHandler.LOOT_BOX_GUI_ID, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        return itemStack;
    }

    private List<WeightedRandomItem> getLootItems() {
        List<WeightedRandomItem> items = new ArrayList<WeightedRandomItem>();
        items.add(new WeightedRandomItem(new ItemStack(RegItems.CHLEN), 60));
        items.add(new WeightedRandomItem(new ItemStack(RegItems.PEPSA), 20));
        items.add(new WeightedRandomItem(new ItemStack(RegItems.LOOTBOX), 10));
        return items;
    }

    private ItemStack getRandomItem(List<WeightedRandomItem> items) {
        WeightedRandomItem randomItem = (WeightedRandomItem) WeightedRandom.getRandomItem(new Random(), items);
        return randomItem != null ? randomItem.stack : null;
    }
}