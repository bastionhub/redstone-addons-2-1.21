package net.bastionhub.redstoneaddons.datagen;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.bastionhub.redstoneaddons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUESTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREENSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOWSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        //redstone
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(ModBlocks.BLUESTONE_WIRE)
                                .with(
                                        When.anyOf(
                                                When.create()
                                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.NONE)
                                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.NONE)
                                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.NONE)
                                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.NONE),
                                                When.create()
                                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)
                                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                                When.create()
                                                        .set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)
                                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                                When.create()
                                                        .set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)
                                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                                When.create()
                                                        .set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)
                                                        .set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP)
                                        ),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_dot"))
                                )
                                .with(
                                        When.create().set(Properties.NORTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_side0"))
                                )
                                .with(
                                        When.create().set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_side_alt0"))
                                )
                                .with(
                                        When.create().set(Properties.EAST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_side_alt1"))
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                )
                                .with(
                                        When.create().set(Properties.WEST_WIRE_CONNECTION, WireConnection.SIDE, WireConnection.UP),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_side1"))
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                )
                                .with(
                                        When.create().set(Properties.NORTH_WIRE_CONNECTION, WireConnection.UP),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_up"))
                                )
                                .with(
                                        When.create().set(Properties.EAST_WIRE_CONNECTION, WireConnection.UP),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_up"))
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                                )
                                .with(
                                        When.create().set(Properties.SOUTH_WIRE_CONNECTION, WireConnection.UP),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_up"))
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                                )
                                .with(
                                        When.create().set(Properties.WEST_WIRE_CONNECTION, WireConnection.UP),
                                        BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, ModelIds.getMinecraftNamespacedBlock("redstone_dust_up"))
                                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                                )
                );


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.REDSTONE_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUESTONE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREENSTONE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOWSTONE_DUST, Models.GENERATED);
    }
}
