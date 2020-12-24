package mod.lotl.common.worldgen.biome

import mod.lotl.LeyOfTheLand
import mod.lotl.common.worldgen.configured_feature.tree.EnlightenedTreeFeature
import net.minecraft.block.Blocks
import net.minecraft.client.audio.BackgroundMusicTracks
import net.minecraft.world.biome.*
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.carver.ConfiguredCarver
import net.minecraft.world.gen.carver.WorldCarver
import net.minecraft.world.gen.feature.Features
import net.minecraft.world.gen.feature.ProbabilityConfig
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBiomes {
    val REGISTRY = KDeferredRegister(ForgeRegistries.BIOMES, LeyOfTheLand.ID)

    val LEY_BIOME: Biome by REGISTRY.registerObject("ley_biome") {
        val generationSettingsBuilder = BiomeGenerationSettingsBuilder(BiomeGenerationSettings.DEFAULT_SETTINGS)
            .withSurfaceBuilder {
                ConfiguredSurfaceBuilder(
                    SurfaceBuilder.DEFAULT,
                    SurfaceBuilderConfig(
                        Blocks.GRASS_BLOCK.defaultState,
                        Blocks.STONE.defaultState,
                        Blocks.DIRT.defaultState
                    )
                )
            }
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, EnlightenedTreeFeature.configuredFeature)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_TALL_GRASS_2)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_SUGAR_CANE)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_PUMPKIN)
            .withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_WATER)
            .withCarver(GenerationStage.Carving.AIR, ConfiguredCarver(WorldCarver.CAVE, ProbabilityConfig(0.25f)))
            .withCarver(GenerationStage.Carving.AIR, ConfiguredCarver(WorldCarver.CANYON, ProbabilityConfig(0.02f)))
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_ANDESITE)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_COAL)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIORITE)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIRT)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GRANITE)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GRAVEL)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_IRON)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE)
        return@registerObject Biome.Builder()
            .downfall(0.5f)
            .temperature(0.5f)
            .precipitation(Biome.RainType.RAIN)
            .category(Biome.Category.FOREST)
            .scale(0.35f)
            .depth(0.2f)
            .withGenerationSettings(generationSettingsBuilder.build())
            .withMobSpawnSettings(MobSpawnInfo.EMPTY)
            .withTemperatureModifier(Biome.TemperatureModifier.NONE)
            .setEffects(
                BiomeAmbience.Builder()
                    .setFogColor(0xFFFFFF)
                    .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                    .setMusic(BackgroundMusicTracks.WORLD_MUSIC)
                    .setWaterColor(0xE5E4E2)
                    .setWaterFogColor(0xE5E4E2)
                    .withFoliageColor(0xB5A642)
                    .withGrassColor(0xB5A642)
                    .withSkyColor(0x28D0D7)
                    .build()
            )
            .build()
    }
}
