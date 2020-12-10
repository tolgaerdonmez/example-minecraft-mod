package com.example.tutorialmod.word.gen;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

//    @SubscribeEvent
//    public static void generateOres(FMLLoadCompleteEvent event) {
//        for (Biome biome : ForgeRegistries.BIOMES) {
//            final Biome.Category currentBiome = biome.getCategory();
//
//            switch (currentBiome) {
//                // nether generation
//                case NETHER:
//                    break;
//                // end generation
//                case THEEND:
//                    break;
//                // world generation
//                default:
//                    break;
//            }
//        }
//    }


    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        TopSolidRangeConfig range = new TopSolidRangeConfig(count, bottomOffset, topOffset);
        OreFeatureConfig feature = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.field_242907_l(range);
    }

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOre() {
        overworldOres.add(register("ruby_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.RUBY_ORE.get().getDefaultState(), 4))
                .func_242731_b(16)
        ));
    }

    @SubscribeEvent()
    public static void gen(FMLLoadCompleteEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        for (ConfiguredFeature<?, ?> ore : overworldOres) {
            if (ore != null) generation.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.field_243653_e, TutorialMod.MOD_ID + ":" + name, configuredFeature);
    }
}
