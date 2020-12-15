package example.examplemod.item

import example.examplemod.ExampleMod
import example.examplemod.block.ModBlocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModItems {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.ITEMS, ExampleMod.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    val EXAMPLE_BLOCK by REGISTRY.register("example_block") {
        BlockItem(ModBlocks.EXAMPLE_BLOCK, Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    }
}