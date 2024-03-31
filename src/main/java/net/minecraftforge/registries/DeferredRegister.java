package net.minecraftforge.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

// SNWCreations: Minimal version of the original Forge interface.
public interface DeferredRegister<T> {
    <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> sup);

    Collection<RegistryObject<T>> getEntries();

    static <B> DeferredRegister<B> create(ResourceKey<? extends Registry<B>> key, String modid) {
        Registry<B> registry;
        if (key.equals(ForgeRegistries.ENTITY_TYPES)) {
            registry = (Registry<B>) BuiltInRegistries.ENTITY_TYPE;
        } else if (key.equals(ForgeRegistries.ITEMS)) {
            registry = (Registry<B>) BuiltInRegistries.ITEM;
        } else if (key.equals(Registries.CREATIVE_MODE_TAB)) {
            registry = (Registry<B>) BuiltInRegistries.CREATIVE_MODE_TAB;
        } else {
            throw new IllegalArgumentException("Not supported by this port implementation");
        }
        ArrayList<RegistryObject<B>> list = new ArrayList<>();
        return new DeferredRegister<>() {
            @Override
            public <I extends B> RegistryObject<I> register(String name, Supplier<? extends I> sup) {
                ResourceLocation k = new ResourceLocation(modid, name);
                B b = Registry.register(registry, k, sup.get());
                RegistryObject<B> obj = () -> b;
                list.add(obj);
                return (RegistryObject<I>) obj;
            }

            @Override
            public Collection<RegistryObject<B>> getEntries() {
                return list;
            }
        };
    }
}
