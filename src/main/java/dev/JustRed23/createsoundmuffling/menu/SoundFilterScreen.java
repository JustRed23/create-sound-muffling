package dev.JustRed23.createsoundmuffling.menu;

import com.simibubi.create.content.logistics.filter.AbstractFilterScreen;
import com.simibubi.create.foundation.gui.widget.IconButton;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SoundFilterScreen extends AbstractFilterScreen<SoundFilterMenu> {

    public SoundFilterScreen(SoundFilterMenu menu, Inventory inv, Component title) {
        super(menu, inv, title, null); //TODO: AllGuiTextures.FILTER
    }

    protected boolean isButtonEnabled(IconButton button) {
        return false;
    }
}
