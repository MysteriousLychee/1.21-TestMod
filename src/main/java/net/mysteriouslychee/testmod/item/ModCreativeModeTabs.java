package net.mysteriouslychee.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    private static final String bismuthItemsTab = "bismuth_items_tab";
    private static final String bismuthBlocksTab = "bismuth_blocks_tab";

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register(bismuthItemsTab, () -> CreativeModeTab.builder().icon(
                    () -> new ItemStack(ModItems.BISMUTH.get())).title(Component.translatable("creativetab." + TestMod.MODID + "." + bismuthItemsTab))
            .displayItems((parameters, output) ->
            {
                output.accept(ModItems.BISMUTH);
                output.accept(ModItems.RAW_BISMUTH);
            })
            .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register(bismuthBlocksTab, () -> CreativeModeTab.builder().icon(
                    () -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get())).title(Component.translatable("creativetab." + TestMod.MODID + "." + bismuthBlocksTab))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, bismuthItemsTab))
            .displayItems((parameters, output) ->
            {
                output.accept(ModBlocks.BISMUTH_BLOCK);
                output.accept(ModBlocks.BISMUTH_ORE);
                output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
            })
            .build());

    public static void register(IEventBus bus)
    {
        CREATIVE_MODE_TAB.register(bus);
    }
}