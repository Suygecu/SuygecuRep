package mcmodding.pepsa.suygecu.handler.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLootBox extends Container {
    private final IInventory lootBoxInventory;

    public ContainerLootBox(IInventory playerInventory, IInventory lootBoxInventory) {
        this.lootBoxInventory = lootBoxInventory;

        // Добавляем слоты для инвентаря лутбокса
        for (int i = 0; i < lootBoxInventory.getSizeInventory(); i++) {
            this.addSlotToContainer(new Slot(lootBoxInventory, i, 8 + (i * 18), 18));
        }

        // Добавляем слоты для инвентаря игрока
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 50 + row * 18));
            }
        }

        // Добавляем слоты для панели быстрого доступа игрока
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 108));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        // Реализация перетаскивания предметов между инвентарями
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.lootBoxInventory.getSizeInventory()) {
                if (!this.mergeItemStack(itemstack1, this.lootBoxInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.lootBoxInventory.getSizeInventory(), false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}