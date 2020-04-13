package com.minecraft.genetech.loaders;

import com.minecraft.genetech.blocks.GeneTechBlocks;
import com.minecraft.genetech.items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class itemLoader {

    public static Map<String, GeneTechItems> items = new HashMap<>();

    public itemLoader() {
        GeneTechItems itemSyringe=new Syringe();
        items.put(itemSyringe.getRegName(),itemSyringe);

        GeneTechItems itemPlastic=new Plastic();
        items.put(itemPlastic.getRegName(),itemPlastic);

        GeneTechItems itemNeedle = new Needle();
        items.put(itemNeedle.getRegName(),itemNeedle);

        GeneTechItems itemBloodSampleFull=new BloodSampleFull();
        items.put(itemBloodSampleFull.getRegName(),itemBloodSampleFull);

        GeneTechItems itemBloodSampleEmpty=new BloodSampleEmpty();
        items.put(itemBloodSampleEmpty.getRegName(),itemBloodSampleEmpty);

    }

    public static final CreativeTabs ITEM_CREATIVE_TAB = new CreativeTabs("genetech_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(items.get("genetech:syringe"));
        }
    };

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class ItemInitializer {
        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {

            for (Map.Entry<String, GeneTechItems> entry : items.entrySet())
                event.getRegistry().register(entry.getValue().setRegistryName(entry.getKey()));
            for (Map.Entry<String, GeneTechBlocks> entry : blockLoader.blocks.entrySet())
                event.getRegistry().register(
                        new ItemBlock(entry.getValue()).setRegistryName("genetech:"+entry.getKey())
                );
        }
    }

    @Mod.EventBusSubscriber(value = Side.CLIENT, modid = "genetech")
    public static final class ModelMapper {
        @SubscribeEvent
        public static void onModelReg(ModelRegistryEvent event) {
            for(GeneTechItems item:items.values())
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }
}
