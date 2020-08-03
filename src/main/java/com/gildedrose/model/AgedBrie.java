package com.gildedrose.model;

public class AgedBrie extends NormalItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.getSellIn() < 0) {
            increaseQuality(item);
        }
    }
}
