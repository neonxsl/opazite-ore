package dev.neonxsl.opaziteOre.item;

import dev.neonxsl.opaziteOre.OpaziteOre;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    public static final Item OPAZITE = register("opazite", Item::new, new Item.Properties());

    public static final Item OPAZITE_SWORD = register("opazite_sword", Item::new,
            new Item.Properties().sword(OpaziteToolMaterial.INSTANCE, 3.0F, -2.4F));

    public static final Item OPAZITE_PICKAXE = register("opazite_pickaxe", Item::new,
            new Item.Properties().pickaxe(OpaziteToolMaterial.INSTANCE, 1.0F, -2.8F));

    public static final Item OPAZITE_AXE = register("opazite_axe", Item::new,
            new Item.Properties().axe(OpaziteToolMaterial.INSTANCE, 5.0F, -3.0F));

    public static final Item OPAZITE_SHOVEL = register("opazite_shovel", Item::new,
            new Item.Properties().shovel(OpaziteToolMaterial.INSTANCE, 1.5F, -3.0F));

    public static final Item OPAZITE_HOE = register("opazite_hoe", Item::new,
            new Item.Properties().hoe(OpaziteToolMaterial.INSTANCE, -3.0F, 0.0F));

    public static final Item OPAZITE_HELMET = register("opazite_helmet", Item::new,
            new Item.Properties().humanoidArmor(OpaziteArmorMaterial.INSTANCE, ArmorType.HELMET));

    public static final Item OPAZITE_CHESTPLATE = register("opazite_chestplate", Item::new,
            new Item.Properties().humanoidArmor(OpaziteArmorMaterial.INSTANCE, ArmorType.CHESTPLATE));

    public static final Item OPAZITE_LEGGINGS = register("opazite_leggings", Item::new,
            new Item.Properties().humanoidArmor(OpaziteArmorMaterial.INSTANCE, ArmorType.LEGGINGS));

    public static final Item OPAZITE_BOOTS = register("opazite_boots", Item::new,
            new Item.Properties().humanoidArmor(OpaziteArmorMaterial.INSTANCE, ArmorType.BOOTS));

    private static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(OpaziteOre.MOD_ID, name)
        );
        Item item = itemFactory.apply(properties.setId(itemKey));
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    public static void registerModItems() {
        OpaziteOre.LOGGER.info("Registering items for " + OpaziteOre.MOD_ID);
    }
}