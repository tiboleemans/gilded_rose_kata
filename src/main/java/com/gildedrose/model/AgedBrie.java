package com.gildedrose.model;

public class AgedBrie extends NormalItem {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.getSellIn() < 0) {
            increaseQuality(item);
        }
    }
}
