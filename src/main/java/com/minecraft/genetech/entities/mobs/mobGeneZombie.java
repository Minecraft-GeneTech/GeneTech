package com.minecraft.genetech.entities.mobs;


import com.minecraft.genetech.entities.ai.aiMobGeneZombie;
import net.minecraft.world.World;

public class mobGeneZombie extends GeneMobs {
    public mobGeneZombie(World worldIn) {
        super(worldIn,
                "mob_gene_zombie",
                "mobGeneZombie",
                80,3,false,
                1,2);
        this.tasks.addTask(8,new aiMobGeneZombie(this));
    }
}
