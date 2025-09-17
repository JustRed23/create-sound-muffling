package dev.JustRed23.createsoundmuffling.menu;

import com.simibubi.create.content.logistics.filter.AbstractFilterMenu;
import dev.JustRed23.createsoundmuffling.registry.CSMMenuTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class SoundFilterMenu  extends AbstractFilterMenu {

    public SoundFilterMenu(MenuType<?> type, int id, Inventory inv, RegistryFriendlyByteBuf extraData) {
        super(type, id, inv, extraData);
    }

    public SoundFilterMenu(MenuType<?> type, int id, Inventory inv, ItemStack contentHolder) {
        super(type, id, inv, contentHolder);
    }

    public static SoundFilterMenu create(int id, Inventory inv, ItemStack stack) {
		return new SoundFilterMenu(CSMMenuTypes.SOUND_FILTER.get(), id, inv, stack);
	}

    protected int getPlayerInventoryXOffset() {
        return 0; //TODO
    }

    protected int getPlayerInventoryYOffset() {
        return 0; //TODO
    }

    protected void addFilterSlots() {
        //TODO
    }

    public void clearContents() {
        //TODO
    }

    protected void initAndReadInventory(ItemStack contentHolder) {
        super.initAndReadInventory(contentHolder);
        //TODO
    }

    protected void saveData(ItemStack contentHolder) {
        super.saveData(contentHolder);
        //TODO
    }

    protected ItemStackHandler createGhostInventory() {
        return new ItemStackHandler();
    }

    public @NotNull ItemStack quickMoveStack(Player playerIn, int index) {
        return ItemStack.EMPTY;
    }
}
