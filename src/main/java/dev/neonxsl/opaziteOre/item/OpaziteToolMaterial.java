package dev.neonxsl.opaziteOre.item;

import dev.neonxsl.opaziteOre.OpaziteOre;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class OpaziteToolMaterial {
    public static final TagKey<Item> REPAIRS_OPAZITE = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(OpaziteOre.MOD_ID, "opazite_tool_materials")
    );

    public static final ToolMaterial INSTANCE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1800,
            8.5F,
            3.5F,
            12,
            REPAIRS_OPAZITE
    );
}