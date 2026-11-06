package dev.zestyblaze.demonology.item;

import dev.zestyblaze.demonology.Demonology;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class DemonTexturedItem extends Item implements PolymerItem {
    private final Item virtualItem;
    private final PolymerModelData modelData;

    public DemonTexturedItem(Properties settings, Item polymerItem, String id) {
        super(settings);
        this.virtualItem = polymerItem;
        this.modelData = PolymerResourcePackUtils.requestModel(polymerItem, Demonology.reloc("item/" + id));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer serverPlayer) {
        return virtualItem;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayer player) {
        return modelData.value();
    }
}
