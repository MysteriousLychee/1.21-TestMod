package net.mysteriouslychee.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.block.ModBlocks;
import net.mysteriouslychee.testmod.item.ModItems;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    protected ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput output)
    {
        super(provider, output);
    }

    @Override
    protected void buildRecipes()
    {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.BISMUTH, 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.BISMUTH_BLOCK)).save(output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.BISMUTH, 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK)).save(output, TestMod.MODID + ":bismuth_from_magic_block");

        this.oreSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        this.oreBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth");

        stairBuilder(ModBlocks.BISMUTH_STAIRS.get(), Ingredient.of(ModItems.BISMUTH)).group("bismuth").unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB.get(), ModBlocks.BISMUTH_BLOCK.get());

        buttonBuilder(ModBlocks.BISMUTH_BUTTON.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(output);
        pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), ModItems.BISMUTH.get());

        fenceBuilder(ModBlocks.BISMUTH_FENCE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(output);
        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(output);
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL.get(), ModItems.BISMUTH.get());

        doorBuilder(ModBlocks.BISMUTH_DOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(output);
        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(output);
    }



    protected void oreSmelting(List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        this.oreCooking(RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected void oreBlasting(List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        this.oreCooking(RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeSerializer<T> p_251817_, AbstractCookingRecipe.Factory<T> p_312707_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for (ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_, p_312707_)
                    .group(p_251450_)
                    .unlockedBy(getHasName(itemlike), this.has(itemlike))
                    .save(this.output, TestMod.MODID + ":" + getItemName(p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }
    }



    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new ModRecipeProvider(provider, output);
        }

        @Override
        public String getName()
        {
            return "";
        }
    }
}
