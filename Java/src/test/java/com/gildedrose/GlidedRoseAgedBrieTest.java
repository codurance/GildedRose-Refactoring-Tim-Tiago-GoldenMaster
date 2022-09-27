package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseAgedBrieTest {

    @Test
    void shall_increase_quality_by_1_when_sellIn_is_grater_than_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 12, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(11, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void shall_increase_quality_by_2_when_sellIn_is_0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void added_with_quality_50_doesnt_increase_quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

}
