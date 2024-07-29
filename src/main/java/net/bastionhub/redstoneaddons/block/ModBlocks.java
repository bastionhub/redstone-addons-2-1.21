package net.bastionhub.redstoneaddons.block;

import net.bastionhub.redstoneaddons.RedstoneAddons;
import net.bastionhub.redstoneaddons.block.custom.SoundBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLUESTONE_BLOCK = registerBlock("bluestone_block",
            new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK).mapColor(MapColor.WATER_BLUE)));
    public static final Block GREENSTONE_BLOCK = registerBlock("greenstone_block",
            new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block YELLOWSTONE_BLOCK = registerBlock("yellowstone_block",
            new Block(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK).mapColor(MapColor.YELLOW)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK).mapColor(MapColor.WATER_BLUE)));

    public static final Block BLUESTONE_WIRE = registerBlock("bluestone_wire",
            new RedstoneWireBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_WIRE).mapColor(MapColor.WATER_BLUE)));
    public static final Block GREENSTONE_WIRE = registerBlock("greenstone_wire",
            new RedstoneWireBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_WIRE).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block YELLOWSTONE_WIRE = registerBlock("yellowstone_wire",
            new RedstoneWireBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_WIRE).mapColor(MapColor.YELLOW)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RedstoneAddons.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(RedstoneAddons.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        RedstoneAddons.LOGGER.info("Registering ModBlocks for " + RedstoneAddons.MOD_ID);
        BlockRenderLayerMap.INSTANCE.putBlock(BLUESTONE_WIRE, RenderLayer.getCutout());
    }
}
