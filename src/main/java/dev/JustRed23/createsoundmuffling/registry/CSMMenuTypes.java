package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.MenuEntry;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import dev.JustRed23.createsoundmuffling.menu.SoundFilterMenu;
import dev.JustRed23.createsoundmuffling.menu.SoundFilterScreen;

public final class CSMMenuTypes {

    private static final CreateRegistrate REGISTRATE = CreateSoundMuffling.registrate();

    public static void register() {}

    public static final MenuEntry<SoundFilterMenu> SOUND_FILTER = REGISTRATE
            .menu("sound_filter", SoundFilterMenu::new, () -> SoundFilterScreen::new)
            .register();
}
