package com.minecraft.genetech.client;

import com.minecraft.genetech.common.CommonProxy;
import com.minecraft.genetech.entitymob.GeneZombie;
import com.minecraft.genetech.renderentity.RendererZomb;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;


public class ClientProxy extends CommonProxy {
    private final Set<IClientRegister> clientRegisters = new HashSet<>();
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (IClientRegister register : clientRegisters) {
            register.registerClient();
        }
    }
    @Override
    public void registerRenders() {
        float tiny = 0.25F;
        float small = 0.4F;
        float med = 0.5F;
        float large = 0.7F;
        RenderingRegistry.registerEntityRenderingHandler(GeneZombie.class, renderManager -> new RendererZomb(renderManager, small));
    }
}