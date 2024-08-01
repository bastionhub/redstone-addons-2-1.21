package net.bastionhub.redstoneaddons.block.custom;

import net.bastionhub.redstoneaddons.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.RepeaterBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class BluestoneRepeaterBlock extends RepeaterBlock {
    public BluestoneRepeaterBlock(Settings settings) {
        super(settings);
    }

    public static final Vector3f BLUE = Vec3d.unpackRgb(2048255).toVector3f();

    protected int getPower(World world, BlockPos pos, BlockState state) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction);
        int i = world.getEmittedRedstonePower(blockPos, direction);
        if (i >= 15) {
            return i;
        } else {
            BlockState blockState = world.getBlockState(blockPos);
            return Math.max(i, blockState.isOf(ModBlocks.BLUESTONE_WIRE) ? (Integer)blockState.get(RedstoneWireBlock.POWER) : 0);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(POWERED)) {
            Direction direction = state.get(FACING);
            double d = (double)pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            double e = (double)pos.getY() + 0.4 + (random.nextDouble() - 0.5) * 0.2;
            double f = (double)pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            float g = -5.0F;
            if (random.nextBoolean()) {
                g = (float)(state.get(DELAY) * 2 - 1);
            }

            g /= 16.0F;
            double h = g * (float)direction.getOffsetX();
            double i = g * (float)direction.getOffsetZ();
            world.addParticle(new DustParticleEffect(BLUE, 1f), d + h, e, f + i, 0.0, 0.0, 0.0);
        }
    }
}
