package com.minecraft.genetech.common;

import com.minecraft.genetech.loaders.mobsLoader;
import com.minecraft.genetech.loaders.blockLoader;
import com.minecraft.genetech.loaders.itemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("InstantiationOfUtilityClass")
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        new itemLoader();
        new blockLoader();
        new mobsLoader();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
    public void  registerRenders() {

    }
}