package dev.JustRed23.createsoundmuffling.blocks;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import dev.JustRed23.createsoundmuffling.registry.CSMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SoundMufflerBlock extends DirectionalKineticBlock implements IBE<SoundMufflerBlockEntity> {

    private ResourceLocation casing;

    public SoundMufflerBlock(Properties props, ResourceLocation casing) {
        super(props);
        this.casing = casing;
    }

    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(FACING).getAxis();
    }

    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING).getOpposite();
    }

    public Class<SoundMufflerBlockEntity> getBlockEntityClass() {
        return SoundMufflerBlockEntity.class;
    }

    public BlockEntityType<? extends SoundMufflerBlockEntity> getBlockEntityType() {
        return CSMBlockEntities.SOUND_MUFFLER.get();
    }
}
