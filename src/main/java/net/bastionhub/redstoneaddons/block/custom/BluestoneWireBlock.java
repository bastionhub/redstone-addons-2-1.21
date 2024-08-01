package net.bastionhub.redstoneaddons.block.custom;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class BluestoneWireBlock extends RedstoneWireBlock {
    public BluestoneWireBlock(Settings settings) {
        super(settings);
    }

    protected static boolean connectsTo(BlockState state) {
        return connectsTo(state, null);
    }

    protected static boolean connectsTo(BlockState state, @Nullable Direction dir) {
        if (state.isOf(ModBlocks.BLUESTONE_WIRE)) {
            return true;
        } else if (state.isOf(ModBlocks.BLUESTONE_REPEATER)) {
            Direction direction = state.get(RepeaterBlock.FACING);
            return direction == dir || direction.getOpposite() == dir;
        } else {
            return state.isOf(Blocks.OBSERVER) ? dir == state.get(ObserverBlock.FACING) : state.emitsRedstonePower() && dir != null;
        }
    }
}
