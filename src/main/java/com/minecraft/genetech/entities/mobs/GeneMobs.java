package com.minecraft.genetech.entities.mobs;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;


@SuppressWarnings("EntityConstructor")
public class GeneMobs extends EntityMob {
    public String EntityName;
    public String UnlocalName;
    public int Range;
    public int UpdateTicks;
    public boolean isAutoUpdate;
    public int eggPrimaryColor;
    public int eggSecondColor;

    public GeneMobs(World worldIn,String EntityName,String UnlocalName,
                    int Range,int UpdateTicks,boolean isAutoUpdate,
                    int eggPrimaryColor,int eggSecondColor) {
        super(worldIn);
        this.EntityName=EntityName;
        this.UnlocalName=UnlocalName;
        this.Range=Range;
        this.UpdateTicks=UpdateTicks;
        this.isAutoUpdate=isAutoUpdate;
        this.eggPrimaryColor=eggPrimaryColor;
        this.eggSecondColor=eggSecondColor;
    }
}
