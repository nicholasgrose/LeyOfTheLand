package mod.lotl.common.worldgen.biome

import mod.lotl.LeyOfTheLand
import mod.lotl.common.oregen.ModOres
import mod.lotl.common.worldgen.EnlightenedTreeFeature
import net.minecraft.block.Blocks
import net.minecraft.client.audio.BackgroundMusicTracks
import net.minecraft.particles.ParticleTypes
import net.minecraft.util.SoundEvents
import net.minecraft.world.biome.*
import net.minecraft.world.gen.GenerationStage
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBiomes {
    val REGISTRY = KDeferredRegister(ForgeRegistries.BIOMES, LeyOfTheLand.ID)

    val LEY_BIOME by REGISTRY.registerObject("ley_biome") {
        val generationSettingsBuilder = BiomeGenerationSettingsBuilder(BiomeGenerationSettings.DEFAULT_SETTINGS)
            .withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModOres.CRYSTALLIZED_LEY_ORE)
            .withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, EnlightenedTreeFeature.configuredFeature)
            .withSurfaceBuilder {
                ConfiguredSurfaceBuilder(
                    SurfaceBuilder.DEFAULT,
                    SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultState, Blocks.STONE.defaultState, Blocks.DIRT.defaultState)
                )
            }
        val biome = Biome.Builder()
            .downfall(0.5f)
            .temperature(0.5f)
            .precipitation(Biome.RainType.RAIN)
            .category(Biome.Category.FOREST)
            .scale(0.35f)
            .depth(0.3f)
            .withGenerationSettings(generationSettingsBuilder.build())
            .withMobSpawnSettings(MobSpawnInfo.EMPTY)
            .withTemperatureModifier(Biome.TemperatureModifier.NONE)
            .setEffects(
                BiomeAmbience.Builder()
                    .setFogColor(0xFFFFFF)
                    .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                    .setMusic(BackgroundMusicTracks.WORLD_MUSIC)
                    .setWaterColor(0x990099)
                    .setWaterFogColor(0x990099)
                    .withFoliageColor(0x990099)
                    .withGrassColor(0x990099)
                    .withSkyColor(0x990099)
                    .build()
            )
            .build()
        biome
    }
}
