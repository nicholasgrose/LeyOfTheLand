package mod.lotl.common.worldgen

import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import thedarkcolour.kotlinforforge.eventbus.KotlinEventBusWrapper

object WorldGeneration {
    fun registerWorldGeneration(forgeBus: KotlinEventBusWrapper) {
        forgeBus.addListener(::onBiomeLoading)
    }

    @SubscribeEvent
    fun onBiomeLoading(event: BiomeLoadingEvent) {
        if (event.category == Biome.Category.NETHER || event.category == Biome.Category.THEEND) return

        event.generation.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
            .add { EnlightenedTreeFeature.configuredFeature }
    }
}
