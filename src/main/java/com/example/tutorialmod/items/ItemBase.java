package com.example.tutorialmod.items;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        // assigns the Item to Materials group
        super(new Item.Properties().group(TutorialMod.TAB));
    }
}
