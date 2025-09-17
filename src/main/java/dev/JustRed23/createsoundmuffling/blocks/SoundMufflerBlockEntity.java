package dev.JustRed23.createsoundmuffling.blocks;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.filtering.FilteringBehaviour;
import com.simibubi.create.foundation.utility.CreateLang;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import dev.JustRed23.createsoundmuffling.registry.CSMItems;
import net.createmod.catnip.lang.LangNumberFormat;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

import static net.minecraft.ChatFormatting.GRAY;

public class SoundMufflerBlockEntity extends KineticBlockEntity {

    private FilteringBehaviour filtering;

    public SoundMufflerBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        filtering = new FilteringBehaviour(this, new SoundMufflerFilterSlotPositioning())
                .withPredicate(CSMItems.SOUND_FILTER::isIn)
                .withCallback(stack -> block().filterChanged(stack));
        behaviours.add(filtering);
    }

    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        super.addToGoggleTooltip(tooltip, isPlayerSneaking);

        CreateLang.builder(CreateSoundMuffling.MODID)
                .translate("tooltip.dampeningImpact")
                .style(GRAY)
                .forGoggles(tooltip);

        SoundMufflerBlock block = (SoundMufflerBlock) getBlockState().getBlock();
        CreateLang.builder(CreateSoundMuffling.MODID)
                .text(LangNumberFormat.format(block.getDampeningFactor() * 100) + "%")
                .style(ChatFormatting.WHITE)
                .forGoggles(tooltip, 1);

        return true;
    }

    private SoundMufflerBlock block() {
        return (SoundMufflerBlock) getBlockState().getBlock();
    }

    public SoundMufflerBlock.CasingType getCasing() {
        return block().getCasing();
    }

    public boolean filtersSound(ResourceLocation sound) {
        return block().filtersSound(sound);
    }
}
