package com.example.tutorialmod.init;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.blocks.Oven;
import com.example.tutorialmod.blocks.RubyBlock;
import com.example.tutorialmod.blocks.RubyOre;
import com.example.tutorialmod.blocks.teleportpod.TeleportPod;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);


    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);
    public static final RegistryObject<Block> TELEPORT_POD = BLOCKS.register("teleport_pod", TeleportPod::new);

}
