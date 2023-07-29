package dev.zestyblaze.demonology;

import dev.zestyblaze.demonology.registry.DemonologyItems;
import dev.zestyblaze.demonology.registry.DemonologyPOITypes;
import dev.zestyblaze.demonology.registry.DemonologyProfessions;
import dev.zestyblaze.demonology.registry.DemonologyStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demonology implements ModInitializer {
	public static final String MODID = "demonology";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		DemonologyItems.register();
		DemonologyPOITypes.register();
		DemonologyProfessions.register();
		DemonologyProfessions.fillTrades();
		ServerLifecycleEvents.SERVER_STARTED.register(DemonologyStructures::registerJigsaws);
	}
}