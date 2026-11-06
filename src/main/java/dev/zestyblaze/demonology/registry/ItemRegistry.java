package dev.zestyblaze.demonology.registry;

import dev.zestyblaze.demonology.Demonology;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ItemRegistry {
    public static final Item DEMON_HEART = new SimplePolymerItem(new Item.Properties(), Items.RED_DYE);

    public static void register() {
        Registry.register(BuiltInRegistries.ITEM, Demonology.reloc("demon_heart"), DEMON_HEART);
    }
}
