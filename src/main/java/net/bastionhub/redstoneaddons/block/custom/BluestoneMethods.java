package net.bastionhub.redstoneaddons.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class BluestoneMethods {

    static void BluestoneTorchRandomDisplayTick(BlockState state, World world, BlockPos pos, Random random, BooleanProperty lit, Vector3f blue) {
        if (state.get(lit)) {
            double d = (double)pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            double e = (double)pos.getY() + 0.7 + (random.nextDouble() - 0.5) * 0.2;
            double f = (double)pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
            world.addParticle(new DustParticleEffect(blue, 1f), d, e, f, 0.0, 0.0, 0.0);
        }
    }


}
