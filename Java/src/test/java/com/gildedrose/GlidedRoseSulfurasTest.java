package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlidedRoseSulfurasTest {


//    An item can never have its Quality increase above 50, however "Sulfuras" is a
//      legendary item and as such its Quality is 80 and it never alters.
//    Bug: can add Sulfuras with a quality of less than 80.

    @Test
    void shall_maintain_quality_and_sellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(20, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void shall_maintain_quality_and_sellIn_when_sellIn_is_negative() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void shall_maintain_quality_and_sellIn_when_quality_is_80() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 50, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(50, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

}
