package com.minecraft.genetech.loaders;

import com.minecraft.genetech.entities.mobs.GeneMobs;
import com.minecraft.genetech.entities.mobs.mobGeneZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.List;

public class mobsLoader {
    static List<GeneMobs> MobList = new ArrayList<>();

    public mobsLoader() {
        MobList.add(new mobGeneZombie(null));
    }

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class  IForgeRegistryEntry{
        @SubscribeEvent
        public static void onEntityRegistation(RegistryEvent.Register<EntityEntry> event) {
            for (GeneMobs geneMobs : MobList) {
                ResourceLocation resourceLocation = new ResourceLocation("genetech", geneMobs.EntityName);
                event.getRegistry().register(EntityEntryBuilder.create()
                        .entity(geneMobs.getClass())
                        .id(resourceLocation, 233)
                        .name(geneMobs.UnlocalName)
                        .tracker(geneMobs.Range, geneMobs.UpdateTicks, geneMobs.isAutoUpdate)
                        .build()
                );
                EntityRegistry.registerEgg(resourceLocation,
                        geneMobs.eggPrimaryColor,geneMobs.eggSecondColor);
                }
        }
    }


}
