package dev.neonxsl.opaziteOre.block;

import dev.neonxsl.opaziteOre.OpaziteOre;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    public static final Block DEEPSLATE_OPAZITE_ORE = register("deepslate_opazite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 7), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE));
    
    public static final Block OPAZITE_BLOCK = register("opazite_block",
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
    
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OpaziteOre.MOD_ID, name));
        Block block = blockFactory.apply(properties.setId(blockKey));

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(OpaziteOre.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());

        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static void registerModBlocks() {
        OpaziteOre.LOGGER.info("Registering blocks for " + OpaziteOre.MOD_ID);
    }
}
