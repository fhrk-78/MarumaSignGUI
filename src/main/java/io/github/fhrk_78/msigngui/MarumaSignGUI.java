package io.github.fhrk_78.msigngui;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarumaSignGUI implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("marumasigngui");

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded: MarumaSignGUI");
	}
}