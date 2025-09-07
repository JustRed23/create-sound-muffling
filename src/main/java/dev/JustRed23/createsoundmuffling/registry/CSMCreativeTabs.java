package dev.JustRed23.createsoundmuffling.registry;

import com.simibubi.create.AllCreativeModeTabs;
import dev.JustRed23.createsoundmuffling.CreateSoundMuffling;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CSMCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateSoundMuffling.MODID);

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_CREATIVE_TAB = CREATIVE_MODE_TABS.register("base",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createsoundmuffling.base"))
                    .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getId())
                    .icon(CSMBlocks.ANDESITE_SOUND_MUFFLER::asStack)
                    .displayItems((params, output) -> {
                        output.accept(CSMBlocks.ANDESITE_SOUND_MUFFLER);
                        output.accept(CSMBlocks.BRASS_SOUND_MUFFLER);
                        output.accept(CSMBlocks.COPPER_SOUND_MUFFLER);
                    })
                    .build());
}
