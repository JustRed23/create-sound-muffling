package dev.JustRed23.createsoundmuffling.blocks;

import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SoundMufflerFilterSlotPositioning extends ValueBoxTransform.Sided {

    @Override
    public Vec3 getLocalOffset(LevelAccessor level, BlockPos pos, BlockState state) {
        Direction side = getSide();
        float horizontalAngle = AngleHelper.horizontalAngle(side);
        Vec3 southLocation = VecHelper.voxelSpace(8, 11, 15.5f);
        return VecHelper.rotateCentered(southLocation, horizontalAngle, Direction.Axis.Y);
    }

    @Override
    protected boolean isSideActive(BlockState state, Direction direction) {
        return direction.getAxis()
                .isHorizontal();
    }

    @Override
    protected Vec3 getSouthLocation() {
        return Vec3.ZERO;
    }

}