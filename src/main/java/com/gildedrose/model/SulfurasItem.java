package com.gildedrose.model;

public class SulfurasItem extends NormalItem {
    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        item.setQuality(80);
    }
}
