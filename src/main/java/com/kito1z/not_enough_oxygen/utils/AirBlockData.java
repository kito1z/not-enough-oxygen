package com.kito1z.not_enough_oxygen.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;

import java.util.EnumMap;

public class AirBlockData extends BlockPos {
    private Direction source;

    public BlockPos toPos() {return new BlockPos(getX(), getY(), getZ());}

    public AirBlockData(BlockPos pos){
        super(pos.getX(),pos.getY(), pos.getZ());
    }

    public AirBlockData(int p_121869_, int p_121870_, int p_121871_) {
        super(p_121869_, p_121870_, p_121871_);
    }
    public AirBlockData(Vec3i p_121877_) {
        super(p_121877_);
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
