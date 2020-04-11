package com.minecraft.genetech.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

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
