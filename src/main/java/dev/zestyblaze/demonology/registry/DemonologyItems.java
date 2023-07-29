package dev.zestyblaze.demonology.registry;

import dev.zestyblaze.demonology.Demonology;
import dev.zestyblaze.demonology.item.base.DemonologyItem;
import dev.zestyblaze.demonology.utils.Utils;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.HashSet;
import java.util.Set;

public class DemonologyItems {
    public static final Set<Item> ITEMS = new HashSet<>();

    private static final CreativeModeTab DEMONOLOGY_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DemonologyItems.DEMON_HEART))
            .title(Component.translatable("itemGroup.demonology"))
            .displayItems((itemDisplayParameters, output) -> DemonologyItems.ITEMS.forEach(output::accept))
            .build();

    public static final Item DEMON_HEART = register("demon_heart", new DemonologyItem(Items.ROTTEN_FLESH, new FabricItemSettings().rarity(Rarity.UNCOMMON).food(new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.1f).meat()
            .effect(new MobEffectInstance(MobEffects.POISON, 200, 2), 0.8f)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 300, 3), 1.0f)
            .alwaysEat().build()), "demon_heart")
    );

    private static Item register(String name, Item item) {
        Item item1 = Registry.register(BuiltInRegistries.ITEM, Utils.id(name), item);
        ITEMS.add(item1);
        return item1;
    }

    public static void register() {
        PolymerItemGroupUtils.registerPolymerItemGroup(Utils.id("creative_tab"), DEMONOLOGY_TAB);
        PolymerResourcePackUtils.addModAssets(Demonology.MODID);
    }
}
