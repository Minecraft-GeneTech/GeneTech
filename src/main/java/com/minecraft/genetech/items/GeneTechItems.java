package com.minecraft.genetech.items;

import net.minecraft.item.Item;
public class GeneTechItems extends Item {
    public static String Unlocal;
    public static Item item;
    public static String regName;

    public GeneTechItems(String Unlocal,int stack,String regName) {
        super();
        item=this;
        maxStackSize =stack;
        setContainerItem(this);
        setUnlocalizedName(Unlocal);
        GeneTechItems.Unlocal =Unlocal;
        GeneTechItems.regName =regName;
        this.setCreativeTab(itemLoader.ITEM_CREATIVE_TAB);
    }

    String getRegName(){
        return regName;
    }
}
