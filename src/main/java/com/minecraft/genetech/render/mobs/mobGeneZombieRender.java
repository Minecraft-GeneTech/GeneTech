package com.minecraft.genetech.render.mobs;

import com.minecraft.genetech.entities.mobs.mobGeneZombie;
import com.minecraft.genetech.render.mobs.modelbases.GeneZombieModel;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class mobGeneZombieRender extends RenderLiving<mobGeneZombie> {

    private static final ResourceLocation MOB_GENE_ZOMBIE_TEXTURE = new ResourceLocation(
            "genetech" + ":" + "textures/entity/mobs/gene_zombie.png");

    public mobGeneZombieRender(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new GeneZombieModel(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(mobGeneZombie entity) {
        return MOB_GENE_ZOMBIE_TEXTURE;
    }
}
