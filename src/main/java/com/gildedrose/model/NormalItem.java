package com.gildedrose.model;

public class NormalItem {

    public static final int MAX_QUALITY = 50;

    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQualityNormalItem(item);
    }

    protected void increaseQuality(Item item) {
        if (item.getQuality() >= MAX_QUALITY) {
            return;
        }
        item.setQuality(item.getQuality() + 1);
    }

    protected void decreaseQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    protected void decreaseSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    protected void decreaseQualityNormalItem(Item item) {
        if (item.getQuality() > 0) {
            decreaseQuality(item);
        }
        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            decreaseQuality(item);
        }
    }
}
