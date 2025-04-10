package com.kito1z.not_enough_oxygen.utils;

import com.kito1z.not_enough_oxygen.registry.NEOEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class VSCompat {
    public static boolean applyOxygenToVSPlayer(ServerPlayer player, BlockPos pos, HermeticArea hermeticArea){
        ServerShip ship = (ServerShip) VSGameUtilsKt.getShipManagingPos(player.level(), pos);
        if(ship==null) return false;
        Vec3 eyePosition = player.getEyePosition();
        Vector3d shipPos = ship.getTransform().getWorldToShip().transformPosition(new Vector3d(eyePosition.x, eyePosition.y, eyePosition.z));
        BlockPos shipBlockPos = new BlockPos((int)Math.floor(shipPos.x),(int)Math.floor(shipPos.y),(int)Math.floor(shipPos.z));
        if(hermeticArea.getArea().contains(shipBlockPos)) player.addEffect(new MobEffectInstance(NEOEffects.OXYGEN_SATURATION.get(), 5, 0, false, false));
        return true;
    }
}
