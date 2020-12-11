package com.example.tutorialmod.world.gen;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone", new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            final Biome.Category currentBiome = biome.getCategory();

            switch (currentBiome) {
                // nether generation
                case NETHER:
                    genOre(biome, 12, 5, 5, 80,
                            OreFeatureConfig.FillerBlockType.NETHERRACK,
                            ModBlocks.RUBY_ORE.get().getDefaultState(),
                            4);
                    break;
                // end generation
                case THEEND:
                    genOre(biome, 18, 3, 5, 88,
                            END_STONE,
                            ModBlocks.RUBY_ORE.get().getDefaultState(),
                            12);
                    break;
                // world generation
                default:
                    genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.get().getDefaultState(), 6);
                    break;
            }
        }
    }


    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }

}
