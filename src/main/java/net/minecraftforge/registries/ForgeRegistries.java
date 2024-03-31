package net.minecraftforge.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

// SNWCreations: just reference to the vanilla registry
public interface ForgeRegistries {
    ResourceKey<Registry<EntityType<?>>> ENTITY_TYPES = Registries.ENTITY_TYPE;
    ResourceKey<Registry<Item>> ITEMS = Registries.ITEM;
}
