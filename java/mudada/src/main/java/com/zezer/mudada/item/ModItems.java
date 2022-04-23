package com.zezer.mudada.item;

import com.zezer.mudada.Mudada;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mudada.MOD_ID);


    public static final RegistryObject<Item> OMEGAPOTATO = ITEMS.register("omega_potato",
            () -> new Item(new Item.Properties().group(ModItemGroup.MUDADA_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
