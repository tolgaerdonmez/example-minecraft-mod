package com.example.tutorialmod.events;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == Items.STICK) {
            TutorialMod.LOGGER.info("Player tried to jump with a stick");
            World world = player.getEntityWorld();
            world.setBlockState(player.func_233580_cy_().add(0, -1, 0), RegistryHandler.RUBY_BLOCK.get().getDefaultState());
        }
    }

    @SubscribeEvent
    public static void onDamageSheep(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == Items.POISONOUS_POTATO.getItem()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {

                    target.addPotionEffect(new EffectInstance(Effects.POISON, 10 * 20));
                    target.setJumping(true);

                    PlayerEntity player = event.getPlayer();
                    if (!player.getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "That sheep isn't feeling so wel...";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

//    @SubscribeEvent
//    public static void onCraftingTableOpen(GuiOpenEvent event) {
//        if (!event.isCancelable()) return;
//        if (event.getGui() instanceof CraftingScreen) {
//            event.setCanceled(true);
//            TutorialMod.LOGGER.info("Player tried to open a crafting table!");
//        }
//    }
}