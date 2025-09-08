package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.api.registry.SimpleRegistry;
import com.simibubi.create.api.stress.BlockStressValues;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlock;
import net.minecraft.world.level.block.Block;

import java.util.function.DoubleSupplier;

public final class CSMStress {

    public static void register() {
        BlockStressValues.IMPACTS.registerProvider(SOUND_MUFFLER_IMPACT);
    }

    public static final SimpleRegistry.Provider<Block, DoubleSupplier> SOUND_MUFFLER_IMPACT = (block) -> {
        if (block instanceof SoundMufflerBlock stressBlock)
            return () -> stressBlock.getStressImpact();
        return null;
    };
}
