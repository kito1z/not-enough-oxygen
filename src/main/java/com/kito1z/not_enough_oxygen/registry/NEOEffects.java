package com.kito1z.not_enough_oxygen.registry;

import com.kito1z.not_enough_oxygen.NotEnoughOxygen;
import com.kito1z.not_enough_oxygen.effects.OxygenMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NEOEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NotEnoughOxygen.MODID);

    public static final RegistryObject<MobEffect> OXYGEN_SATURATION = EFFECTS.register("oxygen_saturation", OxygenMobEffect::new);
}
