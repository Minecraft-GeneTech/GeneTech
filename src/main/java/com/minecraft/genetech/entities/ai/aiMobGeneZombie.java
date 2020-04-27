package com.minecraft.genetech.entities.ai;

import com.minecraft.genetech.entities.mobs.GeneMobs;
import com.minecraft.genetech.entities.mobs.mobGeneZombie;
import net.minecraft.entity.ai.EntityAIBase;

public class aiMobGeneZombie extends EntityAIBase {

    private final mobGeneZombie entity;

    public aiMobGeneZombie(mobGeneZombie entity){
        this.entity=entity;
    }

    @Override
    public boolean shouldExecute() {
        return false;
    }

    @Override
    public void updateTask()
    {

    }
}
