package com.zezer.mudada.block;

import com.zezer.mudada.Mudada;
import com.zezer.mudada.item.ModItemGroup;
import com.zezer.mudada.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Mudada.MOD_ID);

    public static final RegistryObject<Block> EXPENSIVE_POTATO_BLOCK = registerBlock("expensive_potato_block",
                    () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC)
                            .harvestLevel(0).harvestTool(ToolType.HOE).setRequiresTool().hardnessAndResistance(2f)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.MUDADA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
