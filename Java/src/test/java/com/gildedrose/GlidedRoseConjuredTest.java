package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseConjuredTest {

    @Test
    void shall_decrease_quality_by_2() {
        Item[] items = new Item[] { new Item("Conjured", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void shall_decrease_quality_four_times_as_fast_when_sellin_lower_than_0() {
        Item[] items = new Item[] { new Item("Conjured", -1, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void shall_decrease_quality_four_times_as_fast_when_sellin_equals_0() {
        Item[] items = new Item[] { new Item("Conjured", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void bug_added_with_quality_51() {
        Item[] items = new Item[] { new Item("Conjured", 10, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(58, app.items[0].quality);
    }

}
