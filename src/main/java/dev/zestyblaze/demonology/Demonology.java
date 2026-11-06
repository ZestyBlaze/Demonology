package dev.zestyblaze.demonology;

import dev.zestyblaze.demonology.registry.ItemRegistry;
import dev.zestyblaze.demonology.registry.TradeRegistry;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demonology implements ModInitializer {
	public static final String MODID = "demonology";
	public static final Logger LOGGER = LogManager.getLogger();

	public static ResourceLocation reloc(String id) {
		return ResourceLocation.fromNamespaceAndPath(MODID, id);
	}

	@Override
	public void onInitialize() {
		ItemRegistry.register();
		TradeRegistry.register();
		PolymerResourcePackUtils.addModAssets(MODID);
	}
}