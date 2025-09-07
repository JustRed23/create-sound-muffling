package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.AllBlocks;
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

    private static BlockEntry<SoundMufflerBlock> createMuffler(String name, BlockEntry<?> casing, CTSpriteShiftEntry casingSprite, MapColor color) {
        return REGISTRATE.block(name + "_sound_muffler", p -> new SoundMufflerBlock(p, casing.getId()))
                .initialProperties(SharedProperties::stone)
                .properties(p -> p.mapColor(color))
                .transform(CSMBlockTransformers.soundMuffler(name, () -> casingSprite))
                .transform(axeOrPickaxe())
                .register();
    }

    public static final BlockEntry<SoundMufflerBlock> ANDESITE_SOUND_MUFFLER = createMuffler("andesite", AllBlocks.ANDESITE_CASING, AllSpriteShifts.ANDESITE_CASING, MapColor.PODZOL);
    public static final BlockEntry<SoundMufflerBlock> BRASS_SOUND_MUFFLER = createMuffler("brass", AllBlocks.BRASS_CASING, AllSpriteShifts.BRASS_CASING, MapColor.TERRACOTTA_BROWN);
    public static final BlockEntry<SoundMufflerBlock> COPPER_SOUND_MUFFLER = createMuffler("copper", AllBlocks.COPPER_CASING, AllSpriteShifts.COPPER_CASING, MapColor.TERRACOTTA_LIGHT_GRAY);
}
