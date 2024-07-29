package net.bastionhub.redstoneaddons.item;

import net.bastionhub.redstoneaddons.RedstoneAddons;
import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup COLORSTONE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RedstoneAddons.MOD_ID, "bluestone_dust"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bluestone_dust"))
                    .icon(() -> new ItemStack(ModItems.BLUESTONE_DUST)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BLUESTONE_DUST);
                        entries.add(ModItems.GREENSTONE_DUST);
                        entries.add(ModItems.YELLOWSTONE_DUST);

                        entries.add(ModItems.REDSTONE_DETECTOR);

                        entries.add(ModBlocks.BLUESTONE_BLOCK);
                        entries.add(ModBlocks.GREENSTONE_BLOCK);
                        entries.add(ModBlocks.YELLOWSTONE_BLOCK);

                        entries.add(ModBlocks.SOUND_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        RedstoneAddons.LOGGER.info("Registering item groups for " + RedstoneAddons.MOD_ID);


    }
}
