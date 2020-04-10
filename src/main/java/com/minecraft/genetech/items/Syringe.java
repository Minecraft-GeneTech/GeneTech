package com.minecraft.genetech.items;

import ibxm.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class Syringe extends Item {

    public Syringe() {
        super();
        this.setUnlocalizedName("itemSyringe");
        setContainerItem(this);
        maxStackSize = 16;
    }



    @SuppressWarnings("NullableProblems")
    @SideOnly(Side.CLIENT)
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        if (playerIn.getHeldItemMainhand().getItem() instanceof Syringe) {
            if(!playerIn.addItemStackToInventory(new ItemStack(new Syringe().setUnlocalizedName(target.getName())))){
                stack.shrink(1);
                playerIn.addItemStackToInventory(new ItemStack(new Syringe().setUnlocalizedName(target.getName())));
            }else
                stack.shrink(1);
            return true;
        }
        return false;
    }
}