package mod.lotl.common.worldgen.biome

import mod.lotl.LeyOfTheLand
import mod.lotl.common.oregen.ModOres
import mod.lotl.common.worldgen.WorldGeneration
import net.minecraft.client.audio.BackgroundMusicSelector
import net.minecraft.client.audio.BackgroundMusicTracks
import net.minecraft.client.renderer.ActiveRenderInfo
import net.minecraft.client.renderer.FogRenderer
import net.minecraft.particles.ParticleTypes
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundEvent
import net.minecraft.util.SoundEvents
import net.minecraft.world.biome.*
import net.minecraft.world.gen.GenerationStage
import net.minecraftforge.client.event.EntityViewRenderEvent
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBiomes {
    val REGISTRY = KDeferredRegister(ForgeRegistries.BIOMES, LeyOfTheLand.ID)

    val LEY_BIOME by REGISTRY.registerObject("ley_biome") {
        val biome = Biome.Builder()
            .downfall(0.65f)
            .temperature(0.65f)
            .precipitation(Biome.RainType.RAIN)
            .category(Biome.Category.FOREST)
            .scale(0.35f)
            .depth(0.3f)
            .withGenerationSettings(BiomeGenerationSettings.DEFAULT_SETTINGS)
            .withMobSpawnSettings(MobSpawnInfo.EMPTY)
            .withTemperatureModifier(Biome.TemperatureModifier.NONE)
            .setEffects(BiomeAmbience.Builder()
                .setFogColor(0)
                .setAmbientSound(SoundEvents.AMBIENT_CAVE)
                .setAdditionsSound(SoundAdditionsAmbience(SoundEvents.AMBIENT_CAVE, 0.0))
                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                .setMusic(BackgroundMusicTracks.DRAGON_FIGHT_MUSIC)
                .setParticle(ParticleEffectAmbience(ParticleTypes.ANGRY_VILLAGER, 0.1f))
                .setWaterColor(0)
                .setWaterFogColor(0)
                .withFoliageColor(0)
                .withGrassColor(0)
                .withSkyColor(0)
                .build()
            )
            .build()
//        biome.generationSettings.features[GenerationStage.Decoration.UNDERGROUND_ORES.ordinal].add { ModOres.CRYSTALLIZED_LEY_ORE }
        biome
    }
}
