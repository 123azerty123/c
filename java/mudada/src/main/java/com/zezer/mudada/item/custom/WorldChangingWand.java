package com.zezer.mudada.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Objects;

import static java.lang.Math.random;

// TODO finir cet item avancé
public class WorldChangingWand extends Item {
    public WorldChangingWand(Properties properties) {
        super(properties);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        float count = stack.getCount();
        return stack.getMaxStackSize()/count;
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {

        World world = context.getWorld();

        if(!world.isRemote()){
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());

            BlockState clickedBlock = context.getWorld().getBlockState(context.getPos());
            rightClickWithBlockState(clickedBlock, context, playerEntity);
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickWithBlockState(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {
        if (random.nextFloat()<.1){
            context.getWorld().createExplosion(playerEntity, context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), 4.0F, Explosion.Mode.DESTROY);
        }
        else{
            switch (Objects.requireNonNull( clickedBlock.getBlock().getRegistryName() ).toString()) {
                case "minecraft:dirt":
                    context.getWorld().setBlockState(context.getPos(), Blocks.SAND.getDefaultState());

                case "minecraft:sand":
                    context.getWorld().setBlockState(context.getPos(), Blocks.BEDROCK.getDefaultState());

                default:
                    break;
            }
        }
    }
}
