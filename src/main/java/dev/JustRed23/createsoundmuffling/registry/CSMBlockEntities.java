package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlockEntity;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlockRenderer;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerVisual;

public final class CSMBlockEntities {

    private static final CreateRegistrate REGISTRATE = CreateSoundMuffling.registrate();

    public static void register() {}

    public static final BlockEntityEntry<SoundMufflerBlockEntity> SOUND_MUFFLER = REGISTRATE
            .blockEntity("sound_muffler", SoundMufflerBlockEntity::new)
            .visual(() -> SoundMufflerVisual::new, false)
            .validBlocks(CSMBlocks.ANDESITE_SOUND_MUFFLER, CSMBlocks.BRASS_SOUND_MUFFLER, CSMBlocks.COPPER_SOUND_MUFFLER)
            .renderer(() -> SoundMufflerBlockRenderer::new)
            .register();
}
