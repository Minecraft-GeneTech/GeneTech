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
        maxStackSize =stack;
        setUnlocalizedName(Unlocal);
        GeneTechItems.Unlocal =Unlocal;
        setContainerItem(this);
        item=this;
        GeneTechItems.regName =regName;
        this.setCreativeTab(itemLoader.ITEM_CREATIVE_TAB);
    }

    String getRegName(){
        return regName;
    }

    @Mod.EventBusSubscriber(modid = "genetech")
    public static final class ItemInitializer {
        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(item.setRegistryName(regName));

        }
    }


    @Mod.EventBusSubscriber(value = Side.CLIENT, modid = "genetech")
    public static final class ModelMapper {
        @SubscribeEvent
        public static void onModelReg(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }
}
