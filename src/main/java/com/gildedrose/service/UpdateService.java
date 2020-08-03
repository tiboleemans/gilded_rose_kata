package com.gildedrose.service;

import com.gildedrose.model.*;

import java.util.HashMap;
import java.util.Map;

public class UpdateService {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    private static final Map<String, NormalItem> objectByName = new HashMap<>();

    static {
        objectByName.put(AGED_BRIE, new AgedBrie());
        objectByName.put(BACKSTAGE_PASSES, new BackStagePassItem());
        objectByName.put(SULFURAS, new SulfurasItem());
        objectByName.put(CONJURED, new Conjured());
    }

    public void doUpdate(Item item) {
        NormalItem normalItem = objectByName.get(item.getName());
        if (normalItem == null) {
            normalItem = new NormalItem();
        }
        normalItem.update(item);
    }
}
