package com.minecraft.genetech.loaders;

import com.minecraft.genetech.entities.mobs.mobGeneZombie;
import com.minecraft.genetech.render.mobs.mobGeneZombieRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class renderLoader {

    public renderLoader() {
        registerEntityRender(mobGeneZombie.class, mobGeneZombieRender.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
    }


    public static class EntityRenderFactory<E extends Entity> implements IRenderFactory<E> {
        private final Class<? extends Render<E>> renderClass;

        public EntityRenderFactory(Class<? extends Render<E>> renderClass) {
            this.renderClass = renderClass;
        }

        @Override
        public Render<E> createRenderFor(RenderManager manager) {
            try {
                return renderClass.getConstructor(RenderManager.class).newInstance(manager);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
