package com.gildedrose;

public class Conjured extends NormalItem {
    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn(item);
        decreaseQualityNormalItem(item);
        decreaseQualityNormalItem(item);
    }
}
