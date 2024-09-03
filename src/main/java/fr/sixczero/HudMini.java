package fr.sixczero;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HudMini implements ModInitializer {
	public static final String MOD_ID = "hudmini";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("HudMini loaded !");
	}
}