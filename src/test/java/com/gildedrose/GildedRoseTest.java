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
    void testLowerQualityValueConjuredItem() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].getQuality());
    }

    @Test
    void testDegradeQualityValueTwiceAsFastAfterSellInExpiredNormalItem() {
        Item[] items = new Item[] { new Item("normalItem", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(4, app.items[0].getQuality());

        app.updateQuality();
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(2, app.items[0].getQuality());

        app.updateQuality();
        assertEquals(-2, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());

        app.updateQuality();
        assertEquals(-3, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());
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
    void testIncreaseQualityValueSpecialItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(6, app.items[0].getQuality());
    }

    @Test
    void testIncreaseQualityTwiceAsFastExpiredSpecialItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(0, app.items[0].getSellIn());
        assertEquals(6, app.items[0].getQuality());

        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(8, app.items[0].getQuality());
    }

    @Test
    void testIncreaseQualityTwiceAsFastExpiredBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(11, app.items[0].getSellIn());
        assertEquals(6, app.items[0].getQuality());

        app.updateQuality();
        assertEquals(10, app.items[0].getSellIn());
        assertEquals(7, app.items[0].getQuality());

        app.updateQuality();
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(9, app.items[0].getQuality());

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(5, app.items[0].getSellIn());
        assertEquals(17, app.items[0].getQuality());
        app.updateQuality();
        assertEquals(4, app.items[0].getSellIn());
        assertEquals(20, app.items[0].getQuality());
    }

    @Test
    void testQualitySpecialItemNeverAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 49), new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].getName());
        assertEquals(50, app.items[0].getQuality());
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].getName());
        assertEquals(50, app.items[1].getQuality());
        app.updateQuality();
        assertEquals(50, app.items[0].getQuality());
        assertEquals(50, app.items[1].getQuality());
    }

    @Test
    void testQualityValueLegendaryItemAlways80() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].getName());
        assertEquals(80, app.items[0].getQuality());
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
