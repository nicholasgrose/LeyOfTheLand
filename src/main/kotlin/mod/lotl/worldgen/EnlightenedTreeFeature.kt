package mod.lotl.worldgen

import mod.lotl.block.ModBlocks
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer

class EnlightenedTreeFeature {
    companion object {
        val configuredFeature by lazy {
            ConfiguredFeature(
                Feature.TREE,
                BaseTreeFeatureConfig.Builder(
                    SimpleBlockStateProvider(ModBlocks.ENLIGHTENED_LOG.defaultState),
                    SimpleBlockStateProvider(ModBlocks.ENLIGHTENED_LEAVES.defaultState),
                    // For FoliagePlacer, the first argument is radius, second is radius_random, third is offset,
                    // fourth is offset_random. And if you are using BlobFoliagePlacer, the fifth argument is height
                    FancyFoliagePlacer(FeatureSpread.func_242252_a(3), FeatureSpread.func_242252_a(3), 3),
                    // For TrunkPlacer, the first argument is the base height,
                    // second is height_rand_a, and third is height_rand_b
                    FancyTrunkPlacer(4, 4, 5),
                    // Affects where the trees spawn.
                    // The second parameter seems to have a significant effect on distance between trees
                    TwoLayerFeature(10, 50, 10)
                ).build()
            )
        }
    }
}
