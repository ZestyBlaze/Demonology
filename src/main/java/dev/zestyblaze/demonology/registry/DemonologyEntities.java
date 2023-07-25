package dev.zestyblaze.demonology.registry;

import dev.zestyblaze.demonology.entity.DemonologyVillager;
import dev.zestyblaze.demonology.utils.Utils;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class DemonologyEntities {
    public static final EntityType<DemonologyVillager> DEMONOLOGY_VILLAGER = FabricEntityTypeBuilder.create(MobCategory.MISC, DemonologyVillager::new).dimensions(EntityDimensions.scalable(0.6F, 1.95F)).build();

    public static void register() {
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Utils.id("demonology_villager"), DEMONOLOGY_VILLAGER);
        FabricDefaultAttributeRegistry.register(DEMONOLOGY_VILLAGER, DemonologyVillager.createAttributes());
    }
}
