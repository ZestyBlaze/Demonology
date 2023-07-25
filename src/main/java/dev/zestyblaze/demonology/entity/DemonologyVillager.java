package dev.zestyblaze.demonology.entity;

import dev.zestyblaze.demonology.mixin.VillagerMixin;
import eu.pb4.polymer.core.api.entity.PolymerEntity;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;

import java.util.List;

public class DemonologyVillager extends Villager implements PolymerEntity {
    public DemonologyVillager(EntityType<? extends Villager> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public EntityType<?> getPolymerEntityType(ServerPlayer player) {
        return EntityType.VILLAGER;
    }

    @Override
    public void modifyRawTrackedData(List<SynchedEntityData.DataValue<?>> data, ServerPlayer player, boolean initial) {
        data.add(SynchedEntityData.DataValue.create(VillagerMixin.getVillagerData(), new VillagerData(VillagerType.PLAINS, VillagerProfession.CLERIC, 1)));
    }
}
