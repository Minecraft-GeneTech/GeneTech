package com.minecraft.genetech;
import com.minecraft.genetech.common.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = com.minecraft.genetech.GeneMain.MODID, name = com.minecraft.genetech.GeneMain.NAME,
        version = com.minecraft.genetech.GeneMain.VERSION)
public class GeneMain {
    public static final String MODID = "genetech";
    public static final String NAME = "Gene Tech";
    public static final String VERSION = "1.0.0";
    private static final String MODEL_DIR  = "textures/model/";

    private static Logger logger;

    @Mod.Instance(GeneMain.MODID)
    public static GeneMain instance;

    @SidedProxy(clientSide = "com.minecraft.genetech.client.ClientProxy",
            serverSide = "com.minecraft.genetech.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        proxy.init(event);
    }
    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name);
    }
    public static ResourceLocation getModelTexture(String name) {
        return new ResourceLocation(MODID, MODEL_DIR + name);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
