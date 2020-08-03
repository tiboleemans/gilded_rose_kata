package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
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
                    new AgedBrie(item).update();
                    break;
                case BACKSTAGE_PASSES:
                    decreaseSellIn(item);
                    updateQualityBackstagePasses(item);
                break;
                case SULFURAS:
                    updateQualitySulfuras(item);
                    break;
                case CONJURED:
                    decreaseSellIn(item);
                    updateQualityConjuredItem(item);
                    break;
                default:
                    decreaseSellIn(item);
                    new NormalItem(item).update();
                    break;
            }
        }
    }

    private void updateQualityConjuredItem(Item item) {
        decreaseQualityNormalItem(item);
        decreaseQualityNormalItem(item);
    }

    private void updateQualitySulfuras(Item item) {
        item.setQuality(80);
    }

    private void updateQualityBackstagePasses(Item item) {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
            return;
        }
        increaseQuality(item);
        if (item.getSellIn() < 10) {
            increaseQuality(item);
        }
        if (item.getSellIn() < 5) {
            increaseQuality(item);
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
