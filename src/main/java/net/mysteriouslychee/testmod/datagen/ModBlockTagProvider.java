package net.mysteriouslychee.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.block.ModBlocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
    }
}
