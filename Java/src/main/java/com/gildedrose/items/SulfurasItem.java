package com.gildedrose.items;

import com.gildedrose.Item;

public class SulfurasItem extends BaseItem {

    public SulfurasItem(Item item) {
        super(item);
    }

    public static boolean is(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}
