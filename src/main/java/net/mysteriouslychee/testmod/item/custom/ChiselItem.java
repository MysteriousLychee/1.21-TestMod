package net.mysteriouslychee.testmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ChiselItem extends Item
{
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS
            );

    public ChiselItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level lvl = context.getLevel();
        BlockState block = lvl.getBlockState(context.getClickedPos());

        if (CHISEL_MAP.containsKey(block.getBlock()))
        {
            if (!lvl.isClientSide())
            {
               lvl.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(block.getBlock()).defaultBlockState());

               context.getItemInHand().hurtAndBreak(1, ((ServerLevel) lvl), context.getPlayer(),
                       item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

               lvl.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}