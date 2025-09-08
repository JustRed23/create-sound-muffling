package dev.JustRed23.createsoundmuffling.blocks;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import dev.JustRed23.createsoundmuffling.registry.CSMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class SoundMufflerBlock extends DirectionalKineticBlock implements IBE<SoundMufflerBlockEntity> {

    public enum CasingType {
        ANDESITE(AllBlocks.ANDESITE_CASING.getId(), 1, 0.25),
        BRASS(AllBlocks.BRASS_CASING.getId(), 2, 0.5),
        COPPER(AllBlocks.COPPER_CASING.getId(), 4, 0.75);

        public static Optional<CasingType> fromId(ResourceLocation id) {
            for (CasingType type : values()) {
                if (type.id().equals(id))
                    return Optional.of(type);
            }
            return Optional.empty();
        }

        private final ResourceLocation casing;
        private final double impact;
        private final double dampening;
        CasingType(ResourceLocation casing, double impact, double dampening) {
            this.casing = casing;
            this.impact = impact;
            this.dampening = dampening;
        }

        public boolean isHigherTierThan(CasingType other) {
            return this.impact > other.impact;
        }

        public ResourceLocation id() {
            return casing;
        }

        public double impact() {
            return impact;
        }

        public double dampening() {
            return dampening;
        }
    }

    private CasingType casingType;

    public SoundMufflerBlock(Properties props, CasingType type) {
        super(props);
        this.casingType = type;
    }

    public final Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    public final boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING).getOpposite();
    }

    public final Class<SoundMufflerBlockEntity> getBlockEntityClass() {
        return SoundMufflerBlockEntity.class;
    }

    public final BlockEntityType<? extends SoundMufflerBlockEntity> getBlockEntityType() {
        return CSMBlockEntities.SOUND_MUFFLER.get();
    }

    public final CasingType getCasing() {
        return casingType;
    }

    public final double getStressImpact() {
        return casingType.impact();
    }

    public final double getDampeningFactor() {
        return casingType.dampening();
    }
}
