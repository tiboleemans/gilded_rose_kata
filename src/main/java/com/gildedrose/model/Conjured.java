package com.gildedrose.model;

public class Conjured extends NormalItem {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQualityNormalItem(item);
        decreaseQualityNormalItem(item);
    }
}
