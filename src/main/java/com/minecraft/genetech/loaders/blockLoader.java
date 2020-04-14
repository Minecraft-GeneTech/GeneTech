package com.minecraft.genetech.loaders;


import com.minecraft.genetech.blocks.BloodCentrifuge;
import com.minecraft.genetech.blocks.GeneTechBlocks;
import com.minecraft.genetech.items.GeneTechItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class blockLoader {
    public static Map<String, GeneTechBlocks> blocks = new HashMap<>();

    public blockLoader() {
        GeneTechBlocks blockBloodCentrifuge=new BloodCentrifuge();
        blocks.put(blockBloodCentrifuge.getRegName(),blockBloodCentrifuge);
    }

    public static final CreativeTabs BLOCKS_CREATIVE_TAB = new CreativeTabs("genetech_blocks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(blocks.get("genetech:blood_centrifuge")));
        }
    };

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class BlockInitializer {
        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
            for (Map.Entry<String, GeneTechBlocks> entry : blocks.entrySet())
                event.getRegistry().register(entry.getValue().setRegistryName(entry.getKey()));
        }

        @Mod.EventBusSubscriber(value = Side.CLIENT, modid = "genetech")
        public static final class ModelMapper {
            @SubscribeEvent
            public static void onModelReg(ModelRegistryEvent event) {
                for (Map.Entry<String, GeneTechBlocks> entry : blocks.entrySet())
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(entry.getValue()), 0, new ModelResourceLocation(Objects.requireNonNull(entry.getValue().getRegistryName()), "inventory"));
            }
        }

        @Mod.EventBusSubscriber(modid = "genetech")
        public static final class ItemInitializer {
            @SubscribeEvent
            public static void registerItem(RegistryEvent.Register<Item> event) {
                for (Map.Entry<String, GeneTechBlocks> entry : blockLoader.blocks.entrySet()){
                    ItemBlock itemBlock= (ItemBlock) new ItemBlock(entry.getValue()).setRegistryName(entry.getKey());
                    event.getRegistry().register(itemBlock);
                }
            }
        }
    }
}
