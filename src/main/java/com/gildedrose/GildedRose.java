package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()) {
                case AGED_BRIE:
                    updateQualitySpecialItem(item);
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                    break;
                case BACKSTAGE_PASSES:
                    updateQualitySpecialItem(item);
                    if (item.getSellIn() < 11) {
                        updateQualitySpecialItem(item);
                    }
                    if (item.getSellIn() < 6) {
                        updateQualitySpecialItem(item);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                    }
                    break;
                case SULFURAS:
                    item.setQuality(80);
                    break;
                default:
                    if (item.getQuality() > 0) {
                        item.setQuality(item.getQuality() - 1);
                    }
                    item.setSellIn(item.getSellIn() - 1);
                    if (item.getSellIn() < 0) {
                        if (item.getQuality() > 0) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                    break;
            }
        }

    }

    private void updateQualitySpecialItem(Item item) {
        if (item.getQuality() >= 50) {
            return;
        }
        item.setQuality(item.getQuality() + 1);
    }
}
