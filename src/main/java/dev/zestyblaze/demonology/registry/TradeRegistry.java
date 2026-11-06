package dev.zestyblaze.demonology.registry;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public class TradeRegistry {
    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, itemListings -> {
            itemListings.add(new VillagerTrades.ItemsForEmeralds(ItemRegistry.DEMON_HEART, 16, 1, 1));
        });
    }
}
