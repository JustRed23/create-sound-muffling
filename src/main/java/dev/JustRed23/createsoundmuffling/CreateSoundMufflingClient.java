package dev.JustRed23.createsoundmuffling;

import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlock;
import dev.JustRed23.createsoundmuffling.registry.CSMBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.sound.PlaySoundEvent;

import java.util.concurrent.atomic.AtomicReference;

@Mod(value = CreateSoundMuffling.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CreateSoundMuffling.MODID, value = Dist.CLIENT)
public class CreateSoundMufflingClient {

    @SubscribeEvent
    static void muffleSoundsInRange(PlaySoundEvent event) {
        if (!(event.getSound() instanceof SimpleSoundInstance instance) || Minecraft.getInstance().level == null) return;
        BlockPos soundPos = BlockPos.containing(instance.getX(), instance.getY(), instance.getZ());
        AABB box = new AABB(soundPos.getX(), soundPos.getY(), soundPos.getZ(), soundPos.getX(), soundPos.getY(), soundPos.getZ()).inflate(SoundMufflerBlock.MAX_RANGE);

        AtomicReference<SoundMufflerBlock.CasingType> bestCasing = new AtomicReference<>();

        BlockPos.betweenClosedStream(box).forEach(pos -> {
            Minecraft.getInstance().level.getBlockEntity(pos, CSMBlockEntities.SOUND_MUFFLER.get()).ifPresent(be -> {
                if (!be.isSpeedRequirementFulfilled()) return;
                if (!be.filtersSound(instance.getLocation())) return;
                if (be.getCasing().isHigherTierThan(bestCasing.get()))
                    bestCasing.set(be.getCasing());
            });
        });

        if (bestCasing.get() != null) {
            float newVolume = (float) (instance.volume * (1 - bestCasing.get().dampening()));
            instance.volume = Math.max(newVolume, 0.05f);
        }
    }
}
