package com.minecraft.genetech.items;

import javafx.scene.paint.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class Syringe extends Item {

    public Syringe(){
        super();
        this.setUnlocalizedName("itemSyringe");
        maxStackSize = 16;
    }
}
