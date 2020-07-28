package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final List<String> SPECIAL_ITEMS = new ArrayList<>();
    private static final List<String> LEGENDARY_ITEMS = new ArrayList<>();

    static {
        SPECIAL_ITEMS.add(AGED_BRIE);
        SPECIAL_ITEMS.add(BACKSTAGE_PASSES);

        LEGENDARY_ITEMS.add(SULFURAS);
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()) {
                case AGED_BRIE:
                case BACKSTAGE_PASSES:
                    updateValuesForSpecialItems(item);
                    item.setSellIn(item.getSellIn() - 1);
                    break;
                case SULFURAS:
                    item.setQuality(80);
                    break;
                default:
                    if (item.getQuality() > 0) {
                        item.setQuality(item.getQuality() - 1);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    break;
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!item.getName().equals(BACKSTAGE_PASSES)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals(SULFURAS)) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(0);
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    private void updateValuesForSpecialItems(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if (item.getName().equals(BACKSTAGE_PASSES)) {
                if (item.getSellIn() < 11) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }

                if (item.getSellIn() < 6) {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }
}
