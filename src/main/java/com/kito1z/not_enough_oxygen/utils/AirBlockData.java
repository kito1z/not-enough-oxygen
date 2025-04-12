package com.kito1z.not_enough_oxygen.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;

public class AirBlockData extends BlockPos {
    private Direction source;

    public AirBlockData(BlockPos pos){
        super(pos.getX(),pos.getY(), pos.getZ());
    }
    public AirBlockData setSource(Direction dir){
        source = dir;
        return this;
    }
    public boolean isSource(Direction direction){
        return source==direction;
    }

    public Direction getSource() {
        return source;
    }
}
