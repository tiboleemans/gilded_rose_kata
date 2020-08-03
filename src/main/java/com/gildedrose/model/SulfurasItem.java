package com.gildedrose.model;

public class SulfurasItem extends NormalItem {

    @Override
    public void update(Item item) {
        item.setQuality(80);
    }
}
