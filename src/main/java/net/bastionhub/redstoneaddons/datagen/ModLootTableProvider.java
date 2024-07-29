package net.bastionhub.redstoneaddons.datagen;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLUESTONE_BLOCK);
        addDrop(ModBlocks.GREENSTONE_BLOCK);
        addDrop(ModBlocks.YELLOWSTONE_BLOCK);
        addDrop(ModBlocks.BLUESTONE_WIRE);
        addDrop(ModBlocks.GREENSTONE_WIRE);
        addDrop(ModBlocks.YELLOWSTONE_WIRE);
    }
}
