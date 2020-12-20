package mod.lotl.common.oregen

import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import thedarkcolour.kotlinforforge.eventbus.KotlinEventBusWrapper

object OreGeneration {
    fun registerOreGeneration(forgeBus: KotlinEventBusWrapper) {
        forgeBus.addListener(::onBiomeLoading)
    }

    @SubscribeEvent
    fun onBiomeLoading(event: BiomeLoadingEvent) {
        if (event.category == Biome.Category.NETHER || event.category == Biome.Category.THEEND) return

        event.generation.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
            .add { ModOres.CRYSTALLIZED_LEY_ORE }
    }
}
