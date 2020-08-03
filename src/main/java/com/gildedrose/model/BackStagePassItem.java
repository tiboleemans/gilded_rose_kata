package com.gildedrose.model;

public class BackStagePassItem extends NormalItem {
    public BackStagePassItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn(item);
        updateQualityBackstagePasses(item);
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


}
