package net.bastionhub.redstoneaddons;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.bastionhub.redstoneaddons.item.ModItemGroups;
import net.bastionhub.redstoneaddons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedstoneAddons implements ModInitializer {
	public static final String MOD_ID = "redstoneaddons";
    public static final Logger LOGGER = LoggerFactory.getLogger("redstoneaddons");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();
	}
}