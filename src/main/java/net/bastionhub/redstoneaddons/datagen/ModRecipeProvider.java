package net.bastionhub.redstoneaddons.datagen;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.bastionhub.redstoneaddons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BLUESTONE_DUST,
                RecipeCategory.REDSTONE, ModBlocks.BLUESTONE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GREENSTONE_DUST,
                RecipeCategory.REDSTONE, ModBlocks.GREENSTONE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.YELLOWSTONE_DUST,
                RecipeCategory.REDSTONE, ModBlocks.YELLOWSTONE_BLOCK);
    }
}
