package dev.neonxsl.opaziteOre.item;

import dev.neonxsl.opaziteOre.OpaziteOre;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class OpaziteArmorMaterial {
    public static final int BASE_DURABILITY = 35;

    public static final ResourceKey<EquipmentAsset>
    OPAZITE_ARMOR_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(OpaziteOre.MOD_ID, "opazite")
    );

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            12,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.5F,
            0.05F,
            OpaziteToolMaterial.REPAIRS_OPAZITE,
            OPAZITE_ARMOR_MATERIAL_KEY
    );

}
