package dev.zestyblaze.demonology.registry;

import com.google.common.collect.ImmutableSet;
import dev.zestyblaze.demonology.utils.Utils;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import eu.pb4.polymer.core.api.entity.PolymerVillagerProfession;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;

public class DemonologyProfessions {
    public static final VillagerProfession DEMONOGRAPHER = new VillagerProfession(
            "demonographer",
            poiTypeHolder -> poiTypeHolder.value().equals(DemonologyPOITypes.DEMONOGRAPHER),
            poiTypeHolder -> poiTypeHolder.value().equals(DemonologyPOITypes.DEMONOGRAPHER),
            ImmutableSet.of(),
            ImmutableSet.of(),
            SoundEvents.VILLAGER_WORK_BUTCHER
    );

    public static void register() {
        Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, Utils.id("demonographer"), DEMONOGRAPHER);

        PolymerEntityUtils.registerProfession(DEMONOGRAPHER, new PolymerVillagerProfession() {
            @Override
            public VillagerProfession getPolymerProfession(VillagerProfession profession, ServerPlayer player) {
                return VillagerProfession.CLERIC;
            }
        });
    }

    public static void fillTrades() {
        TradeOfferHelper.registerVillagerOffers(DEMONOGRAPHER, 1, itemListings -> {
            itemListings.add(new VillagerTrades.EmeraldForItems(Items.SPIDER_EYE, 15, 5, 2));
            itemListings.add(new VillagerTrades.ItemsForEmeralds(DemonologyItems.DEMON_HEART, 20, 1, 4));
        });
    }
}
