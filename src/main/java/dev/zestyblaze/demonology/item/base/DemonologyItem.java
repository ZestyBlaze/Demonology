package dev.zestyblaze.demonology.item.base;

import dev.zestyblaze.demonology.utils.Utils;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class DemonologyItem extends Item implements PolymerItem {
    private final Item virtualItem;
    private final int modelData;

    public DemonologyItem(Item item, Properties properties, String id) {
        super(properties);
        this.virtualItem = item;
        this.modelData = PolymerResourcePackUtils.requestModel(item, Utils.id("item/" + id)).value();
    }

    public DemonologyItem(Item item, String name) {
        this(item, new FabricItemSettings(), name);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return this.virtualItem;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayer player) {
        return this.modelData;
    }
}
