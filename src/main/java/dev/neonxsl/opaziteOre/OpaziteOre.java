package dev.neonxsl.opaziteOre;

import dev.neonxsl.opaziteOre.block.ModBlocks;
import dev.neonxsl.opaziteOre.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpaziteOre implements ModInitializer {
    public static final String MOD_ID = "opazite-ore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ResourceKey<PlacedFeature> OPAZITE_ORE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(MOD_ID, "ore_opazite_deepslate")
    );

    // Creative Tab
    public static final ResourceKey<CreativeModeTab> OPAZITE_GROUP_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            Identifier.fromNamespaceAndPath(MOD_ID, "opazite_group")
    );

    public static final CreativeModeTab OPAZITE_GROUP = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.OPAZITE))
            .title(Component.translatable("itemGroup.opazite-ore.opazite_group"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.DEEPSLATE_OPAZITE_ORE);
                output.accept(ModBlocks.OPAZITE_BLOCK);
                output.accept(ModItems.OPAZITE);
                output.accept(ModItems.OPAZITE_SWORD);
                output.accept(ModItems.OPAZITE_PICKAXE);
                output.accept(ModItems.OPAZITE_AXE);
                output.accept(ModItems.OPAZITE_SHOVEL);
                output.accept(ModItems.OPAZITE_HOE);
                output.accept(ModItems.OPAZITE_HELMET);
                output.accept(ModItems.OPAZITE_CHESTPLATE);
                output.accept(ModItems.OPAZITE_LEGGINGS);
                output.accept(ModItems.OPAZITE_BOOTS);
            })
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Opazite Ore...");

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, OPAZITE_GROUP_KEY, OPAZITE_GROUP);

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                OPAZITE_ORE_PLACED_KEY
        );
    }
}