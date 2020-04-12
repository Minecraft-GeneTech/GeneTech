package com.minecraft.genetech.common;

import com.minecraft.genetech.items.itemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("InstantiationOfUtilityClass")
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new itemLoader();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}