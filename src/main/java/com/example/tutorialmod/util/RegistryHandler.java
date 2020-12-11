package com.example.tutorialmod.util;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.blocks.BlockItemBase;
import com.example.tutorialmod.blocks.Oven;
import com.example.tutorialmod.blocks.RubyBlock;
import com.example.tutorialmod.blocks.RubyOre;
import com.example.tutorialmod.blocks.teleportpod.TeleportPod;
import com.example.tutorialmod.items.ItemBase;
import com.example.tutorialmod.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static void init() {
        // this registers the item, needed but idk the underlying means :)
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    // Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(
                    ModItemTier.RUBY,
                    2,
                    -2.4F,
                    new Item.Properties().group(TutorialMod.TAB
                    )
            )
    );

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", Oven::new);
    public static final RegistryObject<Block> TELEPORT_POD = BLOCKS.register("teleport_pod", TeleportPod::new);

    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(RUBY_ORE.get()));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven", () -> new BlockItemBase(OVEN.get()));
    public static final RegistryObject<Item> TELEPORT_POD_ITEM = ITEMS.register("teleport_pod", () -> new BlockItemBase(TELEPORT_POD.get()));


}
