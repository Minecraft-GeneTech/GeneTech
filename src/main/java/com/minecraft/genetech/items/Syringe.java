package com.minecraft.genetech.items;

import com.minecraft.genetech.loaders.itemLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Syringe extends GeneTechItems {

    public Syringe() {
        super("itemSyringe", 16, "genetech:syringe");
    }

    @SuppressWarnings("NullableProblems")
    @SideOnly(Side.CLIENT)
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) {
        if (playerIn.getHeldItemMainhand().getItem() instanceof Syringe) {
            ItemStack itemStack = new ItemStack(itemLoader.items.get("genetech:blood_sample_full"));
            if (!playerIn.addItemStackToInventory(itemStack)) {
                stack.shrink(1);
                playerIn.addItemStackToInventory(itemStack);
            } else
                stack.shrink(1);
            return true;
        }
        return false;
    }
}