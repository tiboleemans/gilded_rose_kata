package com.gildedrose.model;

public class BackStagePassItem extends NormalItem {

    @Override
    public void update(Item item) {
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
