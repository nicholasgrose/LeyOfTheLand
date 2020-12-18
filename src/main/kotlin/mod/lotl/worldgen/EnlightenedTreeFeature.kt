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
                    FancyFoliagePlacer(FeatureSpread.func_242252_a(3), FeatureSpread.func_242252_a(3), 3),
                    FancyTrunkPlacer(4, 4, 5),
                    // Affects how far apart the trees spawn. The second parameter seems to have a significant effect on things.
                    TwoLayerFeature(10, 50, 10)
                ).build()
            )
        }
    }
}
