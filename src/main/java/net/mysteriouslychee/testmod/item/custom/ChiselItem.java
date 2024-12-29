package net.mysteriouslychee.testmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.component.ModDataComponents;
import org.jetbrains.annotations.NotNull;

import java.util.List;
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
    public @NotNull InteractionResult useOn(UseOnContext context)
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

               context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        if (Screen.hasShiftDown())
        {
            tooltipComponents.add(Component.translatable("tooltip." + TestMod.MODID + ".chisel.shift_down"));
        }
        else
        {
            tooltipComponents.add(Component.translatable("tooltip." + TestMod.MODID + ".chisel"));
        }

        if (stack.get(ModDataComponents.COORDINATES) != null)
        {
            tooltipComponents.add(Component.literal("Last block changed at: " + stack.get(ModDataComponents.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
