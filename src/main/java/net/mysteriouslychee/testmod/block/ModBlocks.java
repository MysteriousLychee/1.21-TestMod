package net.mysteriouslychee.testmod.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.block.custom.MagicBlock;
import net.mysteriouslychee.testmod.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TestMod.MODID);

    // Registry names
    private static final String bismuthBlock = "bismuth_block";
    private static final String bismuthOre = "bismuth_ore";
    private static final String bismuthDeepslateOre = "bismuth_deepslate_ore";
    private static final String magicBlock = "magic_block";
    private static final String bismuthStairs = "bismuth_stairs";
    private static final String bismuthSlab = "bismuth_slab";
    private static final String bismuthPressurePlate = "bismuth_pressure_plate";
    private static final String bismuthButton = "bismuth_button";
    private static final String bismuthFence = "bismuth_fence";
    private static final String bismuthFenceGate = "bismuth_fence_gate";
    private static final String bismuthWall = "bismuth_wall";
    private static final String bismuthDoor = "bismuth_door";
    private static final String bismuthTrapdoor = "bismuth_trapdoor";


    // Blocks
    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock(bismuthBlock, () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthBlock)))));
    public static final DeferredBlock<StairBlock> BISMUTH_STAIRS = registerBlock(bismuthStairs, () -> new StairBlock(ModBlocks.BISMUTH_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthStairs)))));
    public static final DeferredBlock<SlabBlock> BISMUTH_SLAB = registerBlock(bismuthSlab, () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthSlab)))));
    public static final DeferredBlock<PressurePlateBlock> BISMUTH_PRESSURE_PLATE = registerBlock(bismuthPressurePlate, () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthPressurePlate)))));
    public static final DeferredBlock<ButtonBlock> BISMUTH_BUTTON = registerBlock(bismuthButton, () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noCollission().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthButton)))));
    public static final DeferredBlock<FenceBlock> BISMUTH_FENCE = registerBlock(bismuthFence, () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthFence)))));
    public static final DeferredBlock<FenceGateBlock> BISMUTH_FENCE_GATE = registerBlock(bismuthFenceGate, () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthFenceGate)))));
    public static final DeferredBlock<WallBlock> BISMUTH_WALL = registerBlock(bismuthWall, () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthWall)))));
    public static final DeferredBlock<DoorBlock> BISMUTH_DOOR = registerBlock(bismuthDoor, () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthDoor)))));
    public static final DeferredBlock<TrapDoorBlock> BISMUTH_TRAPDOOR = registerBlock(bismuthTrapdoor, () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthTrapdoor)))));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock(bismuthOre, () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthOre)))));
    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock(bismuthDeepslateOre, () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + bismuthDeepslateOre)))));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock(magicBlock, () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(TestMod.MODID + ":" + magicBlock)))));


    // Helper methods
    private static <T extends Block> DeferredBlock<T> registerBlock(String id, Supplier<T> block)
    {
        DeferredBlock<T> b = BLOCKS.register(id, block);
        registerBlockItem(id, b);
        return b;
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
