package mod.lotl.common.item

import mod.lotl.LeyOfTheLand
import mod.lotl.common.block.ModBlocks
import net.minecraft.item.*
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModItems {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.ITEMS, LeyOfTheLand.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    @Suppress("unused")
    val ENLIGHTENED_LOG by REGISTRY.registerObject("enlightened_log") {
        BlockItem(ModBlocks.ENLIGHTENED_LOG, Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    }

    @Suppress("unused")
    val  ENLIGHTENED_LEAVES by REGISTRY.registerObject("enlightened_leaves") {
        BlockItem(ModBlocks.ENLIGHTENED_LEAVES, Item.Properties().group(ItemGroup.DECORATIONS))
    }

    @Suppress("unused")
    val CRYSTALLIZED_LEY_ORE by REGISTRY.registerObject("crystallized_ley_ore") {
        BlockItem(ModBlocks.CRYSTALLIZED_LEY_ORE, Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    }

    @Suppress("unused")
    val CRYSTAL_LEY by REGISTRY.registerObject("crystal_ley") {
        Item(Item.Properties().group(ItemGroup.MATERIALS))
    }
    @Suppress("unused")
    val ENLIGHTENED_PLANKS by REGISTRY.registerObject("enlightened_planks") {
        BlockItem(ModBlocks.ENLIGHTENED_PLANKS, Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    }

    val LEY_FINDER by REGISTRY.registerObject("ley_finder") {
        LeyFinder()
    }
}
