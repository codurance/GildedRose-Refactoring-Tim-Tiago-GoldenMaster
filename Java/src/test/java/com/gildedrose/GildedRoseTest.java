package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void copy_golden_master(int sellin, int quality) {

        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", sellin, quality)
        };
        Item[] goldenItems = new Item[]{
            new Item("+5 Dexterity Vest", sellin, quality)
        };

        GildedRose app = new GildedRose(items);
        GoldenGildedRose goldenApp = new GoldenGildedRose(items);

        app.updateQuality();
        goldenApp.updateQuality();

        assertEquals(items[0].sellIn, goldenItems[0].sellIn);
        assertEquals(items[0].quality, goldenItems[0].quality);
    }

    @Test
    void golden_master() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("+5 Dexterity Vest", 10, 0), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            //new Item("Conjured Mana Cake", 3, 6)
        };

        StringBuilder outputBuilder = new StringBuilder();
        GildedRose app = new GildedRose(items);

        int days = 16;
        for (int i = 0; i < days; i++) {
            outputBuilder.append("-------- day ").append(i).append(" --------").append("\n");
            outputBuilder.append("name, sellIn, quality").append("\n");
            for (Item item : items) {
                outputBuilder.append(item).append("\n");
            }
            outputBuilder.append("\n");
            app.updateQuality();
        }

        String[] resultLines = outputBuilder.toString().split("\n");
        String[] goldenMasterLines = GOLDEN_MASTER.split("\n");

        for (int i = 0; i < goldenMasterLines.length; i++) {

            assertEquals(goldenMasterLines[i], resultLines[i], "Line " + i);

        }
    }

    private static final String GOLDEN_MASTER = "-------- day 0 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 10, 20\n" +
        "+5 Dexterity Vest, 10, 0\n" +
        "Aged Brie, 2, 0\n" +
        "Elixir of the Mongoose, 5, 7\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, 0, 20\n" +
        "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
        "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
        "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
        "\n" +
        "-------- day 1 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 9, 19\n" +
        "+5 Dexterity Vest, 9, 0\n" +
        "Aged Brie, 1, 1\n" +
        "Elixir of the Mongoose, 4, 6\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
        "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
        "\n" +
        "-------- day 2 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 8, 18\n" +
        "+5 Dexterity Vest, 8, 0\n" +
        "Aged Brie, 0, 2\n" +
        "Elixir of the Mongoose, 3, 5\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -2, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 13, 22\n" +
        "Backstage passes to a TAFKAL80ETC concert, 8, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 3, 50\n" +
        "\n" +
        "-------- day 3 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 7, 17\n" +
        "+5 Dexterity Vest, 7, 0\n" +
        "Aged Brie, -1, 4\n" +
        "Elixir of the Mongoose, 2, 4\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -3, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 12, 23\n" +
        "Backstage passes to a TAFKAL80ETC concert, 7, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 2, 50\n" +
        "\n" +
        "-------- day 4 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 6, 16\n" +
        "+5 Dexterity Vest, 6, 0\n" +
        "Aged Brie, -2, 6\n" +
        "Elixir of the Mongoose, 1, 3\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -4, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 11, 24\n" +
        "Backstage passes to a TAFKAL80ETC concert, 6, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 1, 50\n" +
        "\n" +
        "-------- day 5 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 5, 15\n" +
        "+5 Dexterity Vest, 5, 0\n" +
        "Aged Brie, -3, 8\n" +
        "Elixir of the Mongoose, 0, 2\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -5, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 10, 25\n" +
        "Backstage passes to a TAFKAL80ETC concert, 5, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, 0, 50\n" +
        "\n" +
        "-------- day 6 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 4, 14\n" +
        "+5 Dexterity Vest, 4, 0\n" +
        "Aged Brie, -4, 10\n" +
        "Elixir of the Mongoose, -1, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -6, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 9, 27\n" +
        "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
        "\n" +
        "-------- day 7 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 3, 13\n" +
        "+5 Dexterity Vest, 3, 0\n" +
        "Aged Brie, -5, 12\n" +
        "Elixir of the Mongoose, -2, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -7, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 8, 29\n" +
        "Backstage passes to a TAFKAL80ETC concert, 3, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -2, 0\n" +
        "\n" +
        "-------- day 8 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 2, 12\n" +
        "+5 Dexterity Vest, 2, 0\n" +
        "Aged Brie, -6, 14\n" +
        "Elixir of the Mongoose, -3, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -8, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 7, 31\n" +
        "Backstage passes to a TAFKAL80ETC concert, 2, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -3, 0\n" +
        "\n" +
        "-------- day 9 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 1, 11\n" +
        "+5 Dexterity Vest, 1, 0\n" +
        "Aged Brie, -7, 16\n" +
        "Elixir of the Mongoose, -4, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -9, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 6, 33\n" +
        "Backstage passes to a TAFKAL80ETC concert, 1, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -4, 0\n" +
        "\n" +
        "-------- day 10 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, 0, 10\n" +
        "+5 Dexterity Vest, 0, 0\n" +
        "Aged Brie, -8, 18\n" +
        "Elixir of the Mongoose, -5, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -10, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 5, 35\n" +
        "Backstage passes to a TAFKAL80ETC concert, 0, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -5, 0\n" +
        "\n" +
        "-------- day 11 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, -1, 8\n" +
        "+5 Dexterity Vest, -1, 0\n" +
        "Aged Brie, -9, 20\n" +
        "Elixir of the Mongoose, -6, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -11, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 4, 38\n" +
        "Backstage passes to a TAFKAL80ETC concert, -1, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, -6, 0\n" +
        "\n" +
        "-------- day 12 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, -2, 6\n" +
        "+5 Dexterity Vest, -2, 0\n" +
        "Aged Brie, -10, 22\n" +
        "Elixir of the Mongoose, -7, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -12, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 3, 41\n" +
        "Backstage passes to a TAFKAL80ETC concert, -2, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, -7, 0\n" +
        "\n" +
        "-------- day 13 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, -3, 4\n" +
        "+5 Dexterity Vest, -3, 0\n" +
        "Aged Brie, -11, 24\n" +
        "Elixir of the Mongoose, -8, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -13, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 2, 44\n" +
        "Backstage passes to a TAFKAL80ETC concert, -3, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, -8, 0\n" +
        "\n" +
        "-------- day 14 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, -4, 2\n" +
        "+5 Dexterity Vest, -4, 0\n" +
        "Aged Brie, -12, 26\n" +
        "Elixir of the Mongoose, -9, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -14, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 1, 47\n" +
        "Backstage passes to a TAFKAL80ETC concert, -4, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, -9, 0\n" +
        "\n" +
        "-------- day 15 --------\n" +
        "name, sellIn, quality\n" +
        "+5 Dexterity Vest, -5, 0\n" +
        "+5 Dexterity Vest, -5, 0\n" +
        "Aged Brie, -13, 28\n" +
        "Elixir of the Mongoose, -10, 0\n" +
        "Sulfuras, Hand of Ragnaros, 0, 80\n" +
        "Sulfuras, Hand of Ragnaros, -1, 80\n" +
        "Backstage passes to a TAFKAL80ETC concert, -15, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, 0, 50\n" +
        "Backstage passes to a TAFKAL80ETC concert, -5, 0\n" +
        "Backstage passes to a TAFKAL80ETC concert, -10, 0";

}
