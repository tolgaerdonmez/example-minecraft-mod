package com.example.tutorialmod.init;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.blocks.BlockItemBase;
import com.example.tutorialmod.items.ItemBase;
import com.example.tutorialmod.util.enums.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);


    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new SwordItem(
                    ModItemTier.RUBY,
                    2,
                    -2.4F,
                    new Item.Properties().group(TutorialMod.TAB
                    )
            )
    );
    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(ModBlocks.RUBY_BLOCK.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(ModBlocks.RUBY_ORE.get()));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven", () -> new BlockItemBase(ModBlocks.OVEN.get()));
    public static final RegistryObject<Item> TELEPORT_POD_ITEM = ITEMS.register("teleport_pod", () -> new BlockItemBase(ModBlocks.TELEPORT_POD.get()));

}
