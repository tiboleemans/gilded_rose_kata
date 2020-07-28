package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
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
                    decreaseSellIn(item);
                    increaseQuality(item);
                    if (item.getSellIn() < 0) {
                        increaseQuality(item);
                    }
                    break;
                case BACKSTAGE_PASSES:
                    decreaseSellIn(item);
                    if (item.getSellIn() < 0) {
                        item.setQuality(0);
                        break;
                    }
                    increaseQuality(item);
                    if (item.getSellIn() < 10) {
                        increaseQuality(item);
                    }
                    if (item.getSellIn() < 5) {
                        increaseQuality(item);
                    }
                    break;
                case SULFURAS:
                    item.setQuality(80);
                    break;
                case CONJURED:
                    decreaseSellIn(item);
                    decreaseQualityNormalItem(item);
                    decreaseQualityNormalItem(item);
                    break;
                default:
                    decreaseSellIn(item);
                    decreaseQualityNormalItem(item);
                    break;
            }
        }
    }

    private void decreaseQualityNormalItem(Item item) {
        if (item.getQuality() > 0) {
            decreaseQuality(item);
        }
        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    private void decreaseSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() >= MAX_QUALITY) {
            return;
        }
        item.setQuality(item.getQuality() + 1);
    }
}
