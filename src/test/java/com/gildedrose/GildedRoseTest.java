package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testLowerSellInValueNormalItem() {
        Item[] items = new Item[] { new Item("normalItem", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normalItem", app.items[0].getName());
        assertEquals(4, app.items[0].getSellIn());
    }

    @Test
    void testLowerQualityValueNormalItem() {
        Item[] items = new Item[] { new Item("normalItem", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normalItem", app.items[0].getName());
        assertEquals(4, app.items[0].getQuality());
    }

    @Test
    void testQualityNormalItemNeverNegative() {
        Item[] items = new Item[] { new Item("normalItem", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normalItem", app.items[0].getName());
        assertEquals(0, app.items[0].getQuality());
        app.updateQuality();
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    void testLowerSellInValueSpecialItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(4, app.items[0].getSellIn());
    }

    @Test
    void testIncreaseQualityValueNormalItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    void testQualitySpecialItemNeverAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(50, app.items[0].getQuality());
        app.updateQuality();
        assertEquals(50, app.items[0].getQuality());
    }

    @Test
    void testEqualQualityValueLegendaryItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(5, app.items[0].getQuality());
    }

    @Test
    void testEqualSellInValueLegendaryItem() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(5, app.items[0].getSellIn());
    }

}
