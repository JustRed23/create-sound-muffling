package dev.JustRed23.createsoundmuffling;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.loading.DatagenModLoader;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Mod(CreateSoundMuffling.MODID)
public final class CSMDataGen {

    private static final CreateRegistrate REGISTRATE = CreateSoundMuffling.registrate();

    public CSMDataGen(IEventBus modBus) {
        if (!DatagenModLoader.isRunningDataGen())
            return;

        REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> provideDefaultLang("interface", provider::add));
        modBus.register(this);
    }

    private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/" + CreateSoundMuffling.MODID + "/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }

    @SubscribeEvent
    public void onGatherData(GatherDataEvent event) {
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        DataGenerator gen = event.getGenerator();
        PackOutput out = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //TODO
    }
}
