package net.mysteriouslychee.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.mysteriouslychee.testmod.TestMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                    ResourceLocation.parse(TestMod.MODID + ":" + "bismuth")))));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                    ResourceLocation.parse(TestMod.MODID + ":" + "raw_bismuth")))));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
