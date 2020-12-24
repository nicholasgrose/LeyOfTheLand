package mod.lotl.common.worldgen

import mod.lotl.common.worldgen.biome.ModBiomes
import mod.lotl.common.worldgen.configured_feature.ore.CrystallizedLeyOreFeature
import net.minecraft.util.RegistryKey
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import thedarkcolour.kotlinforforge.eventbus.KotlinEventBusWrapper
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object WorldGenRegistrationManager {
    fun registerWorldGeneration(forgeBus: KotlinEventBusWrapper) {
        forgeBus.addListener(::onBiomeLoading)

        registerModBiomes()
    }

    private fun registerModBiomes() {
        ModBiomes.REGISTRY.register(MOD_BUS)
        val key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, ResourceLocation("lotl:ley_biome"))
        BiomeDictionary.addTypes(key, BiomeDictionary.Type.FOREST)
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, BiomeManager.BiomeEntry(key, 1))
    }

    @SubscribeEvent
    fun onBiomeLoading(event: BiomeLoadingEvent) {
        if (event.category == Biome.Category.NETHER || event.category == Biome.Category.THEEND) return

        event.generation.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
            .add { CrystallizedLeyOreFeature.configuredFeature }
    }
}
