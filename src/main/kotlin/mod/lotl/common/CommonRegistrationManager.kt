package mod.lotl.common

import mod.lotl.common.block.ModBlocks
import mod.lotl.common.item.ModItems
import mod.lotl.common.worldgen.WorldGenRegistrationManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object CommonRegistrationManager {
    fun registerCommonObjects() {
        WorldGenRegistrationManager.registerWorldGeneration(FORGE_BUS)
        ModBlocks.REGISTRY.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
    }
}
