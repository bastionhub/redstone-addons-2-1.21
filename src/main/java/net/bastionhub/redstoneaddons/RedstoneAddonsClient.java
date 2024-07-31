package net.bastionhub.redstoneaddons;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.bastionhub.redstoneaddons.block.custom.BluestoneWireBlock;
import net.bastionhub.redstoneaddons.block.custom.GreenstoneWireBlock;
import net.bastionhub.redstoneaddons.block.custom.YellowstoneWireBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class RedstoneAddonsClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {

        //bluestone
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            int power = state.get(BluestoneWireBlock.POWER);
            float float_1 = (float)power / 15.0F;
            float float_2 = float_1 * 0.6F + 0.4F;
            if (power == 0) {
                float_2 = 0.3F;
            }

            float float_3 = float_1 * float_1 * 0.7F - 0.5F;
            float float_4 = float_1 * float_1 * 0.6F - 0.7F;
            if (float_3 < 0.0F) {
                float_3 = 0.0F;
            }

            if (float_4 < 0.0F) {
                float_4 = 0.0F;
            }

            int int_2 = MathHelper.clamp((int)(float_4 * 255.0F), 0, 255);
            int int_3 = MathHelper.clamp((int)(float_3 * 255.0F), 0, 255);
            int int_4 = MathHelper.clamp((int)(float_2 * 255.0F), 0, 255);
            return -16777216 | int_2 << 16 | int_3 << 8 | int_4;
            }, ModBlocks.BLUESTONE_WIRE);

        //greenstone
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            int power = state.get(GreenstoneWireBlock.POWER);
            float float_1 = (float)power / 15.0F;
            float float_2 = float_1 * 0.6F + 0.4F;
            if (power == 0) {
                float_2 = 0.3F;
            }

            float float_3 = float_1 * float_1 * 0.7F - 0.5F;
            float float_4 = float_1 * float_1 * 0.6F - 0.7F;
            if (float_3 < 0.0F) {
                float_3 = 0.0F;
            }

            if (float_4 < 0.0F) {
                float_4 = 0.0F;
            }

            int int_2 = MathHelper.clamp((int)(float_4 * 255.0F), 0, 255);
            int int_3 = MathHelper.clamp((int)(float_2 * 255.0F), 0, 255);
            int int_4 = MathHelper.clamp((int)(float_3 * 255.0F), 0, 255);
            return -16777216 | int_2 << 16 | int_3 << 8 | int_4;
            }, ModBlocks.GREENSTONE_WIRE);

        //yellowstone
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            int power = state.get(YellowstoneWireBlock.POWER);
            float float_1 = (float)power / 15.0F;
            float float_2 = float_1 * 0.6F + 0.4F;
            if (power == 0) {
                float_2 = 0.3F;
            }

            float float_4 = float_1 * float_1 * 0.6F - 0.7F;

            if (float_4 < 0.0F) {
                float_4 = 0.0F;
            }

            int int_2 = MathHelper.clamp((int)(float_2 * 255.0F), 0, 255);
            int int_3 = MathHelper.clamp((int)(float_2 * 255.0F), 0, 255);
            int int_4 = MathHelper.clamp((int)(float_4 * 255.0F), 0, 255);
            return -16777216 | int_2 << 16 | int_3 << 8 | int_4;
            }, ModBlocks.YELLOWSTONE_WIRE);
    }
}
