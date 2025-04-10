package com.kito1z.not_enough_oxygen.utils;

import com.kito1z.not_enough_oxygen.NotEnoughOxygen;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3i;

public class HermeticUtils {

    public static boolean isHermetic(ServerLevel level, BlockPos pos){
        BlockState state = level.getBlockState(pos);
        return state.isCollisionShapeFullBlock(level,pos);
    }
    public static boolean isHermetic(ServerLevel level, Vector3i pos){
        return isHermetic(level, new BlockPos(pos.x, pos.y, pos.z));
    }
}
