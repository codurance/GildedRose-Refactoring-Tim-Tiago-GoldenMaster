package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseRegularItemTest {

    @Test
    void regularItem_shall_decrease_quality_by_1() {
        Item[] items = new Item[] { new Item("regularItem", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regularItem", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void regularItem_shall_decrease_quality_twice_as_fast_when_sellin_lower_than_0() {
        Item[] items = new Item[] { new Item("regularItem", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regularItem", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void regularItem_shall_decrease_quality_twice_as_fast_when_sellin_equals_0() {
        Item[] items = new Item[] { new Item("regularItem", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regularItem", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void bug_regularItem_added_with_quality_51() {
        Item[] items = new Item[] { new Item("regularItem", 10, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("regularItem", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(59, app.items[0].quality);
    }
}
