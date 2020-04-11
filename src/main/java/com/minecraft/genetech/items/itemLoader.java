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

    static Map<String,GeneTechItems> items = new HashMap<>();

    public itemLoader(FMLPreInitializationEvent event) {
        GeneTechItems itemSyringe=new Syringe();
        items.put(itemSyringe.getRegName(),itemSyringe);
    }


    public static final CreativeTabs ITEM_CREATIVE_TAB = new CreativeTabs("genetech_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(items.get("genetech:syringe"));
        }
    };



}