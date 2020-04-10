package com.minecraft.genetech.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


public class itemLoader {

    public static final CreativeTabs EXAMPLE_CREATIVE_TAB = new CreativeTabs("genetech_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    public itemLoader(FMLPreInitializationEvent event) {

    }

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class ItemInitializer {
        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {

        }
    }

    @Mod.EventBusSubscriber(value = Side.CLIENT, modid = "genetech")
    public static final class ModelMapper {
        @SubscribeEvent
        public static void onModelReg(ModelRegistryEvent event) {

        }
    }
}