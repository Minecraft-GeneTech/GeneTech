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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class itemLoader {

    static Map<Item,String> items = new HashMap<Item,String>();

    public static final CreativeTabs ITEM_CREATIVE_TAB = new CreativeTabs("genetech_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    public itemLoader(FMLPreInitializationEvent event) {
        items.put(new Syringe().setCreativeTab(ITEM_CREATIVE_TAB),"genetech:syringe");
    }

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class ItemInitializer {
        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {
            for(Map.Entry<Item, String> entry : items.entrySet()){
                event.getRegistry().register(entry.getKey().setRegistryName(entry.getValue()));
            }
        }
    }

    @Mod.EventBusSubscriber(value = Side.CLIENT, modid = "genetech")
    public static final class ModelMapper {
        @SubscribeEvent
        public static void onModelReg(ModelRegistryEvent event) {
            for(Item item:items.keySet()){
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

            }

        }
    }
}