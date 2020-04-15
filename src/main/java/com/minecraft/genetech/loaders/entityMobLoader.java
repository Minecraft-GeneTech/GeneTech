package com.minecraft.genetech.loaders;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.minecraft.genetech.GeneMain;
import com.minecraft.genetech.entitymob.GeneMob;
import com.minecraft.genetech.entitymob.GeneZombie;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = GeneMain.MODID)
public class  entityMobLoader {
	
	private static class EntityRegistryHelper {

		private final IForgeRegistry<EntityEntry> registry;

		private int id = 0;

		EntityRegistryHelper(IForgeRegistry<EntityEntry> registry) {
			this.registry = registry;
		}

		private static String toString(ResourceLocation registryName) {
			return registryName.getResourceDomain() + "." + registryName.getResourcePath();
		}

		final <T extends Entity> EntityEntryBuilder<T> builder(ResourceLocation registryName, Class<T> entity, Function<World, T> factory) {
			return EntityEntryBuilder.<T>create().id(registryName, id++).name(toString(registryName)).entity(entity).factory(factory);
		}

		final <T extends Entity> void registerEntity(ResourceLocation registryName, Class<T> entity, Function<World, T> factory, int backgroundEggColour, int foregroundEggColour) {
			registerEntity(registryName, entity, factory, backgroundEggColour, foregroundEggColour, 80, 3, true);
		}

		final <T extends Entity> void registerEntity(ResourceLocation registryName, Class<T> entity, Function<World, T> factory, int backgroundEggColour, int foregroundEggColour, int trackingRange, int updateInterval, boolean sendVelocityUpdates) {
			registry.register(builder(registryName, entity, factory).tracker(trackingRange, updateInterval, sendVelocityUpdates).egg(backgroundEggColour, foregroundEggColour).build());
		}

		final <T extends Entity> void registerEntity(ResourceLocation registryName, Class<T> entity, Function<World, T> factory) {
			registerEntity(registryName, entity, factory, 80, 3, true);
		}

		final <T extends Entity> void registerEntity(ResourceLocation registryName, Class<T> entity, Function<World, T> factory, int trackingRange, int updateInterval, boolean sendVelocityUpdates) {
			registry.register(builder(registryName, entity, factory).tracker(trackingRange, updateInterval, sendVelocityUpdates).build());
		}

		
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {

		EntityRegistryHelper helper = new EntityRegistryHelper(event.getRegistry());
		
		helper.registerEntity(EntityNames.GENE_ZOMB, GeneZombie.class, GeneZombie::new, 0x83653b, 0xffefca);
	}
}
