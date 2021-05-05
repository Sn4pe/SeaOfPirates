package com.sn4pe.seaofpirates.item;

import com.github.alexthe666.citadel.server.item.CustomToolMaterial;
import com.sn4pe.seaofpirates.SeaOfPirates;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class CutlassItem extends SwordItem {
    private final CustomToolMaterial toolMaterial;

    public CutlassItem(CustomToolMaterial toolmaterial, String name) {
        super(toolmaterial, 1, -1.1F, new Item.Properties().group(SeaOfPirates.TAB_ITEMS));
        this.toolMaterial = toolmaterial;
        this.setRegistryName(SeaOfPirates.MOD_ID, name);
    }
}
