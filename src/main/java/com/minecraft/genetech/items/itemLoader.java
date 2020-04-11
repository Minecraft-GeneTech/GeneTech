package com.minecraft.genetech.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.util.HashMap;
import java.util.Map;

public class itemLoader {

    static Map<String,GeneTechItems> items = new HashMap<>();

    public itemLoader(FMLPreInitializationEvent event) {
        GeneTechItems itemSyringe=new Syringe();
        items.put(itemSyringe.getRegName(),itemSyringe);
        GeneTechItems itemSyringeFull=new SyringeFull();
        items.put(itemSyringeFull.getRegName(),itemSyringeFull);
    }

    public static final CreativeTabs ITEM_CREATIVE_TAB = new CreativeTabs("genetech_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(items.get("genetech:syringe"));
        }
    };
}