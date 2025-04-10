package com.kito1z.not_enough_oxygen;

import com.kito1z.not_enough_oxygen.registry.NEOBlockEntities;
import com.kito1z.not_enough_oxygen.registry.NEOBlocks;
import com.kito1z.not_enough_oxygen.registry.NEOEffects;
import com.kito1z.not_enough_oxygen.registry.NEOItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(NotEnoughOxygen.MODID)
public class NotEnoughOxygen {

    public static final String MODID = "not_enough_oxygen";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NotEnoughOxygen() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        NEOBlocks.BLOCKS.register(modEventBus);
        NEOBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        NEOItems.ITEMS.register(modEventBus);
        NEOEffects.EFFECTS.register(modEventBus);
        modEventBus.addListener(NotEnoughOxygen::buildCreativeTabs);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, NEOConfig.SPEC);
    }
    public static void buildCreativeTabs(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(new ItemStack(NEOItems.OXYGEN_TANK.get()));
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(new ItemStack(NEOItems.VENT.get()));
        }
    }
    public static class ModsLoaded{
        public static final boolean VS = ModList.get().isLoaded("valkyrienskies");
    }
}
