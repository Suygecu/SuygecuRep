package mcmodding.pepsa.suygecu.handler.gui;

import mcmodding.pepsa.suygecu.handler.container.ContainerLootBox;
import mcmodding.pepsa.suygecu.suygecu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiLootBox extends GuiContainer {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(suygecu.MOD_ID, "textures/gui/lootbox.png");
    private final IInventory lootBoxInventory;

    public GuiLootBox(InventoryPlayer playerInventory, IInventory lootBoxInventory) {
        super(new ContainerLootBox(playerInventory, lootBoxInventory));
        this.lootBoxInventory = lootBoxInventory;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(BACKGROUND);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        for (int i = 0; i < this.lootBoxInventory.getSizeInventory(); i++) {
            ItemStack itemstack = this.lootBoxInventory.getStackInSlot(i);
            if (itemstack != null) {
                int slotX = 8 + (i * 18);
                int slotY = 18;
                this.itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack, slotX, slotY);
            }
        }
    }
}