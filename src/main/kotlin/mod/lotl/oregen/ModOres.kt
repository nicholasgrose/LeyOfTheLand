package mod.lotl.oregen

import mod.lotl.LeyOfTheLand
import mod.lotl.block.ModBlocks
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.WorldGenRegistries
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.placement.*
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object ModOres {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.FEATURES, LeyOfTheLand.ID)

    val CRYSTALLIZED_LEY_ORE: ConfiguredFeature<*, *> by lazy {
        Feature.ORE
            .withConfiguration(
                OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ModBlocks.CRYSTALLIZED_LEY_ORE.defaultState,
                    4
                )
            )
            .withPlacement(
                ConfiguredPlacement(Placement.DEPTH_AVERAGE, DepthAverageConfig(8, 5))
            )
    }
}

object ModOreLoader {
    @SubscribeEvent
    fun onBiomeLoading(event: BiomeLoadingEvent) {
        if (event.category == Biome.Category.NETHER || event.category == Biome.Category.THEEND) return

        event.generation.getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
            .add { ModOres.CRYSTALLIZED_LEY_ORE }
    }
}
