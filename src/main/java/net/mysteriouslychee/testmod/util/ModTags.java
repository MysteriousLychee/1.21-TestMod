package net.mysteriouslychee.testmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mysteriouslychee.testmod.TestMod;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createTag("needs_bismuth_tool");
        public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createTag("incorrect_for_bismuth_tool");

        private static TagKey<Block> createTag(String id)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, id));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> BISMUTH_TOOL_REPAIR = createTag("bismuth_tool_repair");

        private static TagKey<Item> createTag(String id)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, id));
        }
    }
}
