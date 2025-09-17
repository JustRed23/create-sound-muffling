package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import dev.JustRed23.createsoundmuffling.items.SoundFilterItem;

public final class CSMItems {

    private static final CreateRegistrate REGISTRATE = CreateSoundMuffling.registrate();

    static {
        REGISTRATE.setCreativeTab(CSMCreativeTabs.BASE_CREATIVE_TAB);
    }

    public static void register() {}

    public static final ItemEntry<SoundFilterItem> SOUND_FILTER = REGISTRATE
            .item("sound_filter", SoundFilterItem::new)
            .register();
}
