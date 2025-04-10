package com.kito1z.not_enough_oxygen.cap;

import mekanism.api.MekanismAPI;
import mekanism.common.registries.MekanismFluids;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import org.jetbrains.annotations.NotNull;

public class OxygenTankCap extends FluidHandlerItemStack {
    /**
     * @param container The container itemStack, data is stored on it directly as NBT.
     * @param capacity  The maximum capacity of this fluid tank.
     */
    public OxygenTankCap(@NotNull ItemStack container, int capacity) {
        super(container, capacity);
    }

    @Override
    public boolean canFillFluidType(FluidStack fluid) {
        return fluid.getFluid() == MekanismFluids.OXYGEN.getFluid();
    }
}
