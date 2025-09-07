package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public final class CSMBlockTransformers {

    private static <B extends DirectionalKineticBlock, P> BlockBuilder<B, P> encasedBase(BlockBuilder<B, P> b) {
        return b.initialProperties(SharedProperties::stone)
                .properties(BlockBehaviour.Properties::noOcclusion);
    }

    public static <B extends SoundMufflerBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> soundMuffler(String casing, Supplier<CTSpriteShiftEntry> casingShift) {
        return builder -> encasedBase(builder)
                .blockstate((c, p) -> p.directionalBlock(c.get(), blockState -> p.models().getExistingFile(p.modLoc("block/sound_muffler/block_" + casing))))
                .item()
                .model(AssetLookup.customBlockItemModel("sound_muffler", "item_" + casing))
                .build();
    }
}
