package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem extends RegularItem {

    public ConjuredItem(Item item) {
        super(item, 2);
    }

    public static boolean is(Item item) {
        return item.name.equals("Conjured");
    }

}
