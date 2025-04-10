package com.kito1z.not_enough_oxygen.registry;

import com.kito1z.not_enough_oxygen.NotEnoughOxygen;
import com.kito1z.not_enough_oxygen.blocks.VentBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NEOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NotEnoughOxygen.MODID);

    public static final RegistryObject<Block> VENT = BLOCKS.register("vent",()->new VentBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().explosionResistance(6f).strength(30f)));
}
