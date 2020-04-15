package com.minecraft.genetech.loaders;

import com.minecraft.genetech.GeneMain;

import net.minecraft.util.ResourceLocation;

public class EntityNames {
	public static final ResourceLocation GENE_ZOMB = prefix("gene_zombie");
	
	private static ResourceLocation prefix(String path) {
		return new ResourceLocation(GeneMain.MODID, path);
	}
}
