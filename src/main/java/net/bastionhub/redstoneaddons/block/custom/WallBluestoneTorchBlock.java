package net.bastionhub.redstoneaddons.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.WallRedstoneTorchBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Vector3f;

import static net.bastionhub.redstoneaddons.block.custom.BluestoneMethods.BluestoneTorchRandomDisplayTick;

public class WallBluestoneTorchBlock extends WallRedstoneTorchBlock {
    public WallBluestoneTorchBlock(Settings settings) {
        super(settings);
    }

    public static final Vector3f BLUE = Vec3d.unpackRgb(2048255).toVector3f();

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        BluestoneTorchRandomDisplayTick(state, world, pos, random, LIT, BLUE);
    }


}
