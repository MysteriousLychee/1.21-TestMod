package net.mysteriouslychee.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.item.custom.ChiselItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    // Items
    private static final String bismuth = "bismuth";
    private static final String rawBismuth = "raw_bismuth";

    // Advanced Items
    private static final String chisel = "chisel";

    // Foods
    private static final String radish = "radish";

    // Fuels
    private static final String frostfireIce = "frostfire_ice";
    private static final String starlightAshes = "starlight_ashes";

    // Item registries
    public static final DeferredItem<Item> BISMUTH = ITEMS.register(bismuth, () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuth)))));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(rawBismuth, () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + rawBismuth)))));

    // Advanced item registries
    public static final DeferredItem<Item> CHISEL = ITEMS.register(chisel, () -> new ChiselItem(new Item.Properties().durability(32).rarity(Rarity.UNCOMMON)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + chisel)))));

    // Food registries
    public static final DeferredItem<Item> RADISH = ITEMS.register(radish, () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH, ModFoodConsumables.RADISH)
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + radish))))
    {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
        {
            tooltipComponents.add(Component.translatable("tooltip." + TestMod.MODID + ".radish"));
            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
    });

    // Fuel Registries
    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register(frostfireIce, () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + frostfireIce)))));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register(starlightAshes, () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + starlightAshes)))));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
