package mod.lotl.common.oregen

import mod.lotl.LeyOfTheLand
import mod.lotl.common.block.ModBlocks
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.placement.*
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

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
