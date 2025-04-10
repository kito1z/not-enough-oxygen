package com.kito1z.not_enough_oxygen.mixin;


import com.kito1z.not_enough_oxygen.NEOConfig;
import com.kito1z.not_enough_oxygen.registry.NEOEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class NEOPlayerMixin {
    @Shadow public abstract ServerLevel serverLevel();

    @Shadow public abstract boolean hurt(DamageSource p_9037_, float p_9038_);

    @Unique
    int not_enough_oxygen$vacuumDamageTicks = 0;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        ServerPlayer player = (ServerPlayer) (Object) this;
        if(NEOConfig.unbreathableDimensions.contains(serverLevel().dimension().location())&&!player.hasEffect(NEOEffects.OXYGEN_SATURATION.get())){
            if(not_enough_oxygen$vacuumDamageTicks<=0){
                hurt(player.damageSources().dryOut(),2f);
                not_enough_oxygen$vacuumDamageTicks = 20;
            }
            not_enough_oxygen$vacuumDamageTicks--;
        }
    }
}
