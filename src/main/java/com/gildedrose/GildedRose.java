package com.gildedrose;

import com.gildedrose.model.*;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()) {
                case AGED_BRIE:
                    new AgedBrie(item).update();
                    break;
                case BACKSTAGE_PASSES:
                    new BackStagePassItem(item).update();
                    break;
                case SULFURAS:
                    new SulfurasItem(item).update();
                    break;
                case CONJURED:
                    new Conjured(item).update();
                    break;
                default:
                    new NormalItem(item).update();
                    break;
            }
        }
    }
}
