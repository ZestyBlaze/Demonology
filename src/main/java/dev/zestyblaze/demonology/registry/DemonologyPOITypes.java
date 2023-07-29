package dev.zestyblaze.demonology.registry;

import dev.zestyblaze.demonology.utils.Utils;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Blocks;

public class DemonologyPOITypes {
    public static PoiType DEMONOGRAPHER;

    public static void register() {
        DEMONOGRAPHER = PointOfInterestHelper.register(Utils.id("demonologist"), 1, 1, Blocks.SOUL_CAMPFIRE);
    }
}
