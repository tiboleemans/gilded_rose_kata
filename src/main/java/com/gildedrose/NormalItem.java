package com.gildedrose;

public class NormalItem {

    public static final int MAX_QUALITY = 50;

    protected final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    public void update() {
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

    private void decreaseQualityNormalItem(Item item) {
        if (item.getQuality() > 0) {
            decreaseQuality(item);
        }
        if (item.getSellIn() < 0 && item.getQuality() > 0) {
            decreaseQuality(item);
        }
    }
}
