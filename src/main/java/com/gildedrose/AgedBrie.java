package com.gildedrose;

public class AgedBrie extends NormalItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseQuality(item);
        if (item.getSellIn() < 0) {
            increaseQuality(item);
        }
    }
}
