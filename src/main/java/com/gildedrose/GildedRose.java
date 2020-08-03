package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateService;

class GildedRose {

    private final UpdateService updateService;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updateService = new UpdateService();
    }

    public void updateQuality() {
        for (Item item : items) {
            updateService.doUpdate(item);
        }
    }
}
