package com.sn4pe.seaofpirates.item;

import com.github.alexthe666.citadel.server.item.CustomToolMaterial;
import com.sn4pe.seaofpirates.SeaOfPirates;
import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = SeaOfPirates.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SopItemRegistry {
    public static CustomToolMaterial SAILOR_CUTLASS_TOOL_MATERIAL = new CustomToolMaterial("SailorCutlass", 1, 3000, 3, 10.0F, 25);
    public static final Item SAILOR_CUTLASS = new CutlassItem(SAILOR_CUTLASS_TOOL_MATERIAL, "sailor_cutlass");

    public static final Item LOGO = new Item(new Item.Properties()).setRegistryName(SeaOfPirates.MOD_ID,"logo");
    public static final Item PARRTO_SKULL = new Item(new Item.Properties().group(SeaOfPirates.TAB_ITEMS)).setRegistryName(SeaOfPirates.MOD_ID,"parrot_skull");

    public static final BannerPattern PATTERN_PARROT_SKULLL = addBanner("parrot_skull");

    private static BannerPattern addBanner(String name) {
        return BannerPattern.create(name.toUpperCase(), name, "seaofpirates." + name, true);
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BannerPatternItem(PATTERN_PARROT_SKULLL, (new Item.Properties()).maxStackSize(1).group(SeaOfPirates.TAB_ITEMS)).setRegistryName(SeaOfPirates.MOD_ID,"banner_pattern_parrot_skull"));

        try {
            for (Field f : SopItemRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Item) {
                    event.getRegistry().register((Item) obj);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
