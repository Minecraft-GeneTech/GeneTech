package com.minecraft.genetech.renderentity;

import com.minecraft.genetech.GeneMain;
import com.minecraft.genetech.entitymob.GeneZombie;
import com.minecraft.genetech.entitymob.model.ModelGeneZomb;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RendererZomb extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GeneMain.MODID, "textures/entity/ant01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GeneMain.MODID, "textures/entity/alternate/ant02.png");

	public RendererZomb(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGeneZomb(), shadowSize);
	}

	private ModelGeneZomb getModel() {
		return (ModelGeneZomb) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((GeneZombie) entity);
	}

	private ResourceLocation getTexture(GeneZombie entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		default:
			return texture01;
		}
	}
}
