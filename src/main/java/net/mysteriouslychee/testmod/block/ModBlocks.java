package net.mysteriouslychee.testmod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TestMod.MODID);

    private static final String bismuthBlock = "bismuth_block";
    private static final String bismuthOre = "bismuth_ore";
    private static final String bismuthDeepslateOre = "bismuth_deepslate_ore";

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock(bismuthBlock, () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthBlock)))));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock(bismuthOre, () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthOre)))));
    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock(bismuthDeepslateOre, () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthDeepslateOre)))));

    private static <T extends Block> DeferredBlock<T> registerBlock(String id, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(id, block);
        registerBlockItem(id, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String id, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(id, () -> new BlockItem(block.get(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                        ResourceLocation.parse(TestMod.MODID + ":" + id)))));
    }

    public static void register(IEventBus bus)
    {
        BLOCKS.register(bus);
    }
}
