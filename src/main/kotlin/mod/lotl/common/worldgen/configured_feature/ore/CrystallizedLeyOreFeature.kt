package mod.lotl.common.worldgen.configured_feature.ore

import mod.lotl.common.block.ModBlocks
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.placement.ConfiguredPlacement
import net.minecraft.world.gen.placement.DepthAverageConfig
import net.minecraft.world.gen.placement.Placement

object CrystallizedLeyOreFeature {
    val configuredFeature: ConfiguredFeature<*, *> by lazy {
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
