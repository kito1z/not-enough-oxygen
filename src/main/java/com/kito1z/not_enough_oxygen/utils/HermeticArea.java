package com.kito1z.not_enough_oxygen.utils;

import com.kito1z.not_enough_oxygen.NEOConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HermeticArea {
    public static final int limit = NEOConfig.ventRange;

    private final Set<BlockPos> area = new HashSet<>();
    private boolean hermetic = false;

    public HermeticArea(){}

    public boolean bakeArea(ServerLevel level, BlockPos start){

        area.clear();
        if(HermeticUtils.isHermetic(level, start)){
            hermetic = false;
            return false;
        }

        area.add(start);

        List<BlockPos> oldLayer = new ArrayList<>();
        oldLayer.add(start);
        while (area.size() < limit && !oldLayer.isEmpty()) {
            List<BlockPos> temp = new ArrayList<>();
            for (int i = 0; i < oldLayer.size(); i++){
                if(area.size() >= limit) break;
                bakeNeighbors(level, oldLayer.get(i),temp);
            }
            oldLayer = temp;
        }
        hermetic = oldLayer.isEmpty();
        return hermetic;
    }
    public void bakeNeighbors(ServerLevel level, BlockPos pos, @Nullable List<BlockPos> temp){
        for (Direction dir : Direction.values()){
            if(area.size() >= limit) return;
            BlockPos neighbor = pos.relative(dir);
            if (!area.contains(neighbor) && !HermeticUtils.isHermetic(level, neighbor)) {
                area.add(neighbor);
                if(temp!=null) temp.add(neighbor);
            }
        }
    }

    public Set<BlockPos> getArea() {
        return area;
    }

    public boolean isHermetic() {
        return hermetic;
    }
}
