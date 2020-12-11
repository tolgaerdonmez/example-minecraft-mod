package com.example.tutorialmod.events;

import com.example.tutorialmod.TutorialMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

//    @SubscribeEvent
//    public static void onServerChat(){}
}
