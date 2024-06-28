package mcmodding.pepsa.suygecu.handler;

import mcmodding.pepsa.suygecu.handler.container.ContainerLootBox;
import mcmodding.pepsa.suygecu.handler.gui.GuiLootBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.inventory.InventoryBasic;

public class GuiHandler implements IGuiHandler {
    public static final int LOOT_BOX_GUI_ID = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == LOOT_BOX_GUI_ID) {
            return new ContainerLootBox(player.inventory, new InventoryBasic("lootBox", true, 27)); // Пример инвентаря
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == LOOT_BOX_GUI_ID) {
            return new GuiLootBox(player.inventory, new InventoryBasic("lootBox", true, 27)); // Пример инвентаря
        }
        return null;
    }
}