package com.minecraft.genetech.entitymob;

import com.minecraft.genetech.GeneMain;

import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GeneZombie extends GeneMob{
	private static final  DataParameter<Integer> SKIN = EntityDataManager.createKey(GeneZombie.class, DataSerializers.VARINT);
	public static final  ResourceLocation LOOT_TABLE = GeneMain.prefix("");
	
	public GeneZombie(World worldIn) {
		super(worldIn);
		this.setSize(0.7F,1.8F);
	}
	public GeneZombie(World worldIn, double x, double y, double z) {
		super(worldIn);
		this.setPosition(x, y, z);
	}
	@Override
	public ResourceLocation getLootTable() {
		return LOOT_TABLE;
	}
	public int getTextureType() {
		return dataManager.get(SKIN);
	}
	
	
}
