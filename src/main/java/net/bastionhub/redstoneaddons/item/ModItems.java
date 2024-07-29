package net.bastionhub.redstoneaddons.item;

import net.bastionhub.redstoneaddons.RedstoneAddons;
import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.bastionhub.redstoneaddons.item.custom.RedstoneDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLUESTONE_DUST = registerItem("bluestone_dust", new AliasedBlockItem(ModBlocks.BLUESTONE_WIRE, new Item.Settings()));
    public static final Item GREENSTONE_DUST = registerItem("greenstone_dust", new AliasedBlockItem(ModBlocks.GREENSTONE_WIRE, new Item.Settings()));
    public static final Item YELLOWSTONE_DUST = registerItem("yellowstone_dust", new AliasedBlockItem(ModBlocks.YELLOWSTONE_WIRE, new Item.Settings()));

    public static final Item REDSTONE_DETECTOR = registerItem("redstone_detector",
            new RedstoneDetectorItem(new Item.Settings().maxDamage(256)));

    private static void AddItemsToRedstoneItemGroup(FabricItemGroupEntries entries) {

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RedstoneAddons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RedstoneAddons.LOGGER.info("Registering mod items for " + RedstoneAddons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::AddItemsToRedstoneItemGroup);
    }
}
