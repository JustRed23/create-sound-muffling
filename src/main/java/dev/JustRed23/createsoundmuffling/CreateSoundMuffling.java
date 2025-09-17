package dev.JustRed23.createsoundmuffling;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.JustRed23.createsoundmuffling.registry.*;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CreateSoundMuffling.MODID)
public class CreateSoundMuffling {
    public static final String MODID = "createsoundmuffling";

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public CreateSoundMuffling(IEventBus modEventBus) {
        REGISTRATE.registerEventListeners(modEventBus);
        CSMCreativeTabs.register(modEventBus);
        CSMItems.register();
        CSMBlocks.register();
        CSMBlockEntities.register();
        CSMStress.register();
        CSMMenuTypes.register();
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
