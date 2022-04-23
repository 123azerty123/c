package com.zezer.mudada.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MUDADA_GROUP = new ItemGroup("mudadaTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.OMEGAPOTATO.get());
        }
    };

}
