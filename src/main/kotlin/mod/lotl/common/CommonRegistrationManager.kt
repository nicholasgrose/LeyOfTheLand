package mod.lotl.common

import mod.lotl.common.block.ModBlocks
import mod.lotl.common.item.ModItems
import mod.lotl.common.worldgen.configured_feature.ore.CrystallizedLeyOreFeature
import mod.lotl.common.worldgen.WorldGenRegistrationManager
import mod.lotl.common.worldgen.biome.ModBiomes
import net.minecraft.util.RegistryKey
import net.minecraft.util.ResourceLocation
import net.minecraft.util.registry.Registry
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeManager
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

object CommonRegistrationManager {
    fun registerCommonObjects() {
        WorldGenRegistrationManager.registerWorldGeneration(FORGE_BUS)
        ModBlocks.REGISTRY.register(MOD_BUS)
        ModItems.REGISTRY.register(MOD_BUS)
    }
}
