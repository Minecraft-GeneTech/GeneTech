package com.minecraft.genetech.blocks;

import com.minecraft.genetech.loaders.blockLoader;
import com.minecraft.genetech.loaders.itemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GeneTechBlocks extends Block {
    public static Block block;
    public static String regName;

    public GeneTechBlocks(Material materialIn,int hard,String toolClass,int HarvestLevel,
    int light,int LightOpacity,int Resistance,String Unlocal,String regName) {
        super(materialIn);
        block=this;
        this.setHardness(hard);
        this.setHarvestLevel(toolClass,HarvestLevel);
        this.setLightLevel(light);
        this.setLightOpacity(LightOpacity);
        this.setResistance(Resistance);
        this.setUnlocalizedName(Unlocal);
        GeneTechBlocks.regName=regName;
        this.setCreativeTab(blockLoader.BLOCKS_CREATIVE_TAB);
    }

    public String getRegName(){
        return regName;
    }
}
