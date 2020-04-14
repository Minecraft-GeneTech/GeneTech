package com.minecraft.genetech.items;

import com.minecraft.genetech.loaders.itemLoader;
import net.minecraft.item.Item;
public class GeneTechItems extends Item {
    public static Item item;
    public static String regName;

    public GeneTechItems(String Unlocal,int stack,String regName) {
        super();
        item=this;
        maxStackSize =stack;
        setUnlocalizedName(Unlocal);
        GeneTechItems.regName ="genetech:"+regName;
        this.setCreativeTab(itemLoader.ITEM_CREATIVE_TAB);
    }

    public String getRegName(){
        return regName;
    }
}
