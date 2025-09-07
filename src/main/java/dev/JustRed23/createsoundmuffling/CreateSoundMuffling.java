package dev.JustRed23.createsoundmuffling;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.JustRed23.createsoundmuffling.blocks.SoundMufflerBlock;
import dev.JustRed23.createsoundmuffling.registry.CSMBlockEntities;
import dev.JustRed23.createsoundmuffling.registry.CSMBlocks;
import dev.JustRed23.createsoundmuffling.registry.CSMCreativeTabs;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(CreateSoundMuffling.MODID)
public class CreateSoundMuffling {
    public static final String MODID = "createsoundmuffling";

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public CreateSoundMuffling(IEventBus modEventBus, ModContainer modContainer) {
        REGISTRATE.registerEventListeners(modEventBus);
        CSMCreativeTabs.register(modEventBus);
        CSMBlocks.register();
        CSMBlockEntities.register();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
