package dev.zestyblaze.demonology.utils;

import dev.zestyblaze.demonology.Demonology;
import net.minecraft.resources.ResourceLocation;

public class Utils {
    public static ResourceLocation id(String string) {
        return new ResourceLocation(Demonology.MODID, string);
    }
}
