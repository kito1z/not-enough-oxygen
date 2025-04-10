package com.kito1z.not_enough_oxygen.registry;

import com.kito1z.not_enough_oxygen.NotEnoughOxygen;
import com.kito1z.not_enough_oxygen.items.OxygenTank;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NEOItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NotEnoughOxygen.MODID);

    public static final RegistryObject<Item> OXYGEN_TANK = ITEMS.register("oxygen_tank",()->new OxygenTank(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VENT = ITEMS.register("vent", ()-> new BlockItem(NEOBlocks.VENT.get(), new Item.Properties()));
}
