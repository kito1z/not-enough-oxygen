package com.kito1z.not_enough_oxygen.registry;

import com.kito1z.not_enough_oxygen.NotEnoughOxygen;
import com.kito1z.not_enough_oxygen.blocks.entity.VentBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NEOBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NotEnoughOxygen.MODID);

    public static final RegistryObject<BlockEntityType<VentBlockEntity>> VENT_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("vent",()->BlockEntityType.Builder.of(VentBlockEntity::new,NEOBlocks.VENT.get()).build(null));
}
