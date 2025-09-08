package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlock;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

public final class CSMBlocks {

    private static final CreateRegistrate REGISTRATE = CreateSoundMuffling.registrate();

    static {
        REGISTRATE.setCreativeTab(CSMCreativeTabs.BASE_CREATIVE_TAB);
    }

    public static void register() {}

    private static BlockEntry<SoundMufflerBlock> createMuffler(SoundMufflerBlock.CasingType type, CTSpriteShiftEntry casingSprite, MapColor color) {
        String name = type.name().toLowerCase();
        return REGISTRATE.block(name + "_sound_muffler", p -> new SoundMufflerBlock(p, type))
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.mapColor(color))
                .transform(CSMBlockTransformers.soundMuffler(name, () -> casingSprite))
                .transform(axeOrPickaxe())
                .register();
    }

    public static final BlockEntry<SoundMufflerBlock> ANDESITE_SOUND_MUFFLER = createMuffler(SoundMufflerBlock.CasingType.ANDESITE, AllSpriteShifts.ANDESITE_CASING, MapColor.PODZOL);
    public static final BlockEntry<SoundMufflerBlock> BRASS_SOUND_MUFFLER = createMuffler(SoundMufflerBlock.CasingType.BRASS, AllSpriteShifts.BRASS_CASING, MapColor.TERRACOTTA_BROWN);
    public static final BlockEntry<SoundMufflerBlock> COPPER_SOUND_MUFFLER = createMuffler(SoundMufflerBlock.CasingType.COPPER, AllSpriteShifts.COPPER_CASING, MapColor.TERRACOTTA_LIGHT_GRAY);
}
