package net.mysteriouslychee.testmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.mysteriouslychee.testmod.TestMod;
import net.mysteriouslychee.testmod.item.custom.ChiselItem;
import net.mysteriouslychee.testmod.item.custom.HammerItem;
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

    // Tools
    private static final String bismuthSword = "bismuth_sword";
    private static final String bismuthPickaxe = "bismuth_pickaxe";
    private static final String bismuthAxe = "bismuth_axe";
    private static final String bismuthShovel = "bismuth_shovel";
    private static final String bismuthHoe = "bismuth_hoe";
    private static final String bismuthHammer = "bismuth_hammer";

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

    // Tool registries
    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register(bismuthSword, () -> new SwordItem(ModToolTiers.BISMUTH, 1.0f, 0.0f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthSword)))));
    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register(bismuthPickaxe, () -> new PickaxeItem(ModToolTiers.BISMUTH, -2.0f, 0.0f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthPickaxe)))));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register(bismuthAxe, () -> new AxeItem(ModToolTiers.BISMUTH, 3.0f, -2.0f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthAxe)))));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register(bismuthShovel, () -> new ShovelItem(ModToolTiers.BISMUTH, -2.0f, 0.0f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthShovel)))));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register(bismuthHoe, () -> new HoeItem(ModToolTiers.BISMUTH, -2.0f, 0.0f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthHoe)))));
    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.register(bismuthHammer, () -> new HammerItem(ModToolTiers.BISMUTH, 7.0f, -2.5f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse(TestMod.MODID + ":" + bismuthHammer)))));

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
