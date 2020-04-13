package com.minecraft.genetech.loaders;


import com.minecraft.genetech.blocks.BloodCentrifuge;
import com.minecraft.genetech.blocks.GeneTechBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class blockLoader {
    public static Map<String, GeneTechBlocks> blocks = new HashMap<>();
    public static final CreativeTabs BLOCKS_CREATIVE_TAB = new CreativeTabs("genetech_blocks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(blocks.get("genetech:blood_centrifuge"));
        }
    };

    public blockLoader() {
        GeneTechBlocks blockBloodCentrifuge=new BloodCentrifuge();
        blocks.put(blockBloodCentrifuge.getRegName(),blockBloodCentrifuge);
    }

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class BlockInitializer {
        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
            for (Map.Entry<String, GeneTechBlocks> entry : blocks.entrySet())
                event.getRegistry().register(entry.getValue().setRegistryName("genetech",entry.getKey()));
        }
    }
}
